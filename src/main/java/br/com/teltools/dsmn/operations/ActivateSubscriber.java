package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.olmsettings.SingleRequest;

public class ActivateSubscriber extends SingleRequest{
	
	private static String MSISDN = "573445665786";

	public ActivateSubscriber() {
		super(OlmOperation.cancelSubscription, null);
		this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN);
	}
	
}
