package com.example.testspringmavenproblem.controllersTest;

import com.example.testspringmavenproblem.business.ItemBusinessService;
import com.example.testspringmavenproblem.classestotest.Item;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebAppConfiguration
class ItemControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    ItemBusinessService itemBusinessServiceMock;

    @Test
    public void getDummyItem_basic_test() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        //call GET "/dummy-item" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

        // JSONAssert.assertEquals(expected, actual, strict);
    }


    @Test
    public void getBusinessServiceItem_basic_test() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        //call GET "/item-from-business-service" application/json

        when (itemBusinessServiceMock.retrieveHardcodedItem()).thenReturn(new Item(new Long(1), "Ball", 10, 100));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

    }


    @Test
    public void getAllItems_basic_test() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        //call GET "/all-items-from-db" application/json

        when (itemBusinessServiceMock.retrieveAllItems()).thenReturn(
                Arrays.asList
                        (new Item(new Long(1), "Ball", 10, 100)));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-db")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}]"))
                .andReturn();

    }
}