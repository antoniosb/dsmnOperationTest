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
	
/**
 * Creates a wrapper for the response string
 * 
 * @param response
 * 				String representing the SOAP response
 */
	public SOAPResponse(String response) {
		this.response = response;
		verifyError();
	}
	
	/**
	 * Creates a wrapper for the response map
	 * 
	 * @param mapResult
	 * 			a Map representation of the response
	 */
	public SOAPResponse(Map<String,Object> mapResult){
		this.response = null;
		this.mapResponse = mapResult;
	}
	
	/**
	 * Verify if the response arrived with error
	 */
	private final void verifyError() { 
		success = !response.contains("<value>error</value>");
	}

	/**
	 * 
	 * @return a wrapper flag which contains whether the
	 * 			request were successfull
	 */
	public boolean wasSuccessful() {
		return success;
	}
	
	/**
	 * @return A String representation of the response
	 */
	public String toString() {
		return response;
	}
	
	/**
	 * 
	 * @return A map representation of the response
	 */
	public Map<String, Object> getMapResponse(){
		return this.mapResponse;
	}
	
}