package br.com.teltools.dsmn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.operations.ModifyMultiplesElegido;

@SuppressWarnings("unchecked")
public class ModifyMultiplesElegidoTest {

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
			request.setRequestAttr(OlmRequestFields.MSISDNElegidoToRegister, "", 1);
			Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
			
			assertEquals(response.get("status"), "error");
			assertNotNull(response.get("errorCode"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
