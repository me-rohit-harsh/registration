package com.indianbank.service;

import java.util.List;

import com.indianbank.entity.User;

public interface UserService {
	User saveUser(User user);

	Long saveUserId(User user);

	List<User> allUser();

	User getUser(Long id);

	User updateUser(User user);

	boolean deleteUser(Long id);
	
	void timestamp(Long id);
	

}
