package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.UserDetail;

public interface userDetailRepo extends JpaRepository<UserDetail, Integer>{

}
