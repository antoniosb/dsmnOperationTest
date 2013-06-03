package br.com.teltools.dsmn.operations;


import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.olmsettings.SingleRequest;

public class RegisterMultiplesElegido extends SingleRequest{
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
	private static long MSISDNElegidoToRegister = 573445665786L;
	
	public RegisterMultiplesElegido(int numberSubscribers){
		super(OlmOperation.registerMultiplesElegido, productName, numberSubscribers );
		
		for(int i=0; i< numberSubscribers; i++){
			this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN, i);
			this.setRequestAttr(OlmRequestFields.IMSI, IMSI, i);
			this.setRequestAttr(OlmRequestFields.ICCID, ICCID, i);
			this.setRequestAttr(OlmRequestFields.EMAIL, EMAIL, i);
			this.setRequestAttr(OlmRequestFields.IMEI, IMEI, i);
			this.setRequestAttr(OlmRequestFields.subscriberType, subscriberType, i);
			this.setRequestAttr(OlmRequestFields.deviceType, deviceType, i);
			this.setRequestAttr(OlmRequestFields.charged, charged, i);
			this.setRequestAttr(OlmRequestFields.externalData, externalData, i);
			this.setRequestAttr(OlmRequestFields.originatingNodeInfo, originatingNodeInfo, i);
			this.setRequestAttr(OlmRequestFields.FaFIdList, FaFIdList, i);
			this.setRequestAttr(OlmRequestFields.MSISDNElegidoToRegister, String.valueOf(++MSISDNElegidoToRegister), i);
		}
		
	}
		
}
