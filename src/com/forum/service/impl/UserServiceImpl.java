package com.forum.service.impl;

import java.util.List;

import com.forum.dao.TopicDAO;
import com.forum.dao.UserDAO;
import com.forum.dao.impl.TopicDAOImpl;
import com.forum.dao.impl.UserDAOImpl;
import com.forum.model.User;
import com.forum.service.UserService;

public class UserServiceImpl implements UserService {

	public void saveUser(User user) {
		UserDAO userDAO = new UserDAOImpl();

		userDAO.saveUser(user);
	}

	public List<User> listAllUser() {
		UserDAO userDAO = new UserDAOImpl();

		return userDAO.listAllUser();
	}

	public List<User> getSingleUserByName(String userName, String password) {
		UserDAO userDAO = new UserDAOImpl();

		return userDAO.getSingleUserByName(userName, password);
	}

	public void removeUser(String userID) {
		UserDAO userDAO = new UserDAOImpl();
		userDAO.removeUser(userID);

	}

	public void updateUser(User user) {
		UserDAO userDAO = new UserDAOImpl();
		userDAO.updateUser(user);

	}

	public User getSingleUserById(String userID) {
		UserDAO userDAO = new UserDAOImpl();

		return userDAO.getSingleUserById(userID);

	}

	/**
	 * 验证是否存在用户名
	 */
	public List<User> getUserByName(String userName) {
		UserDAO userDAO = new UserDAOImpl();
		return userDAO.getUserByName(userName);
	}
//搜索用户
	public List<User> searchUser(String userName) {
		UserDAO userDAO = new UserDAOImpl();
		return userDAO.searchUser(userName);
	}
}
