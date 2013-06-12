package br.com.teltools.dsmn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.teltools.dsmn.olmsettings.OlmRequestFields;
import br.com.teltools.dsmn.operations.GetAllCommercialProducts;

@SuppressWarnings("unchecked")
public class GetAllCommercialProductsTest {
	
	@Before
	public void setUp() throws Exception{
		//?
	}
	
	@After
	public void tearDown() throws Exception{
		//?
	}

	@Test
	public void mustRetrieveAllProducts() throws Exception{
		GetAllCommercialProducts request = new GetAllCommercialProducts();

		Map<String,Object> response = request.run().getMapResponse();
		
			Map<String,Object> result = (Map<String, Object>)response.get("0");
			assertNotNull(result.get("productID"));
			assertNotNull(result.get("productName"));
			assertNotNull(result.get("productTime"));
			assertNotNull(result.get("productStartTimestamp"));
			assertNotNull(result.get("productEndTimestamp"));
			assertNotNull(result.get("productProperties"));	
	}
	
	@Test public void mustReturnError() throws Exception{
		GetAllCommercialProducts request = new GetAllCommercialProducts();
		request.setRequestAttr(OlmRequestFields.queryType, "");
		Map<String, Object> response = request.run().getMapResponse();
		Map<String,Object> result = (Map<String, Object>) response.get("0");
		assertNull(result.get("productProperties"));
		assertNotNull(result.get("errorCode"));
		assertEquals(result.get("status"),"error");
	}
	
//	@Test
//	public void mustRetrieveRegularProducts() throws Exception{
//		GetAllCommercialProducts request = new GetAllCommercialProducts();
//		request.setRequestAttr(OlmRequestFields.queryType, "regular");
//		
//		response = request.run().getMapResponse();
//		Map<String,Object> result = null;
//		for(int i=0; i< response.size(); i++){
//			result = (Map<String, Object>) response.get(i);
//			assertNotNull(result.get("productID"));
//			assertNotNull(result.get("productName"));
//			assertNotNull(result.get("productTime"));
//			assertNotNull(result.get("productStartTimestamp"));
//			assertNotNull(result.get("productEndTimestamp"));
//			assertNotNull(result.get("productProperties"));		
//			assertTrue(!Arrays.asList(((String)result.get("productProperties")).split("\\|")).contains("HIDDEN_PRODUCT"));
//		}
//		response.clear();
//	}
	
}
