package com.qajungle.gateway;

import com.qajungle.domain.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class AccountGateway {

    private final RestTemplate restTemplate;
    private final String accountUrl;

    public AccountGateway(RestTemplateBuilder restTemplateBuilder, @Value("${account.service.url}") String accountUrl) {
        this.restTemplate = restTemplateBuilder.build();
        this.accountUrl = accountUrl;
    }

    /**
     * Get account
     *
     * @param User account id
     * @return Account
     */
    public Account getAccount(Long id) {

        URI uri = UriComponentsBuilder.fromUriString(accountUrl)
                .pathSegment("account/" + id)
                .build()
                .toUri();

        ResponseEntity<Account> response = restTemplate.getForEntity(uri, Account.class);

        return response.getBody();
    }

}
