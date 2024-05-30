package com.example.demo.Service;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.Entity.Login;


public interface LoginService {
	Boolean CreateLogin(Login login);
	
	Login GetById(int loginId);
	
	List<Login> GetAllLogin();
	
	Boolean UpdateLogin(Login login);
	
	Boolean DeleteLogin(int loginId);
	
	@Query("SELECT * FROM LOGIN WHERE EMAIL = ?")
	Login getByEmail(String email);
}
