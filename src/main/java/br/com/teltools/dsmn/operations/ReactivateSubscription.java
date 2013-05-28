package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;

public class ReactivateSubscription extends SingleRequest{
	
	private static String productName = "Paquete SMS 15";
	private static String MSISDN = "573445665786";
	private static String originatingNodeInfo = "WS";
	private static String externalData = "teltools";
	
	//private static String programmedActivationDate = "20141213090909-0500";

	public ReactivateSubscription() {
		super(OlmOperation.reactivateSubscription, productName);
		this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN);
		this.setRequestAttr(OlmRequestFields.externalData, externalData);
		this.setRequestAttr(OlmRequestFields.originatingNodeInfo, originatingNodeInfo);
		
	}
	

}