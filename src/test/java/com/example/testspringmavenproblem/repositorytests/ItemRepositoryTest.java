package com.example.testspringmavenproblem.repositorytests;

import com.example.testspringmavenproblem.classestotest.Item;
import com.example.testspringmavenproblem.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// this annotation is needed to autowire itemRepository
@DataJpaTest
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void testFindAll() {
        List<Item> allItems = itemRepository.findAll();
        assertEquals(3, allItems.size());

    }
}