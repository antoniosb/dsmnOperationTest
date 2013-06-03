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
import br.com.teltools.dsmn.operations.ReactivateSubscription;
import br.com.teltools.dsmn.operations.SuspendSubscription;

@SuppressWarnings("unchecked")
public class ReactivateSubscriptionTest {
	
	@Before
	public void setUp() throws Exception{
		CreateNewSubscription request1 = new CreateNewSubscription();
		SuspendSubscription request2 = new SuspendSubscription();
		
		Map<String,Object> response1 = (Map<String, Object>) request1.run().getMapResponse().get(0);
		assertNotNull(response1.get("status"));
		assertEquals(response1.get("status"), "ok");
		assertNull(response1.get("errorCode"));
		
		Map<String,Object> response2 = (Map<String, Object>) request2.run().getMapResponse().get(0);
		assertNotNull(response2.get("status"));
		assertEquals(response2.get("status"), "ok");
		assertNull(response2.get("errorCode"));
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
	public void mustReactivateWithSuccess(){
		try {
			ReactivateSubscription request = new ReactivateSubscription();
			Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
			
			assertEquals(response.get("status"), "ok");
			assertNull(response.get("errorCode"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void mustReactivateWithError(){
		try {
			ReactivateSubscription request = new ReactivateSubscription();
			request.setRequestProductName(" ");
			
			Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
			
			assertEquals(response.get("status"), "error");
			assertNotNull(response.get("errorCode"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
