package br.com.teltools.dsmn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.teltools.dsmn.operations.CreateNewSubscription;
import br.com.teltools.dsmn.operations.GeneralCancellation;

@SuppressWarnings("unchecked")
public class CreateNewSubscriptionTest {
	
	@Before
	public void setUp() throws Exception{
		//?
	}
	
	@After
	public void tearDown() throws Exception{
		GeneralCancellation request = new GeneralCancellation();
		
		Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
		
		assertNotNull(response.get("status"));
		assertEquals(response.get("status"), "ok");
		assertNull(response.get("errorCode"));
	}
	
	@Test
	public void mustReturnErrorDefault() throws Exception{
		CreateNewSubscription request = new CreateNewSubscription();
		request.setRequestProductName("mwahahaha");
		
		Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
		
		assertEquals(response.get("status"),"error");
		assertNull(response.get("errorCode"));
		
	}
	
	@Test
	public void mustReturnSuccessDefault() throws Exception{
		CreateNewSubscription request = new CreateNewSubscription();
		
		Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
		
		assertNotNull(response.get("status"));
		assertEquals(response.get("status"), "ok");
		assertNull(response.get("errorCode"));
	}
	
}
