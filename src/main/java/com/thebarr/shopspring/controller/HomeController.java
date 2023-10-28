package com.thebarr.shopspring.controller;

import com.thebarr.shopspring.model.Item;
import com.thebarr.shopspring.repository.ItemRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final ItemRepository  itemRepository;

    @Autowired
    public HomeController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("items", itemRepository.findAll());
        return "home";
    }

    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") Long itemId, Model model, HttpSession session) {
        @SuppressWarnings("unchecked")
        List<Item> cart = (List<Item>) session.getAttribute("cart");
        if(cart == null) {
            cart = new ArrayList<>();
        }
        Optional<Item> oItem = itemRepository.findById(itemId);
        if(oItem.isPresent()) {
            Item item = oItem.get();
            cart.add(item);
            session.setAttribute("cart", cart);
        }
        model.addAttribute("items", itemRepository.findAll());
        return "home";
    }
}
