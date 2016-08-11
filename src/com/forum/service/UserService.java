package com.forum.service;

import java.util.List;

import com.forum.model.User;

public interface UserService {
	public void saveUser(User user);

	public List<User> listAllUser();

	public List<User> getSingleUserByName(String userName, String password);

	public void removeUser(String userID);
	
	public void updateUser(User user);
	public User getSingleUserById(String userID);
	public List<User>  getUserByName(String userName);//验证是否存在此用户（ajax）
	public List<User> searchUser(String userName);
}
