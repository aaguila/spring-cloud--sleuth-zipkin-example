package com.qajungle.domain;

public class PurchaseOrder {

    Long id;
    String itemName;
    String accountName;
    String status;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Long id, String itemName, String accountName, String status) {
        this.id = id;
        this.itemName = itemName;
        this.accountName = accountName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
