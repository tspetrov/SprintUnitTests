package com.example.testspringmavenproblem.classestotesttests;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class TestVerificationBasics {

    List<String> mockList = mock(List.class);

    @Test
    public void verificationBasics() {

        mockList.get(0);


        verify(mockList).get(0);
        verify(mockList).get(anyInt());
        verify(mockList, times(1)).get(anyInt());

        //verify other options
//        verify(mockList, atLeast(1)).get(anyInt());
//        verify(mockList, atMost(5)).get(anyInt());
//        verify(mockList, never()).get(anyInt());

    }

    @Test
    public void verificationArgumentCapture() {
        //SUT
        mockList.add("Cecoo2");
        mockList.add("Cecoo");

        //Capture argument
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockList, times(2)).add(captor.capture());
        assertEquals("Cecoo2", captor.getAllValues().get(0));
        assertEquals("Cecoo", captor.getAllValues().get(1));

    }


}
