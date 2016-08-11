package com.forum.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 持久化类
 * 
 * @author haigang
 * 
 */
public class Topic {
	private int topicID; // 帖子ID
	private String title; // 帖子标题
	private String content; // 帖子内容
	//private String userName; // 发表人性命
	private Date publishDate; // 发布日期
	private Date modifyDate; // 修改日期
	private int clickCount; // 点击数
	private int replyCount; // 回复数
	private boolean isEssence; // 是否为精华
	private int sectionID;
	private String userID; // 对应user表中的id，以便实现关联
    private int isVerify;
	//private User user; // 用户对象，也是为了关联而添加的
	public int getTopicID() {
		return topicID;
	}
	public void setTopicID(int topicID) {
		this.topicID = topicID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public int getClickCount() {
		return clickCount;
	}
	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public boolean getIsEssence() {
		return isEssence;
	}
	public void setIsEssence(boolean isEssence) {
		this.isEssence = isEssence;
	}
	public int getSectionID() {
		return sectionID;
	}
	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getIsVerify() {
		return isVerify;
	}
	public void setIsVerify(int isVerify) {
		this.isVerify = isVerify;
	}

	
}