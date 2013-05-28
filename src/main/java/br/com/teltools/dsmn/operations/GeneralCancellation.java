package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.olmsettings.SingleRequest;

public class GeneralCancellation extends SingleRequest{
	
	private static String MSISDN = "573445665786";
	private static String originatingNodeInfo = "WS";
	private static String externalData = "teltools";
	private static String productName = "generalCancellation";
	private static String mode = "single";
	//private static String programmedCancellationDate = "20141213090909-0500";

	public GeneralCancellation() {
		super(OlmOperation.cancelSubscription, productName);
		this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN);
		this.setRequestAttr(OlmRequestFields.externalData, externalData);
		this.setRequestAttr(OlmRequestFields.originatingNodeInfo, originatingNodeInfo);
		this.setRequestAttr(OlmRequestFields.mode, mode);
	}
	
}
