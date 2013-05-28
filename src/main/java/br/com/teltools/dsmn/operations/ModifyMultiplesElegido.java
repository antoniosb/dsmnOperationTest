package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.olmsettings.SingleRequest;

public class ModifyMultiplesElegido extends SingleRequest{
	private static String productName = 		"Elegido500";
	private static String MSISDN = 				"574545646456";
	private static String charged = 			"no";
	private static String externalData = 		"teltools";
	private static String originatingNodeInfo = "WS";
	private static String FaFIdList = 			productName.substring(productName.length()-3);
	private static String MSISDNElegidoToRegister = "573467676767";
	private static String MSISDNElegidoToReplace = 	"573721212121";
	
	public ModifyMultiplesElegido(int numberSubscribers){
		super(OlmOperation.modifyMultiplesElegido, productName, numberSubscribers );
		for(int i=0; i< numberSubscribers; i++){
			this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN, i);
			this.setRequestAttr(OlmRequestFields.charged, charged, i);
			this.setRequestAttr(OlmRequestFields.externalData, externalData, i);
			this.setRequestAttr(OlmRequestFields.originatingNodeInfo, originatingNodeInfo, i);
			this.setRequestAttr(OlmRequestFields.FaFIdList, FaFIdList, i);
			this.setRequestAttr(OlmRequestFields.MSISDNElegidoToRegister, MSISDNElegidoToRegister, i);
			this.setRequestAttr(OlmRequestFields.MSISDNElegidoToReplace, MSISDNElegidoToReplace, i);
		}
	}
		
}
