package com.forum.model;

import java.sql.Date;

public class Reply {
	
	private int replyID;
	private int topicID;
	private String content;
//	private String userName;
	private Date publishDate;
	private String userID;
	
//	private Topic topic;//对应Topic对象
//	
//	
//	
//	public Topic getTopic() {
//		return topic;
//	}
//	public void setTopic(Topic topic) {
//		this.topic = topic;
//	}
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getReplyID() {
		return replyID;
	}
	public void setReplyID(int replyID) {
		this.replyID = replyID;
	}
	public int getTopicID() {
		return topicID;
	}
	public void setTopicID(int topicID) {
		this.topicID = topicID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
//	public String getUserName() {
//		return userName;
//	}
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	
	
	
}
