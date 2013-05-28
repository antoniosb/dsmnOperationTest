package br.com.teltools.dsmn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.operations.UnregisterElegido;

@SuppressWarnings("unchecked")
public class UnregisterElegidoTest {

	@Test
	public void mustReturnSuccessDefault() {
		try {
			UnregisterElegido request = new UnregisterElegido();
			
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
			UnregisterElegido request = new UnregisterElegido();
			request.setRequestAttr(OlmRequestFields.MSISDNElegidoToUnregister, "");
			Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
			
			assertEquals(response.get("status"), "error");
			assertNotNull(response.get("errorCode"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
