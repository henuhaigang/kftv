package com.forum.service;

import java.util.List;

import com.forum.model.Reply;

public interface ReplyTopicService {
	public void saveReplyTopic(Reply reply);
	//public List<Reply> ListAllReplyTopics(String _rUsername);
	public List<Reply> ListAllReplyTopics(int topic_ID);
	
	public void removeReplyTopic(int topic_ID);
}
