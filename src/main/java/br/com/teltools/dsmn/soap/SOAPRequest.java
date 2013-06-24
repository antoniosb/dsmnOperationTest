package br.com.teltools.dsmn.soap;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.logging.Logger;

import br.com.teltools.dsmn.envelope.EnvRequest;
import br.com.teltools.dsmn.envelope.EnvRoot;
import br.com.teltools.dsmn.envelope.EnvSubscriber;
import br.com.teltools.dsmn.envelope.Envelop;


/**
 * SOAP Request wrapper for DSMN requests
 *
 */
public class SOAPRequest {
	private static final Logger logger = Logger.getLogger(SOAPRequest.class.getName());

	private final EnvRoot envelop;

	/**
	 * Creates a SOAP Request for the given Envelop
	 * 
	 * @param envelop Envelop for the request
	 */
	public SOAPRequest(Envelop envelop) {
		//logger.info("Creating SOAP Request");
		this.envelop = envelop.getEnvelop();
	}

	/**
	 * Transforms the Envelop provided with the constructor into a string
	 * 
	 * @return String representing this request
	 */
	public String getRequestString() {
		//logger.info("Generating SOAP Request Data");
		StringBuilder sb = new StringBuilder();
		sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webapps.online.ericsson.com\">");
		sb.append("<soapenv:Header/>");
		sb.append("<soapenv:Body>");
		sb.append("<web:dsmnRequest>");
		for (int i = 0; i < envelop.getRequests().size(); i++) {
			EnvRequest request = envelop.getRequest(i);
			sb.append("<web:request>");
			sb.append("<web:requestID>").append(i).append("</web:requestID>");
			sb.append("<web:operation>").append(request.getOperation()).append("</web:operation>");
			sb.append("<web:productName>").append(request.getProductName()).append("</web:productName>");

			//logger.info("Adding subscribers...");
			for (int j = 0; j < request.getSubscribers().size(); j++) {
				EnvSubscriber subscriber = request.getSubscriber(j);
				sb.append("<web:subscriber>");
				sb.append("<web:subscriberID>").append(j).append("</web:subscriberID>");

				for (String key : subscriber.getMap().keySet()) {
					String val = subscriber.getMap().get(key);
					if (val == null) {
						continue;
					}
					sb.append("<web:item>");
					sb.append("<web:key>").append(key).append("</web:key>");
					sb.append("<web:value>").append(val).append("</web:value>");
					sb.append("</web:item>");
				}
				sb.append("</web:subscriber>");
			}
			sb.append("</web:request>");
		}
		sb.append("</web:dsmnRequest>");
		sb.append("</soapenv:Body>");
		sb.append("</soapenv:Envelope>");

		return sb.toString();
	}

	/**
	 * Same as <code>getRequestString</code>, but formated and indented, for pretty print
	 * 
	 * @return Request as a formated string
	 * @throws Exception 
	 */
	public String getPrettyRequestString() throws Exception {
		String request = getRequestString();
		InputStream is = new ByteArrayInputStream(request.getBytes());
		return SOAPClient.formatResponse(is);
	}
}