package br.com.teltools.dsmn.soap;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Simple client to send SOAP requests
 * 
 */
public class SOAPClient {
	private static final Logger logger = Logger.getLogger(SOAPClient.class
			.getName());

	public final String urlString;

	/**
	 * Creates a SOAP Client
	 * 
	 * @param urlString
	 *            URL of a valid SOAP Endpoint
	 */
	public SOAPClient(String urlString) {
		this.urlString = urlString;
	}

	/**
	 * Sends a SOAP Request
	 * 
	 * @param request
	 *            Request to be sent
	 * @return SOAPResponse object (simple wrapper for the response)
	 * 
	 * @throws Exception
	 *             If there is any connection problem; Timeout or Connection
	 *             Refused for example (Note that if there IS a response it does
	 *             NOT throw any exception, an 'internal server error' for
	 *             instance is a valid response, not an error)
	 */
	public SOAPResponse run(SOAPRequest request) throws Exception {
		try {
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			HttpURLConnection httpConn = (HttpURLConnection) connection;

			byte[] b = toByteArray(request.getRequestString());

			// Set the appropriate HTTP parameters.
			httpConn.setRequestProperty("Content-Length",
					String.valueOf(b.length));
			httpConn.setRequestProperty("Content-Type",
					"text/xml; charset=utf-8");
			httpConn.setRequestProperty("SOAPAction", "");
			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);

			logger.info("Sending SOAP Request");
			OutputStream out = httpConn.getOutputStream();
			out.write(b);
			out.close();

			SOAPResponse response = new SOAPResponse(formatResponseAsMap(httpConn.getInputStream()));
			
			logger.info("Success!");
			return response;
		} catch (Exception e) {
			logger.info(String.format("Fail! \n%s", e));
			throw new Exception("Erro ao enviar requisicao", e);
		}
	}

	private static byte[] toByteArray(String str) {
		byte[] bytes = new byte[str.length()];
		for (int i = 0; i < str.length(); i++) {
			bytes[i] = (byte) str.charAt(i);
		}
		return bytes;
	}

	/**
	 * Helper method that formats/indents the response (for a possible
	 * pretty-print)
	 * 
	 * @param stream
	 *            Stream with the response
	 * @return String with the indented response
	 * 
	 * @throws Exception
	 *             if there is any exception while parsing or if there is an IO
	 *             Exception reading the stream
	 */
	public static String formatResponse(InputStream stream) throws Exception {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(stream);
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new StringWriter());

			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(source, result);

			return result.getWriter().toString();
		} catch (Exception e) {
			throw new Exception("Error formatting response", e);
		}
	}
	
	
	/**
	 * Helper method that puts the response inside a map (for a possible
	 * assertion of its keys/value)
	 * 
	 * @param stream
	 *            Stream with the response
	 * @return Map<String,Object> with the response
	 * 
	 * @throws Exception
	 *             if there is any exception while parsing or if there is an IO
	 *             Exception reading the stream
	 */
	public static Map<String, Object> formatResponseAsMap(InputStream stream) throws Exception {
		Map<String, Object> mapResponse = new LinkedHashMap<String, Object>();
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = docFactory.newDocumentBuilder();
			Document document = builder.parse(stream);
			document.getDocumentElement().normalize();
			NodeList response = document.getElementsByTagName("response");
			for(int i=0; i< response.getLength(); i++){
				//response
				Node responseItem = response.item(i);
				//responseID, result
				NodeList allResponseChild = responseItem.getChildNodes();
				for(int j=0; j< allResponseChild.getLength(); j++){
					//responseID, result
					Node eachResponseChild = allResponseChild.item(j);
					if(eachResponseChild.getNodeName().equals("responseID")){
						mapResponse.put("responseID", eachResponseChild.getTextContent());
						continue;
					}
					NodeList resultItem = eachResponseChild.getChildNodes();
					Map<String,Object> mapResult = new LinkedHashMap<String,Object>();
					for(int k=0; k < resultItem.getLength(); k++){
						//resultID, item
						Node eachResultItem = resultItem.item(k);
						if(eachResultItem.getNodeName().equals("resultID")){
							mapResult.put("resultID", eachResultItem.getTextContent());
							continue;
						}
						//item, key/value
						NodeList nodeItemAtResult = eachResultItem.getChildNodes();
						String key = null;
						String value = null;
						for(int c = 0; c < nodeItemAtResult.getLength(); c++){
							//key, value
							Node eachItemAtResult = nodeItemAtResult.item(c);
							if(eachItemAtResult.getNodeName().equals("key")){
								key = eachItemAtResult.getTextContent();
							}else{
								value = eachItemAtResult.getTextContent();
							}
						}
						mapResult.put(key, value);
					}
					mapResponse.put(String.valueOf(mapResult.get("resultID")), mapResult);
				}
			}
			System.out.println(mapResponse.toString());
		return mapResponse;
		} catch (Exception e) {
			throw new Exception("Error formatting response", e);
		}
	}

}