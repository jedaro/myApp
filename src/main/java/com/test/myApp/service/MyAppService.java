package com.test.myApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.test.myApp.dto.ProductDetail;
import com.test.myApp.exception.MyAppExceptionNotFound;

@Component
public class MyAppService {

    @Autowired
    MockService mockService;

    public List<ProductDetail> getProductSimilar(String productId) {

        try {
            List<ProductDetail> products = new ArrayList<ProductDetail>();

            // Consume mock
            List<Integer> ids = mockService.getSimilarIds(productId);
            ids.forEach((id) -> {
                ProductDetail product = mockService.getProductDetail(String.valueOf(id));
                products.add(product);
            });

            if (!products.isEmpty()) {
                return products;
            } else {
                throw new MyAppExceptionNotFound("Product Not Found");
            }
        } catch (Exception e) {
            throw new MyAppExceptionNotFound("Product Not Found");
        }

    }
}
