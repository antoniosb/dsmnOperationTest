package br.com.teltools.dsmn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.teltools.dsmn.operations.ReSubscription;

@SuppressWarnings("unchecked")
public class ReSubscriptionTest {
	
	@Before
	public void setUp() throws Exception{
		//?
	}
	
	@After
	public void tearDown() throws Exception{
		//?
	}

//	@Test
//	public void mustReturnSuccessDefault() {
//		try {
//			ReSubscription request = new ReSubscription();
//			Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get("0");
//			
//			assertEquals(response.get("status"), "ok");
//			assertNull(response.get("errorCode"));
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void mustReturnErrorDefault() throws Exception{
			ReSubscription request = new ReSubscription();
			Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get("0");
			
			assertEquals(response.get("status"), "error");
			assertNotNull(response.get("errorCode"));
	}

}
