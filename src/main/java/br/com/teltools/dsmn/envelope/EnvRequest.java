package br.com.teltools.dsmn.envelope;

import java.util.LinkedList;
import java.util.List;


/** 
 * Structured representation the <strong>Request Element</strong> of an DSMN SOAP Envelop
 * For detailed information about the overall structure see {@link br.com.teltools.dsmn.envelope.EnvRoot}.
 * 
 * This class represents the Request, so it has an Operation,
 * a product name and a list of Subscribers
 *
 */
public class EnvRequest {
	private OlmOperation operation;
	private String productName;
	private final List<EnvSubscriber> subscribers;

	public EnvRequest(OlmOperation operation, String productName) {
		this.operation = operation;
		this.subscribers = new LinkedList<EnvSubscriber>();
		setProductName(productName);
	}

	/**
	 * Adds a subscriber to the Request
	 * 
	 * @param request EnvSubscriber to be added
	 */
	public void addSubscriber(EnvSubscriber subscriber) {
		this.subscribers.add(subscriber);
	}

	/**
	 * Sets the product name for this request
	 * 
	 * @param productName Product Name to be set
	 */
	public final void setProductName(String productName) {
		this.productName = productName == null ? "*" : productName;
	}

	/**
	 * Gets the operation for this request
	 * 
	 * @return OlmOperation name
	 */
	public OlmOperation getOperation() {
		return this.operation;
	}

	/**
	 * Gets the product name for this request
	 * 
	 * @return Product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Gets the subscriber at the specified index
	 * 
	 * @param index Index of the Subscriber element
	 * @return EnvSubscriber at the specified index
	 * 
	 * @throws ArrayIndexOutOfBoundsException if index is negative or
	 * not less than the number of subscribers
	 * 
	 */
	public EnvSubscriber getSubscriber(int index) {
		return subscribers.get(index);
	}

	/**
	 * Gets a list with all subscribers
	 * 
	 * @return Subscriber List
	 */
	public List<EnvSubscriber> getSubscribers() {
		return subscribers;
	}
}