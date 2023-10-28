package com.thebarr.shopspring;

import com.thebarr.shopspring.model.Item;
import com.thebarr.shopspring.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {

    private final ItemRepository itemRepository;

    @Autowired
    public DbInit(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        itemRepository.saveAll(List.of(
                new Item("Ołówek", new BigDecimal("2.50"), "https://clipart-library.com/new_gallery/1233931_yellow-pencil-png.png"),
                new Item("Długopis", new BigDecimal("1.25"), "https://www.freeiconspng.com/thumbs/pen-png/pen-in-hand-png-9.png"),
                new Item("Pióro", new BigDecimal("5.00"), "https://freepngimg.com/thumb/pen/13-pen-png-image-thumb.png")
        ));
    }
}
