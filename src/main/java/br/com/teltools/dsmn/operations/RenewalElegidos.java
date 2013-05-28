package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.olmsettings.SingleRequest;

public class RenewalElegidos extends SingleRequest{
	private static String productName = 		"Elegido500";
	private static String MSISDN = 				"574545646456";
	private static String charged = 			"no";
	private static String externalData = 		"teltools";
	private static String originatingNodeInfo = "WS";
	private static String FaFIdList = 			productName.substring(productName.length()-3);
	
	public RenewalElegidos(){
		super(OlmOperation.modifyElegido, productName );
		
		this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN);
		this.setRequestAttr(OlmRequestFields.charged, charged);
		this.setRequestAttr(OlmRequestFields.externalData, externalData);
		this.setRequestAttr(OlmRequestFields.originatingNodeInfo, originatingNodeInfo);
		this.setRequestAttr(OlmRequestFields.FaFIdList, FaFIdList);
	}
		
}
