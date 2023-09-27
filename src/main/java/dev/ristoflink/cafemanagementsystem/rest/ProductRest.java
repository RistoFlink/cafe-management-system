package dev.ristoflink.cafemanagementsystem.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping(path = "/product")
public interface ProductRest {

    @PostMapping("/new")
    ResponseEntity<String> addNewProduct(@RequestBody(required = true) Map<String, String> requestMap);
}
