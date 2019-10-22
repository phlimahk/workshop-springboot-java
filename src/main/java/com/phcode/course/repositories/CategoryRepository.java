package com.phcode.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phcode.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

