package com.indianbank.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.indianbank.entity.User;
import com.indianbank.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> allUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public boolean deleteUser(Long id) {
		User user = userRepository.findById(id).get();
		if (user != null) {
			userRepository.delete(user);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Long saveUserId(User user) {
		User user2 = userRepository.save(user);
		return user2.getId();
	}

	@Override
	public void timestamp(Long id) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentDate = new Date();
		User user = userRepository.findById(id).get();
		user.setlDA(dateFormat.format(currentDate));
		userRepository.save(user);
	}

//	public boolean loginUser(Long id, String password) {
//		User user = userRepository.findByUserIdAndPassword(id, password);
//		if (user != null) {
//			return true;
//		}
//		return false;
//	}

}
