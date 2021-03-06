package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.olmsettings.SingleRequest;

public class ReSubscription extends SingleRequest{
	
	private static String MSISDN = OlmOperation.GLOBAL_MSISDN;
	private static String productName = OlmOperation.GLOBAL_PRODUCT_NAME;
	private static String IMEI = "0";
	private static String originatingNodeInfo = "WS";
	private static String externalData = "teltools";
	private static String subscriptionID = "12345";
	private static String productID = "64";
	private static String charged = "no";

	public ReSubscription() {
		super(OlmOperation.reSubscription, productName);
		this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN);
		this.setRequestAttr(OlmRequestFields.externalData, externalData);
		this.setRequestAttr(OlmRequestFields.originatingNodeInfo, originatingNodeInfo);
		this.setRequestAttr(OlmRequestFields.IMEI, IMEI);
		this.setRequestAttr(OlmRequestFields.subscriptionID, subscriptionID);
		this.setRequestAttr(OlmRequestFields.productID, productID);
		this.setRequestAttr(OlmRequestFields.charged, charged);
		
	}
	
}
