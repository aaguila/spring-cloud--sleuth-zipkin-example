package com.qajungle.controllers;

import com.qajungle.domain.PurchaseOrder;
import com.qajungle.domain.dto.PurchaseDto;
import com.qajungle.domain.dto.PurchaseOrderDto;
import com.qajungle.services.PurchaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.*;

@RestController
public class PurchaseController {

    @Autowired
    private Tracer tracer;
    @Autowired
    private ModelMapper modelMapper;

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/purchase")
    @ResponseBody
    public PurchaseOrderDto purchase(@RequestBody PurchaseDto purchase) {
        PurchaseController.this.tracer.addTag("purchase", "[PURCHASE] item: " + purchase.getItem() + " account: " + purchase.getAccount());
        return convertToDto(purchaseService.purchaseItem(purchase.getItem(), purchase.getAccount()));
    }

    private PurchaseOrderDto convertToDto(final PurchaseOrder purchaseOrder) {
        return modelMapper.map(purchaseOrder, PurchaseOrderDto.class);
    }

}
