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
import br.com.teltools.dsmn.operations.RegisterMultiplesElegidoWithValidity;

@SuppressWarnings("unchecked")
public class RegisterMultiplesElegidoWithValidityTest {
	
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
		request.setRequestAttr(OlmRequestFields.mode, "MULTIPLE");
		Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get("0");
		
		assertNotNull(response.get("status"));
		assertEquals(response.get("status"), "ok");
		assertNull(response.get("errorCode"));
	}
	
	@Test
	public void mustReturnErrorDefault() throws Exception{
		RegisterMultiplesElegidoWithValidity request = new RegisterMultiplesElegidoWithValidity(2);
		request.setRequestAttr(OlmRequestFields.MSISDN, " ",1);
		
		Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get("0");
		
		assertEquals(response.get("status"),"error");
		assertNotNull(response.get("errorCode"));
		
	}
	
	@Test
	public void mustReturnSuccessDefault() throws Exception{
		RegisterMultiplesElegidoWithValidity request = new RegisterMultiplesElegidoWithValidity(2);
		
		Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get("0");
		
		assertNotNull(response.get("status"));
		assertEquals(response.get("status"), "ok");
		assertNull(response.get("errorCode"));
	}
	
}
