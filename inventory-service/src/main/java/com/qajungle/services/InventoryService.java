package com.qajungle.services;

import com.qajungle.domain.Item;
import com.qajungle.domain.SellerInventory;
import com.qajungle.gateway.AccountGateway;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    private final AccountGateway accountGateway;

    public InventoryService(AccountGateway accountGateway) {
        this.accountGateway = accountGateway;
    }

    public SellerInventory getSellerInventory(Long id) {
        return accountGateway.getSellerInventory(id);
    }

    public Item getInventoryItem(Long id) {
        return new Item(id, "Explore It!", 1, 20.00);
    }

}
