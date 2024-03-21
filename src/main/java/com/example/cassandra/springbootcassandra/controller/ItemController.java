package com.example.cassandra.springbootcassandra.controller;

import com.example.cassandra.springbootcassandra.model.Item;
import com.example.cassandra.springbootcassandra.repository.ItemRepository;
import com.example.cassandra.springbootcassandra.repository.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
    ItemRepository itemRepository;

    @PostMapping("/items")
    public Item addItem(@RequestBody Item item) {
        itemRepository.save(item);
        return item;
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> findById(@PathVariable("id") UUID itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(
                () -> new ResourceNotFoundException("Item not found with id: " + itemId));
        return ResponseEntity.ok().body(item);
    }

    @GetMapping("/items")
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") UUID itemId, @RequestBody Item itemDetails) {
        Item item = itemRepository.findById(itemId).orElseThrow(
                () -> new ResourceNotFoundException("Item not found with id: " + itemId));
        item.setName(itemDetails.getName());
        final Item updatedItem = itemRepository.save(item);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable("id") UUID itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(
                () -> new ResourceNotFoundException("Item not found with id: " + itemId));
        itemRepository.delete(item);
        return ResponseEntity.ok().build();
    }
}
