package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.olmsettings.SingleRequest;

public class SuspendSubscription extends SingleRequest{
	
	private static String MSISDN = OlmOperation.GLOBAL_MSISDN;
	private static String productName = OlmOperation.GLOBAL_PRODUCT_NAME;
	private static String originatingNodeInfo = "WS";
	private static String externalData = "teltools";
	
	//private static String programmedSuspensionDate = "20141213090909-0500";

	public SuspendSubscription() {
		super(OlmOperation.suspendSubscription, productName);
		this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN);
		this.setRequestAttr(OlmRequestFields.externalData, externalData);
		this.setRequestAttr(OlmRequestFields.originatingNodeInfo, originatingNodeInfo);
		
	}
	

}
