package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.olmsettings.SingleRequest;

public class ActivateSubscriber extends SingleRequest{
	
	private static String MSISDN = OlmOperation.GLOBAL_MSISDN;

	public ActivateSubscriber() {
		super(OlmOperation.activateSubscriber, null);
		this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN);
	}
	
}
