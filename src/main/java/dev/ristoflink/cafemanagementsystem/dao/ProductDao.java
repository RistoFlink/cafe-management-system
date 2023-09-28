package dev.ristoflink.cafemanagementsystem.dao;

import dev.ristoflink.cafemanagementsystem.pojo.Product;
import dev.ristoflink.cafemanagementsystem.wrapper.ProductWrapper;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    List<ProductWrapper> getAllProducts();

    @Transactional
    @Modifying
    Integer updateProductStatus(@Param("status") String status, @Param("id") Integer id);
}
