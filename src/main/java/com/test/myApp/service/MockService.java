package com.test.myApp.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.test.myApp.dto.ProductDetail;

@Component
public class MockService {

    private static String URL_API_MOCK = "http://localhost:3001/product/";

    public List<Integer> getSimilarIds(String id) {

        RestTemplate restTemplate = new RestTemplate();
        String url = URL_API_MOCK + id + "/similarids";
        List<Integer> ids = restTemplate.getForObject(url, List.class);

        return ids;

    }

    public ProductDetail getProductDetail(String id) {

        RestTemplate restTemplate = new RestTemplate();
        String url = URL_API_MOCK + id;
        ProductDetail product = restTemplate.getForObject(url, ProductDetail.class);

        return product;
    }

}
