package com.thebarr.shopspring.controller;

import com.thebarr.shopspring.model.Item;
import com.thebarr.shopspring.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ItemRepository itemRepository;

    @Autowired
    public AdminController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    private String adminPage(){
        return "adminView/addItem";
    }

    @PostMapping
    private String addItem(Item item) {
        itemRepository.save(item);
        return "redirect:/";
    }
}
