package com.example.testspringmavenproblem.business;

import com.example.testspringmavenproblem.classestotest.Item;
import com.example.testspringmavenproblem.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retrieveHardcodedItem() {
        return new Item(new Long(1), "Ball", 10, 100);
    }

    public List<Item> retrieveAllItems() {
        List<Item> items = repository.findAll();
        items.forEach(x -> x.setValue(x.getPrice() * x.getQuantity()));
        return items;
    }
}
