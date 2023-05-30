package com.test.myApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.test.myApp.dto.ProductDetail;
import com.test.myApp.exception.MyAppExceptionNotFound;

@Component
public class MyAppService {
    
    public List<ProductDetail> getProductSimilar(String productId) {

        // Consumo api actual
        
        Optional<List<ProductDetail>> products = Optional.of(new ArrayList<ProductDetail>());
        if (products.isPresent() && products.get().size() > 0) {
            return products.get();
        } else {
            throw new MyAppExceptionNotFound("Product Not Found");
        }
    }
}
