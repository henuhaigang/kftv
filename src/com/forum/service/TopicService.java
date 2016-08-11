package com.forum.service;

import java.util.List;

import com.forum.model.Topic;


public interface TopicService {

	public List<Topic> listTopic(); // 列出帖子列表

	public Topic getSingleTopicById(int topicID); // 得到单个帖子

	public void saveTopic(Topic topic); // 发布保存帖子
	public void removeTopic(int topicID);//删除帖子
	public  List<Topic> listMyTopic(String user_ID);
	public void addClickCount(Topic topic); //添加点击次数
	 public List<Topic> getHotTopic();
	 public List<Topic> getNewHotTopic();
	 
	 
	 
     public List<Topic> queryByPage(int pageSize, int pageNow, String userID);
	 
	 public int getpageCount(int pagesize, String userID);
	 
	 public List<Topic> queryAllByPage(int pageSize, int pageNow);
	 
	 public int getpageCount(int pagesize);
	 
	 public List<Topic> queryChildrenByPage(int pageSize, int pageNow,int sectionID);
	 
	 public int getChildrenpageCount(int pagesize,int sectionID);
	 
	 public List<Topic> getAuthorHotTopic(String userID);
	 
	 public List<Topic> searchTopics(String title);
}
