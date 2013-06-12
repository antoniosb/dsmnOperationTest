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
	registerMultipleElegidoWithValidity,
	unregisterElegido,
	modifyElegido,
	modifyMultiplesElegido,
	deleteElegidos,
	renewalElegido,
	activateSubscriber,
	changeMsisdn,
	changeSubscriberDetails,
	reSubscription,
	getSubscriptions,
	getAllCommercialProducts,
	enquireElegido;
	
	public static final String GLOBAL_MSISDN = "574567890003";
	public static final String GLOBAL_PRODUCT_NAME = "Elegido100";
}

