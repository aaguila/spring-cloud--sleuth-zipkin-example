package com.qajungle.services;

import com.qajungle.domain.Account;
import com.qajungle.domain.Item;
import com.qajungle.domain.PurchaseOrder;
import com.qajungle.gateway.AccountGateway;
import com.qajungle.gateway.InventoryGateway;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    private final AccountGateway accountGateway;
    private final InventoryGateway inventoryGateway;

    public PurchaseService(AccountGateway accountGateway, InventoryGateway inventoryGateway) {
        this.accountGateway = accountGateway;
        this.inventoryGateway = inventoryGateway;
    }

    public PurchaseOrder purchaseItem(Long itemId, Long accountId) {
        Item orderItem = inventoryGateway.getInventoryItem(itemId);

        if(orderItem.getStock() == 0) {
            return null;
        }

        Account orderAccount = accountGateway.getAccount(accountId);
        return new PurchaseOrder(123456789L, orderItem.getName(), orderAccount.getName(), "PURCHASED");
    }

}
