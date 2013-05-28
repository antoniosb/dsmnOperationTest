package br.com.teltools.dsmn.operations;

import br.com.teltools.dsmn.olmsettings.OlmOperation;
import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.olmsettings.SingleRequest;

public class GetAllCommercialProducts extends SingleRequest {
	
	private static String queryType = 			"all";
	
	public GetAllCommercialProducts() {
		super(OlmOperation.getAllCommercialProducts, null);
		this.setRequestAttr(OlmRequestFields.queryType, queryType);
	}
	
}
