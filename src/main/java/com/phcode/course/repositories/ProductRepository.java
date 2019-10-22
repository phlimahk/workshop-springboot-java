package com.phcode.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phcode.course.entities.Category;
import com.phcode.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

