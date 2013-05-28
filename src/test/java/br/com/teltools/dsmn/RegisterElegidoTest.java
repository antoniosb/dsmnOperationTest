package br.com.teltools.dsmn;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.operations.RegisterElegido;

@SuppressWarnings("unchecked")
public class RegisterElegidoTest {

	@Test
	public void mustReturnSuccessDefault() {
		try {
			RegisterElegido request = new RegisterElegido();
			
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
			RegisterElegido request = new RegisterElegido();
			request.setRequestAttr(OlmRequestFields.MSISDNElegidoToRegister, "");
			Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
			
			assertEquals(response.get("status"), "error");
			assertNotNull(response.get("errorCode"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}