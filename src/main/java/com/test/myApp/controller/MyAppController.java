package com.test.myApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.test.myApp.dto.ProductDetail;
import com.test.myApp.exception.MyAppExceptionNotFound;
import com.test.myApp.service.MyAppService;


@RestController
@RequestMapping("/")
public class MyAppController {

    @Autowired
    MyAppService myAppService;

    @GetMapping("/")
    public String info(){
        
        return "Api test";
    }
    
    @GetMapping("/product/{productId}/similar")
    public ResponseEntity<List<ProductDetail>> getProductSimilar(@PathVariable(value = "productId", required = true) String productId){
        
        try {
            return new ResponseEntity<List<ProductDetail>>(myAppService.getProductSimilar(productId), HttpStatus.OK);
        } catch (MyAppExceptionNotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }
    
}