package com.example.testspringmavenproblem.classestotesttests;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JSONAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    public void jsonAssert() throws JSONException {
        String expectedResponse = "{\"id\": 1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id: 1,name:Ball,price:10,quantity:100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }
}
