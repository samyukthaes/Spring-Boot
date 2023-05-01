package com.example.ECommerce.Controller;

import com.example.ECommerce.entity.ECommerce;
import com.example.ECommerce.service.ECommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class ECommerceController {
    @Autowired
    public ECommerceService eCommerceService;

    @PostMapping("/add")
    public ECommerce addDetails(@RequestBody ECommerce eCommerce){
        return eCommerceService.addCarDetails(eCommerce);
    }
}
