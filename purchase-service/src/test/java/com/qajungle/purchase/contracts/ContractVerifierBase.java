package com.qajungle.inventory.contracts;

import com.qajungle.InventoryServiceApplication;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InventoryServiceApplication.class)
public class ContractVerifierBase {

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() throws Exception {
        RestAssuredMockMvc.webAppContextSetup(context);
    }

}