package tk.puldev.ws.fridge.api;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import tk.puldev.ws.fridge.AbstractControllerTest;
import tk.puldev.ws.fridge.model.Refrigerator;
import tk.puldev.ws.fridge.service.RefrigeratorService;

@Transactional
public class RefrigeratorControllerTest extends AbstractControllerTest {
	
	@Autowired
	private RefrigeratorService service;
	
	@Before
    public void setup() {
        // Inizializza il MockMvc della classe astratta
        super.setup();
    }
	
	@Test
	public void testGetRefrigetors() throws Exception {
		String url = "/api/refrigerators";
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON)).andReturn();
		
		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();
		Assert.assertNotNull("expect not null", content);
		Assert.assertEquals(200, status);
		Assert.assertTrue("failure - expected http response body to have a value", content.trim().length() > 0);
		
		Collection<Refrigerator> allData = service.findAll();
		
		Assert.assertTrue("All refrigerators", allData.size() == 2);
	}
	
	@Test
	public void testGetRefrigerator() throws Exception {
		String url = "/api/refrigerators/{id}";
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(url, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
		
		int status = result.getResponse().getStatus();
		
		Assert.assertTrue(200 == status);
	}

}
