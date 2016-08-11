package com.forum.action;

import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;


import com.forum.model.Reply;
import com.forum.model.Topic;
import com.forum.model.User;
import com.forum.service.ReplyTopicService;
import com.forum.service.TopicService;
import com.forum.service.UserService;
import com.forum.service.impl.ReplyTopicServiceImpl;
import com.forum.service.impl.TopicServiceImpl;
import com.forum.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 回帖表对应的持久化类
 * 
 * @author haigang
 * 
 */
public class ReplyTopicAction extends ActionSupport {

	private int replyID;
	private int topicID;
	private String content;
	//private String userName;
	private Date publishDate;
	private String userID;
	

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
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * 回帖处理的action，添加回帖次数
	 * 
	 * @throws Exception
	 */
	public String replyTopic() throws Exception {

		HttpServletResponse response=ServletActionContext.getResponse();  //得到reponse对象
		HttpServletRequest request = ServletActionContext.getRequest();   //得到request对象
		
		response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
		response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
		response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
		response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
		 HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		if (null == userName) {  //不能正常完成回帖
		   request.setAttribute("Error", "请您先登录再进行其他操作！");
//		   RequestDispatcher rd = request.getRequestDispatcher("user/userLogin.jsp");
//		   rd.forward(request, response);
		  return "error";
		  
		}
		
		else{  //正常完成回帖
		
		
		
		Reply reply = new Reply();

		
		reply.setContent(content);
	
		//reply.setUserName(userName);

		java.sql.Date _rPublishDate = new java.sql.Date(
				new java.util.Date().getTime());

		reply.setPublishDate(_rPublishDate);

		//HttpServletRequest request = ServletActionContext.getRequest();

		int topicID = Integer.parseInt(request.getParameter("topicID"));
		
		reply.setTopicID(topicID);
		
		reply.setUserID(userID);

		ReplyTopicService replyTopicService = new ReplyTopicServiceImpl();

		replyTopicService.saveReplyTopic(reply);

		
		
		
		
		// 尝试得到所有回帖
		
		List<Reply> list = replyTopicService.ListAllReplyTopics(topicID);
		

		HttpServletRequest request1 = ServletActionContext.getRequest();

		request1.setAttribute("list", list);

		// 得到原来的帖子
		TopicService topicService = new TopicServiceImpl();

		Topic topic = topicService.getSingleTopicById(topicID);

		//得到回帖数
		int count=topic.getReplyCount();   //得到原来的回帖数
		count=count+1;                     //加1操作
		topic.setReplyCount(count);     
		topicService.addClickCount(topic);   //更新回帖数
		
		
		request.setAttribute("topic", topic);

		String name = request.getParameter("userName");   //当前用户名称

		request.setAttribute("userName", name);

		request.setAttribute("userID", userID);
		
		
		
		
	/////////////////////////////////==========================
         String aid=topic.getUserID();   //得到发帖人的id
		
		UserService userService=new UserServiceImpl();
		
		User user=userService.getSingleUserById(aid);
		
		String aName=user.getUserName();
		
		request.setAttribute("aName", aName);
		
		request.setAttribute("user",user);   //设置用户
		////////////////////////////////////////========================
		
	
		
		
		return SUCCESS;
		}
	}

	public String listAllreply() throws Exception {

		return null;
	}

}
