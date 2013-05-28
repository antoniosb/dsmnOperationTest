package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;

public class GetSubscriptions extends SingleRequest{
	
	private static String MSISDN = 					"573445678987";
	private static String subscriptionStatus = 		"all";
	private static String getVolume = 				"no";
	
	public GetSubscriptions(){
		super(OlmOperation.getSubscriptions, null);
		this.setRequestAttr(OlmRequestFields.subscriptionStatus, subscriptionStatus);
		this.setRequestAttr(OlmRequestFields.getVolume, getVolume);
		this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN);
	}
}
