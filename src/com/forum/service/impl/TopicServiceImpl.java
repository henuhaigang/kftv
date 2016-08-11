package com.forum.service.impl;

import java.util.List;

import com.forum.dao.TopicDAO;

import com.forum.dao.impl.TopicDAOImpl;

import com.forum.model.Topic;
import com.forum.service.TopicService;

public class TopicServiceImpl implements TopicService {

	public List<Topic> listTopic() {

		TopicDAO topicDAO = new TopicDAOImpl();

		return topicDAO.listTopic();
	}

	public Topic getSingleTopicById(int topicID) {

		TopicDAO topicDAO = new TopicDAOImpl();

		return topicDAO.getSingleTopicById(topicID);
	}

	public void saveTopic(Topic topic) {

		TopicDAO userDAO = new TopicDAOImpl();

		userDAO.saveTopic(topic);

	}

	public void removeTopic(int topicID) {
		TopicDAO topicDAO = new TopicDAOImpl();
		topicDAO.removeTopic(topicID);

	}

	/**
	 * 得到自己的贴子
	 */
	public List<Topic> listMyTopic(String user_ID) {
		TopicDAO topicDAO = new TopicDAOImpl();
		return topicDAO.listMyTopic(user_ID);
	}

	public void addClickCount(Topic topic) {
		TopicDAO topicDAO = new TopicDAOImpl();

		topicDAO.addClickCount(topic);
	}

	public List<Topic> getHotTopic() {
		TopicDAO topicDAO = new TopicDAOImpl();
		return topicDAO.getHotTopic();
	}

	public List<Topic> getNewHotTopic() {
		TopicDAO topicDAO = new TopicDAOImpl();
		return topicDAO.getNewHotTopic();
	}

	public List<Topic> queryByPage(int pageSize, int pageNow, String userID) {
		TopicDAO topicDAO = new TopicDAOImpl();
		return topicDAO.queryByPage(pageSize, pageNow, userID);
	}

	public int getpageCount(int pagesize, String userID) {
		TopicDAO topicDAO = new TopicDAOImpl();
		return topicDAO.getpageCount(pagesize, userID);
	}

	public List<Topic> queryAllByPage(int pageSize, int pageNow) {
		TopicDAO topicDAO = new TopicDAOImpl();
		return topicDAO.queryAllByPage(pageSize, pageNow);
	}

	public int getpageCount(int pagesize) {
		TopicDAO topicDAO = new TopicDAOImpl();
		return topicDAO.getpageCount(pagesize);
	}

	public List<Topic> queryChildrenByPage(int pageSize, int pageNow,
			int sectionID) {
		TopicDAO topicDAO = new TopicDAOImpl();
		return topicDAO.queryChildrenByPage(pageSize, pageNow, sectionID);
	}

	public int getChildrenpageCount(int pagesize, int sectionID) {
		TopicDAO topicDAO = new TopicDAOImpl();
		return topicDAO.getChildrenpageCount(pagesize, sectionID);
	}

	public List<Topic> getAuthorHotTopic(String userID) {
		TopicDAO topicDAO = new TopicDAOImpl();
		return topicDAO.getAuthorHotTopic(userID);
	}

	public List<Topic> searchTopics(String title) {
		TopicDAO topicDAO=new TopicDAOImpl();
		return topicDAO.searchTopics(title);
	}

}
