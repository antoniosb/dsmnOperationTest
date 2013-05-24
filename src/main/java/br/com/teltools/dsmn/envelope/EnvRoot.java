package br.com.teltools.dsmn.envelope;

import java.util.LinkedList;
import java.util.List;

/**
 * Structured representation the <strong>Root</strong> of a DSMN SOAP Envelop
 * In short, DSMN requests follow the pattern:
 * <ul>
 * <li>A list of Requests</li>
 * <li>Each Request has 'operation', 'product' and a list of Subscribers</li>
 * <li>Each Subscriber has 'msisdn' and a list of Items</li>
 * <li>Each Item has a set of key->value tuples</li>
 * </ul>
 * 
 * This class represents the Root, so it has a list of Requests
 *
 */
public class EnvRoot implements Envelop{
    private final List<EnvRequest> requests;

	public EnvRoot() {
		this.requests = new LinkedList<EnvRequest>();
	}

	/**
	 * Adds a request to the Root
	 * 
	 * @param request Request to be added
	 */
	public void addRequest(EnvRequest request) {
		this.requests.add(request);
	}

	/**
	 * Gets the request at the specified index
	 * 
	 * @param index Index of the Request element
	 * @return EnvRequest at the specified index
	 * 
	 * @throws ArrayIndexOutOfBoundsException if index is negative or
	 * not less than the number of requests
	 * 
	 */
	public EnvRequest getRequest(int index) {
		return requests.get(index);
	}

	/**
	 * Gets a list with all requests
	 * 
	 * @return Request List
	 */
	public List<EnvRequest> getRequests() {
		return requests;
	}

	public EnvRoot getEnvelop() {
		return this;
	}
	
}