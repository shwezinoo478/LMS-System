package com.example.demo.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // This line specifies auto-increment
	int login_id;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private int user_id;

	
	public Login() {
		this.login_id = 0;
		this.email = "";
		this.password = "";
		this.user_id = 0;
	}
	
	
	public Login(int login_id, String email, String password,  int user_id) {
		super();
		this.login_id = login_id;
		this.email = email;
		this.password = password;
		this.user_id = user_id;
	}


	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}	
}
