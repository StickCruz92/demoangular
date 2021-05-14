package com.example.demoangular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoangular.modelo.User;
import com.example.demoangular.repository.UserRepository;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	//private static List<User> users;
	
	@Override
	public User findById(long id) {
		User user = null;
		Optional<User> userOp = userRepository.findById(id);
		if (userOp.isPresent()) {
			user = userOp.get();
		}
		return user;
	}

	@Override
	public User findByName(String name) {
		return userRepository.findByUsername(name);
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUserById(long id) {
		User user = findById(id);
		if (user != null) {
			userRepository.delete(user);
		}
	}

	@Override
	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

	@Override
	public boolean isUserExist(User user) {
		return findByName(user.getUsername())!=null;
	}

}
