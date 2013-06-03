package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.olmsettings.SingleRequest;

public class ChangeSubscriberDetails extends SingleRequest{
	private static String MSISDN = 				OlmOperation.GLOBAL_MSISDN;
	private static String IMEI = 				"0";
	private static String ICCID = 				"0";
	private static String EMAIL = 				"teste@teltools.org";
	private static String IMSI = 				"0";
	private static String subscriberType = 		"prepaid";
	private static String deviceType = 			"handset";
	private static String externalData = 		"teltools";
	private static String originatingNodeInfo = "WS";
	private static String subscriberPaymentStatus = "ok";
	private static String registeredSubscriber = "yes";
	
	
	public ChangeSubscriberDetails() {
		super(OlmOperation.changeSubscriberDetails, null);
		
		this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN);
		this.setRequestAttr(OlmRequestFields.IMSI, IMSI);
		this.setRequestAttr(OlmRequestFields.ICCID, ICCID);
		this.setRequestAttr(OlmRequestFields.EMAIL, EMAIL);
		this.setRequestAttr(OlmRequestFields.IMEI, IMEI);
		this.setRequestAttr(OlmRequestFields.subscriberType, subscriberType);
		this.setRequestAttr(OlmRequestFields.deviceType, deviceType);
		this.setRequestAttr(OlmRequestFields.subscriberPaymentStatus, subscriberPaymentStatus);
		this.setRequestAttr(OlmRequestFields.registeredSubscriber, registeredSubscriber);
		this.setRequestAttr(OlmRequestFields.externalData, externalData);
		this.setRequestAttr(OlmRequestFields.originatingNodeInfo, originatingNodeInfo);
	}
		
	
}
