package com.example.testspringmavenproblem.different_assertion_libs;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class AssertJTest {

    @Test
    public void learning() {

        List<Integer> numbers = Arrays.asList(12,15,45);

        assertThat(numbers)
                .hasSize(3)
                .contains(12,45)
                .allMatch(x ->  x>10)
                .allMatch(x -> x<100);

        assertThat("").isEmpty();
        assertThat("ABCDE").contains("AB").endsWith("DE");

    }


}
