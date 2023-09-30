package dev.ristoflink.cafemanagementsystem.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public class CafeUtils {
    private CafeUtils(){

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return new ResponseEntity<String>("{\"message\":\""+ responseMessage +".\"}", httpStatus);
    }

    public static String getUuid() {
        Date date = new Date();
        long time = date.getTime();

        return "BILL-" + time;
    }
}
