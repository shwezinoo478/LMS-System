package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Login;
import com.example.demo.serviceImplementation.*;


@RestController
//@ComponentScan("com.example")
@RequestMapping("/login")
public class LoginController {
	@Autowired LoginServiceImplement loginService;
	 
	@GetMapping("/test")
	public String test() {
		return "hi";
	}
	
	@PostMapping("/process2")
    public String process(@RequestBody Map<String, String> payload) throws Exception {              //Map<String, String>[] payload when receive an array
//    	for (int i=0;i<payload.length;i++) {
//			System.out.println(payload[i].get("email"));
//			System.out.println(payload[i].get("password"));
//    	}
		String username = payload.get("username");
		String password = payload.get("password");
	   
		List<Login> listLogin =  loginService.GetAllLogin();
		String isAuthorzie = "";
		for(Login login : listLogin) {
			if(login.getShort_name().equals(username) && login.getPassword().equals(password)) {
				isAuthorzie = "okay";
				break;
			}
			else if(login.getShort_name().equals(username)) {
				isAuthorzie = "Invalid Password ";
			}
			else {
				isAuthorzie = "Invalid Username ";
			}
			
		} 		
		return isAuthorzie;
		
    }
	
	
	
}