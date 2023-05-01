package com.example.ECommerce.service;

import com.example.ECommerce.entity.ECommerce;
import com.example.ECommerce.repository.ECommerceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ECommerceService {
    @Autowired
    public ECommerceRepository eCommerceRepository;

    public ECommerce addCarDetails(ECommerce eCommerce) {
        return eCommerceRepository.save(eCommerce);
    }
}
