package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.olmsettings.SingleRequest;

public class ModifyMultiplesElegido extends SingleRequest{
	private static String MSISDN = 				OlmOperation.GLOBAL_MSISDN;
	private static String productName = 		OlmOperation.GLOBAL_PRODUCT_NAME;
	private static String charged = 			"no";
	private static String externalData = 		"teltools";
	private static String originatingNodeInfo = "WS";
	private static String FaFIdList = 			productName.substring(productName.length()-3);
	private static long MSISDNElegidoToRegister = 	573445665786L;
//	private static long MSISDNElegidoToReplace = 	573445665788L;
	
	public ModifyMultiplesElegido(int numberSubscribers){
		super(OlmOperation.modifyMultiplesElegido, productName, numberSubscribers );
		for(int i=0; i< numberSubscribers; i++){
			this.setRequestAttr(OlmRequestFields.MSISDN, MSISDN, i);
			this.setRequestAttr(OlmRequestFields.charged, charged, i);
			this.setRequestAttr(OlmRequestFields.externalData, externalData, i);
			this.setRequestAttr(OlmRequestFields.originatingNodeInfo, originatingNodeInfo, i);
			this.setRequestAttr(OlmRequestFields.FaFIdList, FaFIdList, i);
			this.setRequestAttr(OlmRequestFields.MSISDNElegidoToRegister, String.valueOf(++MSISDNElegidoToRegister), i);
			this.setRequestAttr(OlmRequestFields.MSISDNElegidoToReplace, String.valueOf(MSISDNElegidoToRegister+numberSubscribers), i);
		}
	}
	
		
}
