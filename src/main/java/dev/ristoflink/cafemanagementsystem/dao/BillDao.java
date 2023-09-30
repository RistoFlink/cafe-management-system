package dev.ristoflink.cafemanagementsystem.dao;

import dev.ristoflink.cafemanagementsystem.pojo.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillDao extends JpaRepository<Bill, Integer> {
}
