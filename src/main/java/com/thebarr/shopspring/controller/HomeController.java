package com.thebarr.shopspring.controller;

import com.thebarr.shopspring.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    static List<Item> items = new ArrayList<>();

    static {
        items.add(new Item("Ołówek", new BigDecimal("2.50"), "https://clipart-library.com/new_gallery/1233931_yellow-pencil-png.png"));
        items.add(new Item("Długopis", new BigDecimal("1.25"), "https://www.freeiconspng.com/thumbs/pen-png/pen-in-hand-png-9.png"));
        items.add(new Item("Pióro", new BigDecimal("5.00"), "https://freepngimg.com/thumb/pen/13-pen-png-image-thumb.png"));
    }


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", items);
        return "home";
    }

}
