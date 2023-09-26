package dev.ristoflink.cafemanagementsystem.restimpl;

import dev.ristoflink.cafemanagementsystem.constants.CafeConstants;
import dev.ristoflink.cafemanagementsystem.pojo.Category;
import dev.ristoflink.cafemanagementsystem.rest.CategoryRest;
import dev.ristoflink.cafemanagementsystem.service.CategoryService;
import dev.ristoflink.cafemanagementsystem.utils.CafeUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
public class CategoryRestImpl implements CategoryRest {

    @Autowired
    CategoryService categoryService;

    @Override
    public ResponseEntity<String> addNewCategory(Map<String, String> requestMap) {
        try {
           return categoryService.addNewCategory(requestMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Category>> getAllCategories(String filterValue) {
        try {
            return categoryService.getAllCategories(filterValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
