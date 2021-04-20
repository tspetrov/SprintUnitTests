package com.example.testspringmavenproblem.classestotesttests;

import com.example.testspringmavenproblem.classestotest.FirstClass;
import com.example.testspringmavenproblem.classestotest.SomeDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TestClassStubMock {

    FirstClass firstClass = new FirstClass();

    @BeforeEach
    public void before () {
        // Steps before each test
        System.out.println("Before called");
        firstClass.setSomeDataService(() -> new int[] {1,2,3});
    }

    // you can use @ InjectMocks

    @Test
    void calculateSum_basic() {
        assertEquals(6, new FirstClass().calculateSum(1, 2, 3));
    }

    @Test
    void calculateSum_emptyArray() {
        assertEquals(0, new FirstClass().calculateSum());
    }

    //Test with stub
    @Test
    void calculateSumUsingTestDataStub() {

        assertEquals(6, firstClass.calculateSumUsingDataService());
    }

    // Test with Mock
    @Test
    void calculateSumUsingTestDataMock() {

        SomeDataService someDataServiceMock = Mockito.mock(SomeDataService.class);
        Mockito.when(someDataServiceMock.reteriveAllData()).thenReturn(new int[]{1,2,3,4});
        firstClass.setSomeDataService(someDataServiceMock);

        assertEquals(10, firstClass.calculateSumUsingDataService());
    }

}