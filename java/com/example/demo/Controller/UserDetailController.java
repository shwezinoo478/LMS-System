package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.UserDetail;
import com.example.demo.Repository.userDetailRepo;
import com.example.demo.Service.UserDetailService;

@Service
public class UserDetailController implements UserDetailService {
	@Autowired userDetailRepo userDetail ;

	@Override
	public Boolean CreateUserDetail(UserDetail user) {
		userDetail.save(user);
		return true;
	}

	@Override
	public UserDetail GetByUserDetailId(int userId) {
		// TODO Auto-generated method stub
		UserDetail user = userDetail.findById(userId).orElse(null);
		return user;
	}

	@Override
	public List<UserDetail> GetAllUserDetail() {
		// TODO Auto-generated method stub
		return userDetail.findAll();
	}

	@Override
	public Boolean UpdateUserDetail(UserDetail user) {
		// TODO Auto-generated method stub
		userDetail.save(user);
		return true;
	}

	@Override
	public Boolean DeleteUserDetail(int userId) {
		// TODO Auto-generated method stub
		userDetail.deleteById(userId);
		return true;
	}

}
