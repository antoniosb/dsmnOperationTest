package br.com.teltools.dsmn.request;

import br.com.teltools.dsmn.envelope.OlmOperation;
import br.com.teltools.dsmn.soap.SOAPResponse;

public class SendRequest {
	
	//private static final SOAPClient soap = new SOAPClient(OlmOperation.webServiceEndpoint);
	
	
	
/*
 * testing purposes
 * 
 */
	public static void main(String[] args) {

		try {
			
			SingleRequest getSubscriptions = new SingleRequest(OlmOperation.getSubscriptions, null);
			getSubscriptions.setRequestAttr("MSISDN", "573126663400");
			getSubscriptions.setRequestAttr("subscriptionStatus", "all");
			getSubscriptions.setRequestAttr("getVolume", "no");
			SOAPResponse r = getSubscriptions.run();
			System.out.println(r.getMapResponse().toString());

			
//			
//			SingleRequest getAllCommercialProdcuts = new SingleRequest(OlmOperation.getAllCommercialProducts, null);
//			getAllCommercialProdcuts.setRequestAttr("queryType", "all");
//			SOAPResponse r2 = getAllCommercialProdcuts.run();
//			System.out.println(r2.getMapResponse().toString());
//			
//			
//			
//			SingleRequest registerMultiples = new SingleRequest(OlmOperation.registerMultiplesElegido, "Elegido500", 2);
//			registerMultiples.setRequestAttr("MSISDN", "57342345678", 0);
//			registerMultiples.setRequestAttr("MSISDNElegidoToRegister", "5734345678976",0);
//			registerMultiples.setRequestAttr("originatingNodeInfo", "WS",0);
//			registerMultiples.setRequestAttr("externalData", "teltools",0);
//			registerMultiples.setRequestAttr("charged", "yes",0);
//			registerMultiples.setRequestAttr("FaFIdList", "500",0);
//			registerMultiples.setRequestAttr("MSISDN", "57342345678", 1);
//			registerMultiples.setRequestAttr("MSISDNElegidoToRegister", "5734345678976",1);
//			registerMultiples.setRequestAttr("originatingNodeInfo", "WS",1);
//			registerMultiples.setRequestAttr("externalData", "teltools",1);
//			registerMultiples.setRequestAttr("charged", "yes",1);
//			registerMultiples.setRequestAttr("FaFIdList", "500",1);
//			System.out.println(registerMultiples.getRequestFormatAsString());
//			SOAPResponse r3 = registerMultiples.run();
//			System.out.println(r3.getMapResponse().toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
