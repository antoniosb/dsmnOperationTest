package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;

public class EnquireElegidos extends SingleRequest{
	private static String MSISDN = 				"574545646456";
	private static String IMEI = 				"0";
	private static String ICCID = 				"0";
	private static String EMAIL = 				"teste@teltools.org";
	private static String IMSI = 				"0";
	private static String subscriberType = 		"prepaid";
	private static String deviceType = 			"handset";
	private static String charged = 			"no";
	private static String externalData = 		"teltools";
	private static String originatingNodeInfo = "WS";
	private static String productName = 		"Elegido500";
	private static String FaFIdList = 			productName.substring(productName.length()-3);
	
	public EnquireElegidos(){
		super(OlmOperation.createNewSubscription, productName );
		
		this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN);
		this.setRequestAttr(OlmRequestFields.IMSI, IMSI);
		this.setRequestAttr(OlmRequestFields.ICCID, ICCID);
		this.setRequestAttr(OlmRequestFields.EMAIL, EMAIL);
		this.setRequestAttr(OlmRequestFields.IMEI, IMEI);
		this.setRequestAttr(OlmRequestFields.subscriberType, subscriberType);
		this.setRequestAttr(OlmRequestFields.deviceType, deviceType);
		this.setRequestAttr(OlmRequestFields.charged, charged);
		this.setRequestAttr(OlmRequestFields.externalData, externalData);
		this.setRequestAttr(OlmRequestFields.originatingNodeInfo, originatingNodeInfo);
		this.setRequestAttr(OlmRequestFields.FaFIdList, FaFIdList);
	}
		
}
