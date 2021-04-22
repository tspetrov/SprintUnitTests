package com.example.testspringmavenproblem.json_path_test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathPtest {

    @Test
    public void testJsonPath () {

        String responseFromService = "[\n" +
                "  {\n" +
                "    \"id\" : 10000,\n" +
                "    \"name\" : \"Pencil\",\n" +
                "    \"quantity\" : 20\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\" : 10001,\n" +
                "    \"name\" : \"Pen\",\n" +
                "    \"quantity\" : 10\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\" : 10002,\n" +
                "    \"name\" : \"Hammer\",\n" +
                "    \"quantity\" : 2\n" +
                "  }\n" +
                "]";

        DocumentContext context = JsonPath.parse(responseFromService);
        assertThat((int)context.read("$.length()")).isEqualTo(3);
        List<Integer> ids = context.read("$..id");
        System.out.println(ids.toString());
        assertThat(ids).containsExactly(10000,10001,10002);

        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:2]").toString());
        System.out.println(context.read("$.[?(@.name=='Hammer')]").toString());

        // Way 1 to read from the file
//        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("src/main/resources/jsonData.json"))) {
//            do {
//                System.out.println(bufferedReader.readLine());
//            } while (bufferedReader.readLine() != null);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // Way 2
//        System.out.println(Files.readAllLines(Paths.get("src/main/resources/jsonData.json")));

    }
}
