package br.com.teltools.dsmn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;

import br.com.teltools.dsmn.operations.GeneralCancellation;

@SuppressWarnings("unchecked")
public class GeneralCancellationTest {
	
	@Test
	public void mustCancelAll(){
		try {
			GeneralCancellation request = new GeneralCancellation();
			Map<String,Object> response = (Map<String,Object>)request.run().getMapResponse().get(0);
			
			assertEquals(response.get("status"), "ok");
			assertNull(response.get("errorCode"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void mustReturnError(){
		try {
			GeneralCancellation request = new GeneralCancellation();
			Map<String, Object> response = (Map<String,Object>)request.run().getMapResponse().get(0);
			
			assertEquals(response.get("status"), "error");
			assertNotNull(response.get("errorCode"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
