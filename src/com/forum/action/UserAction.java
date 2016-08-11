package com.forum.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.forum.model.User;

import com.forum.service.UserService;

import com.forum.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private String userID;
	private String userName;
	private String password;
	private String registerDate; // 注册日期
	private String QQ;
	private String Email;
	private char sex;
	private String userPhoto;
	private String userSignature; // 用户签名
	private int userScore; // 用户积分
	private int userLimit;

	/*
	 * private Set topics= new HashSet();; // 帖子表集，为了关联而设的
	 * 
	 * public Set getTopics() { return topics; }
	 * 
	 * public void setTopics(Set topics) { this.topics = topics; }
	 */

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getUserSignature() {
		return userSignature;
	}

	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}

	public int getUserScore() {
		return userScore;
	}

	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}

	public int getUserLimit() {
		return userLimit;
	}

	public void setUserLimit(int userLimit) {
		this.userLimit = userLimit;
	}

	/**
	 * 注册用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String registerUser() throws Exception {

		User user = new User();
		user.setUserName(userName);

		user.setPassword(password);

		java.sql.Date registerDate = new java.sql.Date(
				new java.util.Date().getTime());
		user.setRegisterDate(registerDate);

		user.setQQ(QQ);

		user.setEmail(Email);
		user.setSex(sex);
		user.setUserPhoto(userPhoto);
		user.setUserSignature(userSignature);
		user.setUserScore(userScore);
		user.setUserLimit(userLimit);

		UserService userService = new UserServiceImpl();

		userService.saveUser(user);

		ActionContext.getContext().getSession().put("userName", userName);

		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("userID", userID);
		request.setAttribute("userName", userName);
		

		List<User> list = userService.getSingleUserByName(userName, password);// 传递用户名和用户密码
		request.setAttribute("list", list);
		ActionContext.getContext().getSession().put("userName", userName);
		return SUCCESS;
	}

	/**
	 * 用户和管理员的登录，根据用户的权限登录
	 * 
	 * @return
	 * @throws Exception
	 */

	public String adminLogin() throws Exception {

		UserService userService = new UserServiceImpl();

		List<User> list = userService.getSingleUserByName(userName, password);// 传递用户名和用户密码

		for (User user1 : list) {
			user1 = (User) list.get(userLimit);

			userID = user1.getUserID();

			System.out.println(userID);

			userLimit = user1.getUserLimit();
		}

		if ((list != null) && (list.size() == 1) && (userLimit == 1)) {
			// 给用户增加积分

			User user = userService.getSingleUserById(userID);

			userScore = user.getUserScore();

			userScore = userScore + 1;

			System.out.println(userScore);

			user.setUserScore(userScore);

			userService.updateUser(user);

			// 登录成功时
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("list", list);
			ActionContext.getContext().getSession().put("userName", userName);
			return "success";
		} else {
			return "error";
		}

	}

	/**
	 * 普通用户登录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String userLogin() throws Exception {

		UserService userService = new UserServiceImpl();

		List<User> list = userService.getSingleUserByName(userName, password);// 传递用户名和用户密码

		for (User user1 : list) {
			user1 = (User) list.get(0);

			userID = user1.getUserID();

			userLimit = user1.getUserLimit();

		}
		if ((list != null) && (list.size() == 1) && (userLimit == 0)) {

			User user = userService.getSingleUserById(userID);

			userScore = user.getUserScore();

			userScore = userScore + 1;

			System.out.println(userScore);

			user.setUserScore(userScore);

			userService.updateUser(user);

			HttpServletRequest request = ServletActionContext.getRequest();

			request.setAttribute("list", list);

			ActionContext.getContext().getSession().put("userName", userName);

			return "usersuccess";

		} else {
			return "error";
		}

	}

	/**
	 * 删除用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteUser() throws Exception {

		UserService userService = new UserServiceImpl();

		userService.removeUser(userID);
		List<User> list = userService.listAllUser();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);

		return SUCCESS;
	}

	/**
	 * 得到所有用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String listAllUsers() throws Exception {

		UserService userService = new UserServiceImpl();

		List<User> list = userService.listAllUser();

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("list", list);

		return SUCCESS;
	}

	/**
	 * 的到单个用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getSingleUser() throws Exception {

		UserService userService = new UserServiceImpl();

		User user = userService.getSingleUserById(userID);

		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("user", user);

		return SUCCESS;
	}

	/**
	 * 修改用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateUser() throws Exception {

		UserService userService = new UserServiceImpl();
		User user = userService.getSingleUserById(userID);

		user.setPassword(password);
		// user.setQQ(QQ);
		user.setEmail(Email);
		userService.updateUser(user);
		List<User> list = userService.listAllUser();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("list", list);
		return SUCCESS;
	}

	// 得到自己的帖子
	/*
	 * public String showMyTopic() throws Exception { HttpServletRequest
	 * requestuser = ServletActionContext.getRequest(); // String user_ID =
	 * requestuser.getParameter("user_ID"); //String user_ID = (String)
	 * request.getParameter("userID"); String userName =
	 * requestuser.getParameter("userName"); String user_ID = (String)
	 * requestuser.getParameter("userID");
	 * 
	 * UserDAO userdao=new UserDAOImpl();
	 * 
	 * Set<Topic> set=userdao.getMyTopicsById(user_ID);
	 * 
	 * requestuser.setAttribute("set", set);
	 * 
	 * requestuser.setAttribute("user_ID", user_ID);
	 * requestuser.setAttribute("userName", userName);
	 * 
	 * return SUCCESS; }
	 */

	/**
	 * 注册时验证用户是否存在
	 * 
	 * @return
	 * @throws Exception
	 */

	private String isUserNameUsed;

	public String getIsUserNameUsed() {
		return isUserNameUsed;
	}

	public void setIsUserNameUsed(String isUserNameUsed) {
		this.isUserNameUsed = isUserNameUsed;
	}

	public String checkUserExsit() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String userName = request.getParameter("userName");
		System.out.println(userName + "===");
		UserService userService = new UserServiceImpl();

		List<User> list = userService.getUserByName(userName);// 传递用户名和用户密码

		if (list != null && (list.size() != 0)) {

			this.setIsUserNameUsed("yes");
			System.out.println(list.size());

		} else {

			this.setIsUserNameUsed("no");

		}

		return SUCCESS;

	}

	// /////////////////////////////////////////////////////////////////////////////////////

}
