package com.example.demo.serviceImplementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Login;
import com.example.demo.Repository.LoginRepo;
import com.example.demo.Service.LoginService;


@Service
public class LoginServiceImplement implements LoginService{
	
	@Autowired LoginRepo loginRepo ;
	

	@Override
	public Boolean CreateLogin(Login login) {
		loginRepo.save(login);
		return true;
	}


	@Override
	public Login GetById(int loginId) {
		// TODO Auto-generated method stub
		Login login = new Login();
		login = loginRepo.findById(loginId).orElse(null);
		return login;
	}

	@Override
	public List<Login> GetAllLogin() {
		// TODO Auto-generated method stub
		List<Login> listLogin = loginRepo.findAll();
		return listLogin;
	}

	@Override
	public Boolean UpdateLogin(Login login) {
		// TODO Auto-generated method stub
		loginRepo.save(login);
		return true;
	}

	@Override
	public Boolean DeleteLogin(int loginId) {
		// TODO Auto-generated method stub
		loginRepo.deleteById(loginId);
		return true;
	}


	

}
