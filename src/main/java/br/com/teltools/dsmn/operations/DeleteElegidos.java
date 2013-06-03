package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.olmsettings.SingleRequest;

public class DeleteElegidos extends SingleRequest{
	
	private static String MSISDN = OlmOperation.GLOBAL_MSISDN;
	private static String productName = OlmOperation.GLOBAL_PRODUCT_NAME;
	private static String originatingNodeInfo = "WS";
	private static String externalData = "teltools";
	private static String charged = "no";
	
	public DeleteElegidos() {
		super(OlmOperation.deleteElegidos, productName);
		this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN);
		this.setRequestAttr(OlmRequestFields.externalData, externalData);
		this.setRequestAttr(OlmRequestFields.originatingNodeInfo, originatingNodeInfo);
		this.setRequestAttr(OlmRequestFields.charged, charged);
		
	}
	

}
