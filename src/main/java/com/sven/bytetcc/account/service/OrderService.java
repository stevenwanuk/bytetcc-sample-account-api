package com.sven.bytetcc.account.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sven.bytetcc.account.model.ProductOrder;

@Service
public class OrderService
{
    private RestTemplate restTemplate;

    public OrderService() {
        
    }
    public OrderService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public Optional<ProductOrder> findOrderById(Long orderId)
    {

        ResponseEntity<ProductOrder> response = restTemplate
                        .postForEntity("http://127.0.0.0:8010/productOrder/" + orderId, null, ProductOrder.class);
        return Optional.ofNullable(response.getBody());
    }

}
