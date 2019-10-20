package com.phcode.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phcode.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

