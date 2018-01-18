package com.qajungle.controllers;

import com.qajungle.domain.Item;
import com.qajungle.domain.SellerInventory;
import com.qajungle.domain.dto.ItemDto;
import com.qajungle.domain.dto.SellerInventoryDto;
import com.qajungle.services.InventoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class InventoryController {

    @Autowired
    private Tracer tracer;
    @Autowired
    private ModelMapper modelMapper;

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/inventory/seller/{id}")
    @ResponseBody
    public SellerInventoryDto getSellerInventory(@PathVariable("id") Long id) {
        InventoryController.this.tracer.addTag("get-seller-inventory", "[SELLER] id: " + id);
        return convertToDto(inventoryService.getSellerInventory(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/inventory/{id}")
    @ResponseBody
    public ItemDto getInventoryId(@PathVariable("id") Long id) {
        InventoryController.this.tracer.addTag("get-inventory-item", "[ITEM] id: " + id);
        return convertToDto(inventoryService.getInventoryItem(id));
    }

    private SellerInventoryDto convertToDto(final SellerInventory sellerInventory) {
        return modelMapper.map(sellerInventory, SellerInventoryDto.class);
    }

    private ItemDto convertToDto(final Item item) {
        return modelMapper.map(item, ItemDto.class);
    }

}
