package br.com.teltools.dsmn.olmsettings;


/**
 * Exact name of all supported OLM Operations
 *
 */
public enum OlmOperation {
	createNewSubscription,
	suspendSubscription,
	reactivateSubscription,
	cancelSubscription,
	generalCancellation,
	registerElegido,
	registerMultiplesElegido,
	registerMultiplesElegidoWithValidity,
	unregisterElegido,
	modifyElegido,
	modifyMultiplesElegido,
	deleteElegidos,
	renewalElegidos,
	activateSubscriber,
	changeMsisdn,
	changeSubscriberDetails,
	reSubscription,
	getSubscriptions,
	getAllCommercialProducts,
	enquireElegido;
	
	public static final String GLOBAL_MSISDN = "573445665786";
	public static final String GLOBAL_PRODUCT_NAME = "Elegido100";
}

