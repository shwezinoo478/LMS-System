package com.example.demo.Unit;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Controller.*;
import com.example.demo.Entity.Login;
import com.example.demo.Entity.UserDetail;


@RestController
//@ComponentScan("com.example")
@RequestMapping("/login")
public class LoginUnit {
	@Autowired LoginController loginService;
	@Autowired UserDetailController userDetail;
	 
	@GetMapping("/test")
	public String test() {
		return "hi";
	}
	
	@PostMapping("/login")
    public HashMap<String,String> process(@RequestBody Map<String, String> payload) throws Exception {              //Map<String, String>[] payload when receive an array
//    	for (int i=0;i<payload.length;i++) {
//			System.out.println(payload[i].get("email"));
//			System.out.println(payload[i].get("password"));
//    	}
		HashMap <String,String> result = new HashMap<String, String>();
		String email = payload.get("email");
		String password = payload.get("password");
	   
		List<Login> listLogin =  loginService.GetAllLogin();
		String isAuthorzie = "";
		Login lst = loginService.getByEmail(email);
		if(lst == null) {
			isAuthorzie = "Invalid Email";
		}else{
			if(lst.getEmail().equals(email) && lst.getPassword().equals(password)) {
				isAuthorzie = "okay";
			}
			else{
				isAuthorzie = "Invalid Password";
			}
			
		}
//		for(Login login : listLogin) {
//			if(login.getEmail().equals(email) && login.getPassword().equals(password)) {
//				isAuthorzie = "okay";
//				break;
//			}
//			else if(login.getEmail().equals(email)) {
//				isAuthorzie = "Invalid Password";
//			}
//			else {
//				isAuthorzie = "Invalid Username";
//			}
//			
//		} 	
		result.put("message", isAuthorzie);
		return result;
		
    }
	
	@PostMapping("/register")
	public HashMap<String, String> postMethodName(@RequestBody HashMap<String,String> entity) {
		//TODO: process POST request
		String str_result;
		HashMap <String,String> result = new HashMap<String, String>();
		Login login = new Login();
		login.setEmail(entity.get("email"));
		login.setPassword(entity.get("password"));
		login.setUser_id(60);
		
		UserDetail user = new UserDetail();
		user.setEmail(entity.get("email"));
		user.setGender(entity.get("gender"));
		user.setName(entity.get("name"));
		
		
		Login lst = loginService.getByEmail(login.getEmail());
		
		if(lst == null){
			System.out.println("This is test before create"+ user.getName());
			userDetail.CreateUserDetail(user);
			System.out.println("This is test"+ user.getName());
			System.out.println("this is testing for user_id"+user.getUser_id());
			login.setUser_id(user.getUser_id());
			loginService.CreateLogin(login);
			str_result = "successful";
		}else{
			str_result = "This email is already signed in";
		}
		System.out.print(str_result);
		
		result.put("message", str_result);
		
		return result;
	}
	
	
//	private void sendVerificationEmail(String user, String siteURL) throws  UnsupportedEncodingException {
//		String toAddress = user;
//		String fromAddress = "Your email address";
//		String senderName = "Your company name";
//		String subject = "Please verify your registration";
//		String content = "Dear [[name]],<br>"
//		+"Please click the link below to verify your registration:<br>"
//		+ "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
//		+ "Thank you,<br>"
//		+ "Your company name.";
//		MimeMessage message = mailSender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message);
//		helper.setFrom(fromAddress, senderName);
//		helper.setTo(toAddress);
//		helper.setSubject(subject);
//		content = content.replace("[[name]]", user.getFullName());
//		String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();
//		content = content.replace("[[URL]]", verifyURL);
//		helper.setText(content, true);
//		mailSender.send(message);
//	     
//	}
//	
	
	
	
	
	
	
}