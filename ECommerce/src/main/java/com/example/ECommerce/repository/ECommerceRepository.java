package com.example.ECommerce.repository;

import com.example.ECommerce.entity.ECommerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ECommerceRepository extends JpaRepository<ECommerce,Long> {
}
