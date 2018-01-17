package com.qajungle.domain.dto;

public class PurchaseDto {

    Long account;
    Long item;

    public PurchaseDto() {
    }

    public PurchaseDto(Long account, Long item) {
        this.account = account;
        this.item = item;
    }

    public Long getAccount() {
        return account;
    }

    public Long getItem() {
        return item;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public void setItem(Long item) {
        this.item = item;
    }
}
