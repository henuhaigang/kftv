package com.forum.model;

import java.sql.Date;//因为是跟数据库关联的
import java.util.HashSet;
import java.util.Set;

/**
 * 持久化类
 * @author haigang
 *
 */
public class User {
	private String userID;         //用户ID
	private String userName;       //用户名称
	private String password;       //用户密码
	private Date registerDate;     //注册日期
	private String QQ;              
	private String Email;
	private char sex;
	private  String userPhoto;       //用户头像
	private String userSignature;    //用户签名
	private int userScore;           //用户积分
	private int userLimit;           //用户权限
	
	/*private Set topics=new HashSet();   //帖子表集，为了关联而设的
	
	public Set getTopics() {
		return topics;
	}
	public void setTopics(Set topics) {
		this.topics = topics;
	}*/
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
	
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
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
}
