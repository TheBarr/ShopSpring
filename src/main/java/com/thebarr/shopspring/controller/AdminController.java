package com.thebarr.shopspring.controller;

import com.thebarr.shopspring.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    private String adminPage(){
        return "adminView/addItem";
    }

    @PostMapping
    private String addItem(Item item) {
        HomeController.items.add(item);
        return "redirect:/";
    }
}
