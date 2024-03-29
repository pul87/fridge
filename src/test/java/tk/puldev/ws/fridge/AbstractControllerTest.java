package tk.puldev.ws.fridge;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tk.puldev.ws.fridge.api.BaseController;

@WebAppConfiguration // Spring creerà un web application context invece che un application context
public abstract class AbstractControllerTest extends AbstractTest {

    // simula le interazioni http
    protected MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    protected void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    // Setup di mockito, consente di evitare di creare un intero
    // WebApplicationContext
    // dando la possibilità di testare solamente un controller
    protected void setup(BaseController controller) {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    protected <T> T mapFromJson(String json, Class<T> clazz)
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }

}
