package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.olmsettings.SingleRequest;

public class ChangeMsisdn extends SingleRequest{
	private static String MSISDN = 				"574545646456";
	private static String charged = 			"no";
	private static String externalData = 		"teltools";
	private static String originatingNodeInfo = "WS";
	private static String MSISDNElegidoToReplace = "573467676767";
	private static String changeType = 				"oneWay";
	
	public ChangeMsisdn(){
		super(OlmOperation.modifyElegido, null );
		
		this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN);
		this.setRequestAttr(OlmRequestFields.charged, charged);
		this.setRequestAttr(OlmRequestFields.externalData, externalData);
		this.setRequestAttr(OlmRequestFields.originatingNodeInfo, originatingNodeInfo);
		this.setRequestAttr(OlmRequestFields.MSISDNElegidoToReplace, MSISDNElegidoToReplace);
		this.setRequestAttr(OlmRequestFields.changeType, changeType);
	}
		
}
