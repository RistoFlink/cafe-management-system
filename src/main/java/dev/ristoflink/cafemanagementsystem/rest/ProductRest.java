package dev.ristoflink.cafemanagementsystem.rest;

import dev.ristoflink.cafemanagementsystem.wrapper.ProductWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/product")
public interface ProductRest {

    @PostMapping("/new")
    ResponseEntity<String> addNewProduct(@RequestBody(required = true) Map<String, String> requestMap);

    @GetMapping("/get")
    ResponseEntity<List<ProductWrapper>> getAllProducts();

    @PutMapping("/update")
    ResponseEntity<String> updateProduct(@RequestBody(required = true) Map<String, String> requestMap);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteProduct(@PathVariable Integer id);

}
