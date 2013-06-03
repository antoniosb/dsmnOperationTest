package br.com.teltools.dsmn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.operations.ActivateSubscriber;

@SuppressWarnings("unchecked")
public class ActivateSubscriberTest {
	
	@Before
	public void setUP(){
		//?
	}
	
	@After
	public void tearDown(){
		//?
	}
	
	@Test
	public void mustReturnSuccess(){
		try {
			ActivateSubscriber request = new ActivateSubscriber();
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
			ActivateSubscriber request = new ActivateSubscriber();
			request.setRequestAttr(OlmRequestFields.MSISDN, "");
			Map<String, Object> response = (Map<String,Object>)request.run().getMapResponse().get(0);
			
			assertEquals(response.get("status"), "error");
			assertNotNull(response.get("errorCode"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
