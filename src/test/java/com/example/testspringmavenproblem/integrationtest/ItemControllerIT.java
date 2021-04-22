package com.example.testspringmavenproblem.integrationtest;

import com.example.testspringmavenproblem.repository.ItemRepository;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;

//IT is short for integration test
// SpringBootTest annotation launches everything that is in the current package
// or previous package annotated with SpringBootApplication
// Also launches DB and associated resources
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// having a specifiv configuration for the unit test
//@TestPropertySource(locations = {"classpath:test-configuration.properties"})
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    //if you want integration test to work with mocked external references, just MockBean and write the when statements to set behavior
//    @MockBean
//    private ItemRepository itemRepository;

    @Test
    public void contextLoads() throws JSONException {
        String response = this.restTemplate.getForObject("/all-items-from-db", String.class);
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.println(response);
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003}]", response, false);
    }
}
