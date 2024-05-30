package com.example.demo.Service;

import java.util.List;


import com.example.demo.Entity.UserDetail;

public interface UserDetailService {
	Boolean CreateUserDetail(UserDetail user);
	
	UserDetail GetByUserDetailId(int userId);
	
	List<UserDetail> GetAllUserDetail();
	
	Boolean UpdateUserDetail(UserDetail user);
	
	Boolean DeleteUserDetail(int userId);
}
