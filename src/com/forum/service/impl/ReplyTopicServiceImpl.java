package com.forum.service.impl;

import java.util.List;

import com.forum.dao.ReplyTopicDAO;
import com.forum.dao.impl.ReplyTopicDAOImpl;
import com.forum.model.Reply;
import com.forum.service.ReplyTopicService;

public class ReplyTopicServiceImpl implements ReplyTopicService {

	public void saveReplyTopic(Reply reply) {
		ReplyTopicDAO replyTopicDAO=new ReplyTopicDAOImpl();

		replyTopicDAO.saveReplyTopic(reply);
	}

	public List<Reply> ListAllReplyTopics(int topic_ID) {
		ReplyTopicDAO replyTopicDAO=new ReplyTopicDAOImpl();
		
		return replyTopicDAO.ListAllReplyTopics(topic_ID);
		
	}

	public void removeReplyTopic(int topic_ID) {
		ReplyTopicDAO replyTopicDAO=new ReplyTopicDAOImpl();
		replyTopicDAO.removeReplyTopic(topic_ID);
	}

}
