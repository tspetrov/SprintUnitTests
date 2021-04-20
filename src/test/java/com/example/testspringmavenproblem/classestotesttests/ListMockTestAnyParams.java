package com.example.testspringmavenproblem.classestotesttests;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTestAnyParams {

    List listMock = mock(List.class);

    @Test
    public void size_basic() {
        when(listMock.size()).thenReturn(5);
        assertEquals(5, listMock.size());
    }

    @Test
    public void returnDifferentValues() {
        when(listMock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, listMock.size());
        assertEquals(10, listMock.size());
    }

    //Call using any parameters
    @Test
    public void returnWithParameters() {
        when(listMock.get(anyInt())).thenReturn("This is it");
        assertEquals("This is it", listMock.get(1));
        assertEquals("This is it", listMock.get(0));
    }


}
