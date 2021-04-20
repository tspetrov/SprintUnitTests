package com.example.testspringmavenproblem.classestotesttests;

import com.example.testspringmavenproblem.classestotest.FirstClass;
import com.example.testspringmavenproblem.classestotest.SomeDataService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TestClassInjectExtendWith {

    @InjectMocks
    FirstClass myFirstClass;

    @Mock
    SomeDataService someDataService;

    @Test
    public void calculateSum_basic_new() {

        Mockito.when(someDataService.reteriveAllData()).thenReturn(new int[]{1,2});
        assertEquals(3,myFirstClass.calculateSumUsingDataService());
    }
}
