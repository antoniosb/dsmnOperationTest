package br.com.teltools.dsmn;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Map;

import org.junit.Test;

import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.operations.GetAllCommercialProducts;

@SuppressWarnings("unchecked")
public class GetAllCommercialProductsTest {
	Map<String,Object> response;

	@Test
	public void mustRetrieveAllProducts() throws Exception{
		GetAllCommercialProducts request = new GetAllCommercialProducts();
		
		
		response = request.run().getMapResponse();
		
		Map<String,Object> result = null;
		for(int i=0; i< response.size(); i++){
			result = (Map<String, Object>) response.get(i);
			assertNotNull(result.get("productID"));
			assertNotNull(result.get("productName"));
			assertNotNull(result.get("productTime"));
			assertNotNull(result.get("productStartTimestamp"));
			assertNotNull(result.get("productEndTimestamp"));
			assertNotNull(result.get("productProperties"));	
		}
		response.clear();
	}
	
	@Test
	public void mustRetrieveRegularProducts() throws Exception{
		GetAllCommercialProducts request = new GetAllCommercialProducts();
		request.setRequestAttr(OlmRequestFields.queryType, "regular");
		
		response = request.run().getMapResponse();
		Map<String,Object> result = null;
		for(int i=0; i< response.size(); i++){
			result = (Map<String, Object>) response.get(i);
			assertNotNull(result.get("productID"));
			assertNotNull(result.get("productName"));
			assertNotNull(result.get("productTime"));
			assertNotNull(result.get("productStartTimestamp"));
			assertNotNull(result.get("productEndTimestamp"));
			assertNotNull(result.get("productProperties"));		
			assertTrue(!Arrays.asList(((String)result.get("productProperties")).split("\\|")).contains("HIDDEN_PRODUCT"));
		}
		response.clear();
	}
	
	@Test public void mustReturnError() throws Exception{
		GetAllCommercialProducts request = new GetAllCommercialProducts();
		response = request.run().getMapResponse();
		Map<String,Object> result = null;
		for(int i=0; i< response.size(); i++){
			result = (Map<String, Object>) response.get(i);
			assertNull(result.get("productProperties"));
			assertNotNull(result.get("errorCode"));
			assertEquals(result.get("status"),"error");
		}
		response.clear();
	}
	
}
