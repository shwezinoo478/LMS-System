package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.Login;


public interface LoginRepo extends JpaRepository<Login, Integer> {

}
