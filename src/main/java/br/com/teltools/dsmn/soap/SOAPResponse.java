package br.com.teltools.dsmn.soap;

import java.util.Map;

/**
 * Simple wrapper for a SOAP Response 
 *
 */
public class SOAPResponse {
	private boolean success;
	private String response;
	private Map<String,Object> mapResponse;

	public SOAPResponse(String response) {
		this.response = response;
		verifyError();
	}
	public SOAPResponse(Map<String,Object> mapResult){
		this.response = null;
		this.mapResponse = mapResult;
	}

	private final void verifyError() { 
		success = !response.contains("<value>error</value>");
	}

	public boolean wasSuccessful() {
		return success;
	}
	public String toString() {
		return response;
	}
	
	public Map<String, Object> getMapResponse(){
		return this.mapResponse;
	}
	
}