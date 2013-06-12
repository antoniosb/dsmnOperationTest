package br.com.teltools.dsmn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.operations.CreateNewSubscription;
import br.com.teltools.dsmn.operations.GeneralCancellation;
import br.com.teltools.dsmn.operations.GetSubscriptions;

@SuppressWarnings("unchecked")
public class GetSubscriptionsTest {
	
	@Before
	public void setUp() throws Exception{
		CreateNewSubscription request = new CreateNewSubscription();
		Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get("0");
		
		assertNotNull(response.get("status"));
		assertEquals(response.get("status"), "ok");
		assertNull(response.get("errorCode"));
	}
	
	@After
	public void tearDown() throws Exception{
		GeneralCancellation request = new GeneralCancellation();
		
		Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get("0");
		
		assertNotNull(response.get("status"));
		assertEquals(response.get("status"), "ok");
		assertNull(response.get("errorCode"));
	}
	
	@Test
	public void mustRetrieveActiveSubscription() throws Exception{
		
		GetSubscriptions request = new GetSubscriptions();
		request.setRequestAttr(OlmRequestFields.subscriptionStatus, "active");
		
		Map<String,Object> response = request.run().getMapResponse();
		
		String subscriptionStatus = (String) ((Map<String,Object>)response.get("0")).get("subscriptionStatus");
		
		assertEquals(subscriptionStatus, "ACTIVE");
		assertNotNull(((Map<String,Object>)response.get("0")).get("subscriptionID"));
	}
	
	@Test
	public void mustRetriveAllSubscription() throws Exception{
		GetSubscriptions request = new GetSubscriptions();
		Map<String,Object> response = request.run().getMapResponse();
		
		String subscriptionStatus = (String) ((Map<String,Object>)response.get("0")).get("subscriptionStatus");
		
		assertNotNull(subscriptionStatus);
		assertNotNull(((Map<String,Object>)response.get("0")).get("subscriptionID"));
	}
	
	@Test
	public void mustRetrieveError() throws Exception{
		GetSubscriptions request = new GetSubscriptions();
		request.setRequestAttr(OlmRequestFields.subscriptionStatus, "other");
		
		
		Map<String,Object> response = request.run().getMapResponse();
		
		String status = (String) ((Map<String,Object>)response.get("0")).get("status");
		assertEquals(status, "error");
	}
	
//	@Test
//	public void mustRetrieveVolume() throws Exception{
//		GetSubscriptions request = new GetSubscriptions();
//		request.setRequestAttr(OlmRequestFields.subscriptionStatus, "active");
//		request.setRequestAttr(OlmRequestFields.getVolume, "yes");
//		
//		Map<String,Object> response = request.run().getMapResponse();
//		
//		String volume = (String) ((Map<String,Object>)response.get("0")).get("volume");
//		
//		assertNotNull(volume);
//	}
	
//	@Test
//	public void mustRetriveSuspendedSubscription() throws Exception{
//		
//		GetSubscriptions request = new GetSubscriptions();
//		request.setRequestAttr(OlmRequestFields.subscriptionStatus, "suspended");
//		
//		Map<String,Object> response = request.run().getMapResponse();
//		
//		String subscriptionStatus = (String) ((Map<String,Object>)response.get("0")).get("subscriptionStatus");
//		
//		assertEquals(subscriptionStatus, "SUSPENDED");
//		assertNotNull(((Map<String,Object>)response.get("0")).get("subscriptionID"));		
//	}
	
//	@Test
//	public void mustRetriveInactiveSubscription() throws Exception{
//		GetSubscriptions request = new GetSubscriptions();
//		request.setRequestAttr(OlmRequestFields.subscriptionStatus, "inactive");
//		
//		Map<String,Object> response = request.run().getMapResponse();
//		
//		String subscriptionStatus = (String) ((Map<String,Object>)response.get("0")).get("subscriptionStatus");
//		
//		assertEquals(subscriptionStatus, "CANCELLED");
//		assertNotNull(((Map<String,Object>)response.get("0")).get("subscriptionID"));		
//	}
	
	
//	@Test
//	public void mustRetrieveProgrammedSubscription() throws Exception{
//		GetSubscriptions request = new GetSubscriptions();
//		request.setRequestAttr(OlmRequestFields.subscriptionStatus, "programmed");
//		
//		Map<String,Object> response = request.run().getMapResponse();
//		
//		String subscriptionStatus = (String) ((Map<String,Object>)response.get("0")).get("subscriptionStatus");
//		
//		assertEquals(subscriptionStatus,"PROGRAMMED");
//		assertNotNull(((Map<String,Object>)response.get("0")).get("subscriptionID"));
//	}
	
}
