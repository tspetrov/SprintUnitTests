package com.example.testspringmavenproblem.businesstests;

import com.example.testspringmavenproblem.business.ItemBusinessService;
import com.example.testspringmavenproblem.classestotest.Item;
import com.example.testspringmavenproblem.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {


    @Mock
    ItemRepository itemRepo;

    @InjectMocks
    ItemBusinessService itemBusinessService ;

    @Test
    void retrieveHardcodedItem() {
        assertEquals(new Item(1L, "Ball", 10, 100), itemBusinessService.retrieveHardcodedItem());
    }

    @Test
    void retrieveAllItems() {

        when(itemRepo.findAll()).thenReturn(Arrays.asList
                (new Item(1L, "Ball", 5, 100),
                        new Item(2L, "Ceco", 10, 100))
        );
        List<Item> items = itemBusinessService.retrieveAllItems();
        assertEquals(items.get(0).getValue(), 500);
        assertEquals(items.get(1).getValue(), 1000);
    }
}