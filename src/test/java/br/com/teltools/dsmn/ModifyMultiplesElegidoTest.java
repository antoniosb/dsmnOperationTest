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
import br.com.teltools.dsmn.operations.ModifyMultiplesElegido;
import br.com.teltools.dsmn.operations.RegisterMultiplesElegido;

@SuppressWarnings("unchecked")
public class ModifyMultiplesElegidoTest {
	
	@Before
	public void setUp() throws Exception{
		CreateNewSubscription request1 = new CreateNewSubscription();
		RegisterMultiplesElegido request2 = new RegisterMultiplesElegido(2);
		
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
		request.setRequestAttr(OlmRequestFields.mode, "MULTIPLE");
		Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
		
		assertNotNull(response.get("status"));
		assertEquals(response.get("status"), "ok");
		assertNull(response.get("errorCode"));
	}

	@Test
	public void mustReturnSuccessDefault() {
		try {
			ModifyMultiplesElegido request = new ModifyMultiplesElegido(2);
			Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
			
			assertEquals(response.get("status"), "ok");
			assertNull(response.get("errorCode"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void mustReturnErrorDefault(){
		try {
			ModifyMultiplesElegido request = new ModifyMultiplesElegido(2);
			request.setRequestAttr(OlmRequestFields.MSISDNElegidoToReplace, "", 1);
			Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
			
			assertEquals(response.get("status"), "error");
			assertNotNull(response.get("errorCode"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
