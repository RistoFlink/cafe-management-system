package dev.ristoflink.cafemanagementsystem.dao;

import dev.ristoflink.cafemanagementsystem.pojo.Product;
import dev.ristoflink.cafemanagementsystem.wrapper.ProductWrapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    List<ProductWrapper> getAllProducts();
}
