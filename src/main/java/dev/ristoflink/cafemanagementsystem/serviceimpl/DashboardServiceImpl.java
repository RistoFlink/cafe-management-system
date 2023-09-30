package dev.ristoflink.cafemanagementsystem.serviceimpl;

import dev.ristoflink.cafemanagementsystem.dao.BillDao;
import dev.ristoflink.cafemanagementsystem.dao.CategoryDao;
import dev.ristoflink.cafemanagementsystem.dao.ProductDao;
import dev.ristoflink.cafemanagementsystem.dao.UserDao;
import dev.ristoflink.cafemanagementsystem.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    CategoryDao categoryDao;

    @Autowired
    BillDao billDao;

    @Autowired
    ProductDao productDao;

    @Override
    public ResponseEntity<Map<String, Object>> getDetails() {
        Map<String, Object> map = new HashMap<>();
        map.put("categories", categoryDao.count());
        map.put("products", productDao.count());
        map.put("bills", billDao.count());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
