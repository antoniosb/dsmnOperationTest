package br.com.teltools.dsmn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.operations.RegisterMultiplesElegido;

@SuppressWarnings("unchecked")
public class RegisterMultiplesElegidoWithValidityTest {
	
	@Test
	public void mustReturnErrorDefault() throws Exception{
		RegisterMultiplesElegido request = new RegisterMultiplesElegido(2);
		request.setRequestAttr(OlmRequestFields.validityDate, "20111221010101-0500",0);
		
		Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
		
		assertEquals(response.get("status"),"error");
		assertNull(response.get("errorCode"));
		
	}
	
	@Test
	public void mustReturnSuccessDefault() throws Exception{
		RegisterMultiplesElegido request = new RegisterMultiplesElegido(2);
		request.setRequestAttr(OlmRequestFields.MSISDNElegidoToRegister, "573456789999",1);
		request.setRequestAttr(OlmRequestFields.validityDate, "20140303120000-0500",1);
		
		Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
		
		assertNotNull(response.get("status"));
		assertEquals(response.get("status"), "ok");
		assertNull(response.get("errorCode"));
	}
	
}
