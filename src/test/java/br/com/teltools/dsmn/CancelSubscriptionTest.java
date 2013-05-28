package br.com.teltools.dsmn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

import br.com.teltools.dsmn.operations.CancelSubscription;

@SuppressWarnings("unchecked")
public class CancelSubscriptionTest {
	//active, programmed, recurrence
	
	//general single,multiple
	
	@Test
	public void mustCancelActiveSubscription() throws Exception{
		CancelSubscription request = new CancelSubscription();
		
		Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
		
		assertNotNull(response.get("status"));
		assertEquals(response.get("status"), "ok");
		assertNull(response.get("errorCode"));
	}
	
	@Test 
	public void mustReturnErrorWhenCancellingActive() throws Exception{

		CancelSubscription request = new CancelSubscription();
		request.setRequestProductName("Paquete SMS 30");
		
		Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
		
		assertEquals(response.get("status"),"error");
		assertNull(response.get("errorCode"));
		
	}


}
