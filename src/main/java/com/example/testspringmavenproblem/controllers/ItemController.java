package com.example.testspringmavenproblem.controllers;

import com.example.testspringmavenproblem.business.ItemBusinessService;
import com.example.testspringmavenproblem.classestotest.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    final ItemBusinessService businessService;

    public ItemController(ItemBusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping("/dummy-item")
    public Item getItem() {
        return new Item(new Long(1), "Ball", 10, 100);

    }

    @GetMapping("/item-from-business-service")
    public Item getItemFromBusinessService() {
        return businessService.retrieveHardcodedItem();
    }

    @GetMapping("/all-items-from-db")
    public List<Item> getAllItems() {
        return businessService.retrieveAllItems();
    }
}
