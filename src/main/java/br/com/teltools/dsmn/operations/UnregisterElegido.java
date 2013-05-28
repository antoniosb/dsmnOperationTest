package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;

public class UnregisterElegido extends SingleRequest{
	private static String productName = 		"Elegido500";
	private static String MSISDN = 				"574545646456";
	private static String subscriberType = 		"prepaid";
	private static String deviceType = 			"handset";
	private static String charged = 			"no";
	private static String externalData = 		"teltools";
	private static String originatingNodeInfo = "WS";
	private static String FaFIdList = 			productName.substring(productName.length()-3);
	private static String MSISDNElegidoToUnregister = "573467676767";
	
	public UnregisterElegido(){
		super(OlmOperation.registerElegido, productName );
		
		this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN);
		this.setRequestAttr(OlmRequestFields.subscriberType, subscriberType);
		this.setRequestAttr(OlmRequestFields.deviceType, deviceType);
		this.setRequestAttr(OlmRequestFields.charged, charged);
		this.setRequestAttr(OlmRequestFields.externalData, externalData);
		this.setRequestAttr(OlmRequestFields.originatingNodeInfo, originatingNodeInfo);
		this.setRequestAttr(OlmRequestFields.FaFIdList, FaFIdList);
		this.setRequestAttr(OlmRequestFields.MSISDNElegidoToUnregister, MSISDNElegidoToUnregister);
	}
		
}
