package dev.ristoflink.cafemanagementsystem.rest;

import dev.ristoflink.cafemanagementsystem.wrapper.ProductWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/product")
public interface ProductRest {

    @PostMapping("/new")
    ResponseEntity<String> addNewProduct(@RequestBody(required = true) Map<String, String> requestMap);

    @GetMapping("/get")
    ResponseEntity<List<ProductWrapper>> getAllProducts();
}
