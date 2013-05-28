package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.olmsettings.SingleRequest;

public class CancelSubscription extends SingleRequest{
	
	private static String MSISDN = "573445665786";
	private static String productName = "Paquete SMS 15";
	private static String cancelType = "active";
	private static String originatingNodeInfo = "WS";
	private static String externalData = "teltools";
	
	//private static String programmedCancellationDate = "20141213090909-0500";
	//private static String nested = "first";

	public CancelSubscription() {
		super(OlmOperation.cancelSubscription, productName);
		this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN);
		this.setRequestAttr(OlmRequestFields.externalData, externalData);
		this.setRequestAttr(OlmRequestFields.originatingNodeInfo, originatingNodeInfo);
		this.setRequestAttr(OlmRequestFields.cancelType, cancelType);
		
	}
	
}
