package br.com.teltools.dsmn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.operations.DeleteElegidos;

@SuppressWarnings("unchecked")
public class DeleteElegidosTest {

	@Test
	public void mustSuspendWithSuccess(){
		try {
			DeleteElegidos request = new DeleteElegidos();
			request.setRequestProductName(null);	
			Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
			
			assertEquals(response.get("status"), "ok");
			assertNull(response.get("errorCode"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void mustSuspendWithError(){
		try {
			DeleteElegidos request = new DeleteElegidos();
			request.setRequestAttr(OlmRequestFields.MSISDN, "");

			Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
			
			assertEquals(response.get("status"), "error");
			assertNotNull(response.get("errorCode"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
