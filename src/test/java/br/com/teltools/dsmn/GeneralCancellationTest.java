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

@SuppressWarnings("unchecked")
public class GeneralCancellationTest {
	
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
		CreateNewSubscription request2 = new CreateNewSubscription();
		request2.setRequestProductName("Elegido400");
		request2.run();
		
		GeneralCancellation request = new GeneralCancellation();
		Map<String,Object> response = (Map<String,Object>)request.run().getMapResponse().get("0");
		
		assertEquals(response.get("status"), "ok");
		assertNull(response.get("errorCode"));
	}
	
	@Test
	public void mustCancelAll() throws Exception{
			GeneralCancellation request = new GeneralCancellation();
			Map<String,Object> response = (Map<String,Object>)request.run().getMapResponse().get("0");
			
			assertEquals(response.get("status"), "ok");
			assertNull(response.get("errorCode"));
	}
	
	@Test
	public void mustReturnError() throws Exception{
			GeneralCancellation request = new GeneralCancellation();
			request.setRequestAttr(OlmRequestFields.MSISDN, " ");
			Map<String, Object> response = (Map<String,Object>)request.run().getMapResponse().get("0");
			
			assertEquals(response.get("status"), "error");
			assertNotNull(response.get("errorCode"));
	}

}
