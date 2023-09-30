package dev.ristoflink.cafemanagementsystem.serviceimpl;

import dev.ristoflink.cafemanagementsystem.constants.CafeConstants;
import dev.ristoflink.cafemanagementsystem.dao.BillDao;
import dev.ristoflink.cafemanagementsystem.jwt.JwtFilter;
import dev.ristoflink.cafemanagementsystem.pojo.Bill;
import dev.ristoflink.cafemanagementsystem.service.BillService;
import dev.ristoflink.cafemanagementsystem.utils.CafeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    JwtFilter jwtFilter;

    @Autowired
    BillDao billDao;

    @Override
    public ResponseEntity<String> generateReport(Map<String, Object> requestMap) {
        log.info("Inside generateReport");
        try {
            String fileName;
            if (validateRequestMap(requestMap)) {
                if (requestMap.containsKey("isGenerated") && !(Boolean)requestMap.get("isGenerated")) {
                    fileName = (String)requestMap.get("uuid");
                } else {
                    fileName = CafeUtils.getUuid();
                    requestMap.put("uuid", fileName);
                    insertBill(requestMap);
                }
                String data = "Name: " + requestMap.get("name") + "\n" + "Contact number: " + requestMap.get("contactNumber")
                        + "\n" + "Email: " + requestMap.get("email") + "\n" + "Payment method: " + requestMap.get("paymentMethod");
            }
            return CafeUtils.getResponseEntity("Required data not found", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void insertBill(Map<String, Object> requestMap) {
        try {
            Bill bill = new Bill();
            bill.setUuid((String) requestMap.get("uuid"));
            bill.setName((String)requestMap.get("name"));
            bill.setEmail((String)requestMap.get("email"));
            bill.setContactNumber((String)requestMap.get("contactNumber"));
            bill.setPaymentMethod((String)requestMap.get("paymentMethod"));
            bill.setTotalAmount(Integer.parseInt((String)requestMap.get("totalAmount")));
            bill.setProductDetails((String) requestMap.get("productDetails"));
            bill.setCreatedBy(jwtFilter.getCurrentUser());
            billDao.save(bill);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validateRequestMap(Map<String,Object> requestMap) {
        // More elegant solution for checking if the map contains all the required data
        // Define a set of required keys
        Set<String> requiredKeys = new HashSet<>(Arrays.asList("name", "contactNumber", "email", "paymentMethod", "productDetails", "totalAmount"));

        // Check if all required keys exist in the requestMap
        return requiredKeys.stream().allMatch(requestMap::containsKey);
    }
}
