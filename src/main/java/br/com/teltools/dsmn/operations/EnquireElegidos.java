package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.olmsettings.SingleRequest;

public class EnquireElegidos extends SingleRequest{
	private static String MSISDN = 				OlmOperation.GLOBAL_MSISDN;
	private static String productName = 		OlmOperation.GLOBAL_PRODUCT_NAME;
	private static String IMEI = 				"0";
	private static String ICCID = 				"0";
	private static String EMAIL = 				"teste@teltools.org";
	private static String IMSI = 				"0";
	private static String subscriberType = 		"prepaid";
	private static String deviceType = 			"handset";
	private static String charged = 			"no";
	private static String externalData = 		"teltools";
	private static String originatingNodeInfo = "WS";
	private static String FaFIdList = 			productName.substring(productName.length()-3);
	
	public EnquireElegidos(){
		super(OlmOperation.enquireElegido, productName );
		
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
