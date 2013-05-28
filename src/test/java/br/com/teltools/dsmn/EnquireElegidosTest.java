package br.com.teltools.dsmn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

import br.com.teltools.dsmn.operations.EnquireElegidos;

@SuppressWarnings("unchecked")
public class EnquireElegidosTest {
	
	@Test
	public void mustReturnErrorDefault() throws Exception{
		
		EnquireElegidos request = new EnquireElegidos();
		request.setRequestProductName("Paquete SMS 60");
		Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
		
		assertEquals(response.get("status"),"error");
		assertNull(response.get("errorCode"));
		
	}
	
	@Test
	public void mustReturnSuccessDefault() throws Exception{
		EnquireElegidos request = new EnquireElegidos();
		
		Map<String,Object> response = (Map<String, Object>) request.run().getMapResponse().get(0);
		
		assertNotNull(response.get("productID"));
		assertNotNull(response.get("subscriptionID"));
		assertNull(response.get("errorCode"));
	}
	
}
