package br.com.teltools.dsmn.envelope;

import br.com.teltools.dsmn.soap.SOAPClient;

/**
 * Exact name of all supported OLM Operations
 *
 */
public enum OlmOperation {
	//subscriptions
	createNewSubscription,
	cancelSubscription,
	reactivateSubscription,
	suspendSubscription,
	getSubscriptions,
	//subscribers
	changeSubscriberDetails,
	//products
	getAllCommercialProducts,
	//elegidos
	registerElegido,
	unregisterElegido,
	modifyElegido,
	renewalElegido,
	deleteElegidos,
	registerMultiplesElegido;
	
	
	//webService
	public static String webServiceEndpoint = "http://localhost:1191/general/general.ws";
	
	private static final SOAPClient soap = new SOAPClient(OlmOperation.webServiceEndpoint);
	
	public static SOAPClient getSoap() {
		return soap;
	}

	
}
