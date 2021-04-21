package com.example.testspringmavenproblem.controllersTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//web mvc test annotation for controller testing
@SpringBootTest
@WebAppConfiguration
class HelloWorldControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    // using matchers -
    //     .andExpect(status().isOk())
    //            .andExpect(content().string("Hello World"))
    //
    @Test
    public void helloWorld_basic() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        //call GET "/hello-world" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-world")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"))
                .andReturn();

        //verify "Hello World"
        //assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
    }

}