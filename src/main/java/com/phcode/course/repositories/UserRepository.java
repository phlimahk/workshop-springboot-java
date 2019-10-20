package com.phcode.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phcode.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

