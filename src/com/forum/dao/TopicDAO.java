package com.forum.dao;

import java.util.List;

import com.forum.model.Topic;



public interface TopicDAO {

	public  List<Topic> listTopic();                   //将帖子内容从数据库里取出来
	
	public Topic getSingleTopicById(int topicID);      //根据id得到单个的帖子
	 
	public void saveTopic(Topic topic);                //保存帖子
	
	public  List<Topic> listMyTopic(String user_ID);   //得到自己的帖子
	 
	public void removeTopic(int topicID);               //删除帖子
	
	public void addClickCount(Topic topic);              //增加点击数和回帖数

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
