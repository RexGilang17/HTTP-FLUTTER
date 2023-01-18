package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;

@Service
public class UserService implements IUserService {
	
	 @Autowired
	 IUserRepository userRepository;
	 
	 @Override
	    public User insertUser(User user) {
	        return userRepository.insertUser(user);
	    }

	    @Override
	    public List<User> getAllUser() {
	        return userRepository.getAllUser();
	    }

	    @Override
	    public User deleteUser(int id) {
	       
	        return userRepository.deleteUser(id);
	    }

		@Override
		public User updateUser(int id, User user) {
			// TODO Auto-generated method stub
			return userRepository.updateUser(id, user);
		}

}
