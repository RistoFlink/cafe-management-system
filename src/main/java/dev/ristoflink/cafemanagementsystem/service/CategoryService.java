package dev.ristoflink.cafemanagementsystem.service;

import dev.ristoflink.cafemanagementsystem.pojo.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    ResponseEntity<String> addNewCategory(Map<String, String> requestMap);

    ResponseEntity<List<Category>> getAllCategories(String filterValue);
}
