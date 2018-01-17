package com.qajungle.services;

import com.qajungle.domain.PurchaseOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = "com.qajungle:account-service:+:stubs:8082", workOffline = true)
public class PurchaseServiceTest {

    @Autowired
    private PurchaseService purchaseService;
    public static final Long itemId = 123456789L;
    public static final Long accountId = 123456789L;

    @Test
    public void should_purchase_item_by_item_account_id() {
        //when
        PurchaseOrder purchaseOrder = purchaseService.purchaseItem(itemId, accountId);

        //then
        assertThat(purchaseOrder.getId()).isEqualTo(123456789L);
        assertThat(purchaseOrder.getItemName()).isEqualTo("Explore It!");
        assertThat(purchaseOrder.getAccountName()).isEqualTo("aaguila");
        assertThat(purchaseOrder.getStatus()).isEqualTo("PURCHASED");
    }

}
