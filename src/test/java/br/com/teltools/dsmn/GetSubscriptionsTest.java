package br.com.teltools.dsmn;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import br.com.teltools.dsmn.envelope.OlmOperation;
import br.com.teltools.dsmn.request.SingleRequest;

public class GetSubscriptionsTest {
	
	@Test
	public void mustRetrieveActiveSubscription() throws Exception{
		SingleRequest request = new SingleRequest(OlmOperation.getSubscriptions, null);
		
		request.setRequestAttr("MSISDN", "573126663400");
		request.setRequestAttr("subscriptionStatus", "all");
		request.setRequestAttr("getVolume", "no");
		
		Map<String,Object> response = request.run().getMapResponse();
		
		String subscriptionStatus = (String) ((Map<String,Object>)response.get("0")).get("subscriptionStatus");
		
		assertEquals(subscriptionStatus, "ACTIVE");
		assertNotNull(((Map<String,Object>)response.get("0")).get("subscriptionID"));
	}

}
