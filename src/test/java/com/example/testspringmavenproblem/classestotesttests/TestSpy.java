package com.example.testspringmavenproblem.classestotesttests;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TestSpy {

    @Test
    public void spying() {

        // with spy the original logic of the class is retained instead of being mocked, but you can still do stubbing on the spy
        ArrayList mockArrayList = spy(ArrayList.class);
        mockArrayList.add("BLABLA");
        when(mockArrayList.get(0)).thenReturn("Ceco");
        assertEquals("Ceco", mockArrayList.get(0));
    }
}
