package br.com.teltools.dsmn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.operations.ChangeSubscriberDetails;
import br.com.teltools.dsmn.operations.CreateNewSubscription;
import br.com.teltools.dsmn.operations.GeneralCancellation;

@SuppressWarnings("unchecked")
public class ChangeSubscriberDetailsTest {
	
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
	public void mustChangeWithSuccess(){
		try {
			ChangeSubscriberDetails request = new ChangeSubscriberDetails();
			Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get("0");
			
			assertEquals(response.get("status"), "ok");
			assertNull(response.get("errorCode"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void mustChangeWithError() throws Exception{
			ChangeSubscriberDetails request = new ChangeSubscriberDetails();
			request.setRequestAttr(OlmRequestFields.MSISDN, "");
			Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get("0");
			
			assertEquals(response.get("status"), "error");
			assertNotNull(response.get("errorCode"));
	}
}
