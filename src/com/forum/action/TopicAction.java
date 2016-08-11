 package com.forum.action;

import java.sql.Date;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.forum.dao.UserDAO;
import com.forum.dao.impl.TopicDAOImpl;
import com.forum.dao.impl.UserDAOImpl;
import com.forum.model.Reply;
import com.forum.model.Section;
import com.forum.model.Topic;
import com.forum.model.User;

import com.forum.service.ReplyTopicService;
import com.forum.service.SectionService;
import com.forum.service.TopicService;
import com.forum.service.UserService;

import com.forum.service.impl.ReplyTopicServiceImpl;
import com.forum.service.impl.SectionServiceImpl;
import com.forum.service.impl.TopicServiceImpl;
import com.forum.service.impl.UserServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 个人帖子的action
 * 
 * @author haigang
 * 
 */
public class TopicAction extends ActionSupport {

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
	private int currentCount = 1;  //设置点击次数
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

	public boolean getEssence() {
		return isEssence;
	}

	public void setEssence(boolean isEssence) {
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

	// private Set replys=new HashSet();
	//
	//
	// public Set getReplys() {
	// return replys;
	// }
	//
	// public void setReplys(Set replys) {
	// this.replys = replys;
	// }
	//
	// private String user_ID; //对应user表中的id，以便实现关联

	// private User user; // 用户对象，也是为了关联而添加的 此处是个关联的地方，现在假设我将它显示（关系到是否删除成功的问题）
	//
	// public User getUser() {
	// return user;
	// }
	//
	// public void setUser(User user) {
	// this.user = user;
	// }

	/**
	 * 列出帖子
	 * 
	 * @return success
	 * @throws Exception
	 */

	public String showTopic() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		// String user_ID = requestuser.getParameter("user_ID");
		String user_ID = (String) request.getParameter("userID");

		String userName = request.getParameter("userName");
		// UserDAOImpl userDAOImpl=new UserDAOImpl();
		
		// User user1=userDAOImpl.getSingleUserById(user_ID);//得到了发帖人的用户信息

		TopicService topicService = new TopicServiceImpl();

		List<Topic> list = topicService.listTopic(); // 显示帖子

		// 此处要注意，在以后的操作中还要根据用户信息得到个人的帖子

		// HttpServletRequest request = ServletActionContext.getRequest(); //
		// 得到请求

		request.setAttribute("list", list); // /设置list
		request.setAttribute("user_ID", user_ID);
		request.setAttribute("userName", userName);
		// System.out.println(user_ID+"====1===");
		return SUCCESS;
	}

	
	/**
	 * 得到自己的帖子
	 */

	public String showMyTopic() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		// String user_ID = requestuser.getParameter("user_ID");
		String user_ID = request.getParameter("userID");

		System.out.println("用户的ID为" + user_ID);
		String userName = request.getParameter("userName");

		TopicService topicService = new TopicServiceImpl();

		List<Topic> list = topicService.listMyTopic(user_ID);

		request.setAttribute("list", list);

		request.setAttribute("userID", user_ID);
		request.setAttribute("userName", userName);

		return SUCCESS;
	}

	/**
	 * 得到单个的帖子，增加点击次数
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getSingleTopic() throws Exception {   
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		TopicService topicService = new TopicServiceImpl();

		Topic topic = topicService.getSingleTopicById(topicID); //得到帖子记录
		
		/////////////////////////////////////////////////////////////
		String aid=topic.getUserID();   //得到发帖人的id
		
		UserService userService=new UserServiceImpl();
		
		User user=userService.getSingleUserById(aid);
		
		String aName=user.getUserName();
		
		request.setAttribute("aName", aName);
		
		request.setAttribute("user",user);   //设置用户
		////////////////////////////////////////////////
		
		//点击次数
		int count=topic.getClickCount();  //得到点击次数
		topic.setClickCount(count+1);   //次数加一
		topicService.addClickCount(topic);	//更新

		

		
		String userID=request.getParameter("userID");
		request.setAttribute("userID", userID);
		String userName = request.getParameter("userName");
		request.setAttribute("userName", userName);
		
		request.setAttribute("topic", topic);

		// 得到所有回帖
		// HttpServletRequest requestuser = ServletActionContext.getRequest();

		ReplyTopicService replyTopicService = new ReplyTopicServiceImpl();

		// replyTopicService.saveReplyTopic(reply);

		// 尝试得到所有回帖
		// String _rUsername = request.getParameter("_rUsername");
		

		List<Reply> list = replyTopicService.ListAllReplyTopics(topicID);

		//HttpServletRequest request1 = ServletActionContext.getRequest();

		request.setAttribute("list", list);

		return SUCCESS;
	}
	/**
	 * 得到作者的单个帖子
	 * @return
	 * @throws Exception
	 */
	
	public String getAuthorSingleTopic() throws Exception {   
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		TopicService topicService = new TopicServiceImpl();

		Topic topic = topicService.getSingleTopicById(topicID); //得到帖子记录
		
		
		
		
//////////////////////////////////////////////////////////////////////////
		
         String aid=topic.getUserID();   //得到发帖人的id
		
		UserService userService=new UserServiceImpl();
		
		User user=userService.getSingleUserById(aid);
		
		String aName=user.getUserName();
		
		request.setAttribute("aName", aName);
		
		request.setAttribute("user",user);   //设置用户
		
//////////////////////////////////////////////////////////////////		
		
		
		
		
		
		//点击次数
		int count=topic.getClickCount();  //得到点击次数
		topic.setClickCount(count+1);   //次数加一
		topicService.addClickCount(topic);	//更新

		
    
		String authorID=request.getParameter("authorID");
	    
		request.setAttribute("authorID", authorID);
		
		String userID=request.getParameter("userID");
		request.setAttribute("userID", userID);
		String userName = request.getParameter("userName");
		request.setAttribute("userName", userName);
		
		request.setAttribute("topic", topic);

		// 得到所有回帖
		// HttpServletRequest requestuser = ServletActionContext.getRequest();

		ReplyTopicService replyTopicService = new ReplyTopicServiceImpl();

		// replyTopicService.saveReplyTopic(reply);

		// 尝试得到所有回帖
		// String _rUsername = request.getParameter("_rUsername");
		

		List<Reply> list = replyTopicService.ListAllReplyTopics(topicID);

		//HttpServletRequest request1 = ServletActionContext.getRequest();

		request.setAttribute("list", list);
 
		return SUCCESS;
	}
	
	/**
	 * 得到登录用户的帖子
	 * @return
	 * @throws Exception
	 */
      public String getMySingleTopic() throws Exception {   
		
		TopicService topicService = new TopicServiceImpl();

		Topic topic = topicService.getSingleTopicById(topicID); //得到帖子记录
		
		//点击次数
		int count=topic.getClickCount();  //得到点击次数
		topic.setClickCount(count+1);   //次数加一
		topicService.addClickCount(topic);	//更新

		HttpServletRequest request = ServletActionContext.getRequest();

		request.setAttribute("topic", topic);

		// 得到所有回帖
		// HttpServletRequest requestuser = ServletActionContext.getRequest();

		ReplyTopicService replyTopicService = new ReplyTopicServiceImpl();

		// replyTopicService.saveReplyTopic(reply);

		// 尝试得到所有回帖
		// String _rUsername = request.getParameter("_rUsername");
		String userName = request.getParameter("userName");
		
		request.setAttribute("userName", userName);

		List<Reply> list = replyTopicService.ListAllReplyTopics(topicID);

		HttpServletRequest request1 = ServletActionContext.getRequest();

		request1.setAttribute("list", list);

		return SUCCESS;
	}

	/**
	 * 发帖跳转过度（跳转到发帖页面）
	 * @return
	 * @throws Exception
	 */
	public String publichSwitch() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String user_ID = request.getParameter("userID");
		request.setAttribute("userID", user_ID);
		String userName = request.getParameter("userName");
		request.setAttribute("userName", userName);
		// 得到子版块
		SectionService sectionService = new SectionServiceImpl();
		List<Section> listchildren = sectionService.achievechildren();

		request.setAttribute("listchildren", listchildren);
		return SUCCESS;
	}

	/**
	 * 发帖
	 * 
	 * @throws Exception
	 */
	public String publishTopic() throws Exception {

		// 此处是想根据用户的ID得到用户信息

		HttpServletRequest request = ServletActionContext.getRequest();
		String userID = request.getParameter("userID");// 得到用户名和用户Id，并设置
		String userName = request.getParameter("userName");
		request.setAttribute("userID", userID);
		request.setAttribute("userName", userName);

		UserDAOImpl userDAOImpl = new UserDAOImpl();

		User user1 = userDAOImpl.getSingleUserById(userID);// 得到了发帖人的用户信息

		Topic topic = new Topic();
		topic.setTitle(title);
		topic.setContent(content);
		//topic.setUserName(userName);
		java.sql.Date PublishDate = new java.sql.Date(
				new java.util.Date().getTime());
		topic.setPublishDate(PublishDate);
		topic.setModifyDate(modifyDate);
		topic.setClickCount(clickCount);
		topic.setReplyCount(replyCount);
		topic.setIsEssence(isEssence);
		topic.setSectionID(sectionID);
		topic.setIsVerify(isVerify);
		topic.setUserID(userID);
		// topic.setUser(user1);

		TopicService topicService = new TopicServiceImpl();
		topicService.saveTopic(topic);

		// 显示帖子
		List<Topic> list = topicService.listTopic(); // 显示帖子
		request.setAttribute("list", list); // /设置list

		return "success";

	}

	/**
	 * 删帖
	 * 
	 * @return
	 * @throws Exception
	 */
	public String removeTopic() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();

		String id = request.getParameter("topicID");

		int topicID = Integer.parseInt(id);

		// 删除相应回帖
		ReplyTopicService replyTopicService = new ReplyTopicServiceImpl();

		replyTopicService.removeReplyTopic(topicID);

		// 删除帖子
		TopicService topicService = new TopicServiceImpl();
		topicService.removeTopic(topicID);

		// 显示自己的所有帖子
		String userName = request.getParameter("userName");
		
		String user_ID = (String) request.getParameter("userID");

		List<Topic> list = topicService.listMyTopic(user_ID);

		request.setAttribute("list", list);

		request.setAttribute("user_ID", user_ID);
		request.setAttribute("userName", userName);

		return SUCCESS;
	}
	
	
}
