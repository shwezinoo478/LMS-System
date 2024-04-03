package com.example.demo.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Login {
	@Id
	int login_id;
	@Column(nullable = false)
	private String short_name;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String perright;
	@Column(nullable = false)
	private int user_id;

	
	public Login() {
		this.login_id = 0;
		this.short_name = "";
		this.password = "";
		this.perright = "";
		this.user_id = 0;
	}
	
	
	public Login(int login_id, String short_name, String password, String perright, int user_id) {
		super();
		this.login_id = login_id;
		this.short_name = short_name;
		this.password = password;
		this.perright = perright;
		this.user_id = user_id;
	}


	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public String getShort_name() {
		return short_name;
	}
	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPerRight() {
		return perright;
	}
	public void setPerRight(String perRight) {
		this.perright = perRight;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}	
}
