package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;








@SpringBootApplication


public class LearningManagementSystemApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(LearningManagementSystemApplication.class, args);
	}
	
	
	@PostMapping("/process")
    public String process(@RequestBody String payload) throws Exception {
  
//    	for (int i=0;i<payload.size();i++) {
//    		System.out.println(payload.get(i).toString());
//    	}
        System.out.println(payload);
        System.out.println("here ");
        
        return "it's okay";
    }

	

	
	
}
