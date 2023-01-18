package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface IUserService {

	  public User insertUser(User user);

	  public List<User> getAllUser();

	  public User deleteUser(int id);
	  
	  public User updateUser(int id, User user);
}
