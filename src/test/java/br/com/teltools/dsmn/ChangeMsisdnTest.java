package br.com.teltools.dsmn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.operations.ChangeMsisdn;
import br.com.teltools.dsmn.operations.CreateNewSubscription;
import br.com.teltools.dsmn.operations.GeneralCancellation;

@SuppressWarnings("unchecked")
public class ChangeMsisdnTest {
	
	@Before
	public void setUp() throws Exception{
		CreateNewSubscription request1 = new CreateNewSubscription();
		
		CreateNewSubscription request2 = new CreateNewSubscription();
		request2.setRequestAttr(OlmRequestFields.MSISDN, "574567890004");
		
		Map<String,Object> response1 = (Map<String, Object>) request1.run().getMapResponse().get("0");
		assertNotNull(response1.get("status"));
		assertEquals(response1.get("status"), "ok");
		assertNull(response1.get("errorCode"));
		
		Map<String,Object> response2 = (Map<String, Object>) request2.run().getMapResponse().get("0");
		assertNotNull(response2.get("status"));
		assertEquals(response2.get("status"), "ok");
		assertNull(response2.get("errorCode"));
	}
	
	@After
	public void tearDown() throws Exception{
		GeneralCancellation request1 = new GeneralCancellation();
		GeneralCancellation request2 = new GeneralCancellation();
		request2.setRequestAttr(OlmRequestFields.MSISDN, "574567890004");
		
		Map<String,Object> response1 = (Map<String, Object>) request1.run().getMapResponse().get("0");
		assertNotNull(response1.get("status"));
		assertEquals(response1.get("status"), "ok");
		assertNull(response1.get("errorCode"));
		
		Map<String,Object> response2 = (Map<String, Object>) request2.run().getMapResponse().get("0");
		assertNotNull(response2.get("status"));
		assertEquals(response2.get("status"), "ok");
		assertNull(response2.get("errorCode"));
	}
	

	@Test
	public void mustReturnSuccessDefault() throws Exception {
			ChangeMsisdn request = new ChangeMsisdn();
			Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get("0");
			
			assertEquals(response.get("status"), "ok");
			assertNull(response.get("errorCode"));
	}
	
	@Test
	public void mustReturnErrorDefault() throws Exception{
			ChangeMsisdn request = new ChangeMsisdn();
			request.setRequestAttr(OlmRequestFields.MSISDNElegidoToReplace, "");
			Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get("0");
			
			assertEquals(response.get("status"), "error");
			assertNotNull(response.get("errorCode"));
	}

}
