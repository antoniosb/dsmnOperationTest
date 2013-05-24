package br.com.teltools.dsmn.request;

import java.util.LinkedList;
import java.util.List;

import br.com.teltools.dsmn.envelope.EnvRequest;
import br.com.teltools.dsmn.envelope.EnvRoot;
import br.com.teltools.dsmn.envelope.EnvSubscriber;
import br.com.teltools.dsmn.envelope.OlmOperation;
import br.com.teltools.dsmn.soap.SOAPRequest;
import br.com.teltools.dsmn.soap.SOAPResponse;

public class SingleRequest {
	private EnvRoot envRoot;
	private List<EnvSubscriber> envSubscriber;
	private EnvRequest envRequest;
	
	public SingleRequest(OlmOperation operation, String productName) {
		initialize(operation, productName, 1);
	}
	
	public SingleRequest(OlmOperation operation, String productName, int numberSubscribers) {
		initialize(operation, productName,numberSubscribers);
	}

	private void initialize(OlmOperation operation, String productName, int numberSubscribers) {
		this.envRoot = new EnvRoot();
		this.envRequest = new EnvRequest(operation,productName);
		this.envSubscriber = new LinkedList<EnvSubscriber>();
		for(int i=0; i< numberSubscribers; i++){
			this.envSubscriber.add(new EnvSubscriber());
		}
		
		for(EnvSubscriber subscriber : envSubscriber){
			this.envRequest.addSubscriber(subscriber);
		}
		
		this.envRoot.addRequest(envRequest);
	}
	
	
	public void setRequestAttr(String key, String value, int subscriberIndex){
		this.envSubscriber.get(subscriberIndex).putVar(key, value);
	}
	public void setRequestAttr(String key, String value){
		this.envSubscriber.get(0).putVar(key, value);
	}

	
	public SOAPRequest getWebRequest(){
		return new SOAPRequest(envRoot);
	}
	
	public SOAPResponse run() throws Exception{
		return OlmOperation.getSoap().run(this.getWebRequest());
	}

	
	public String getRequestFormatAsString(){
		 SOAPRequest req = new SOAPRequest(envRoot);
		 return req.getRequestString();
	}

}
