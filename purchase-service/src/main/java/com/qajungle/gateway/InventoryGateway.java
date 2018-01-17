package com.qajungle.gateway;

import com.qajungle.domain.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class InventoryGateway {

    private final RestTemplate restTemplate;
    private final String inventoryUrl;

    public InventoryGateway(RestTemplateBuilder restTemplateBuilder, @Value("${inventory.service.url}") String inventoryUrl) {
        this.restTemplate = restTemplateBuilder.build();
        this.inventoryUrl = inventoryUrl;
    }

    /**
     * Get inventory item
     * @param Item id
     * @return Item
     */
    public Item getInventoryItem(Long id) {

        URI uri = UriComponentsBuilder.fromUriString(inventoryUrl)
                .pathSegment("inventory/" + id)
                .build()
                .toUri();

        ResponseEntity<Item> response = restTemplate.getForEntity(uri, Item.class);

        return response.getBody();
    }

}
