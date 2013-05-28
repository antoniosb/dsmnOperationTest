/**
 * 
 */
package br.com.teltools.dsmn.olmsettings;

import br.com.teltools.dsmn.soap.SOAPClient;

/**
 * @author Server2
 *
 */
public abstract class OlmAddress {
	//webService
	public static final String webServiceEndpoint = "http://localhost:1191/general/general.ws";
	
	private static final SOAPClient soap = new SOAPClient(webServiceEndpoint);
	
	public static SOAPClient getSoap() {
		return soap;
	}
}
