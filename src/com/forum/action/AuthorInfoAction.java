package com.forum.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.struts2.ServletActionContext;


import com.forum.dao.impl.MessageDAOImpl;

import com.forum.model.Message;
import com.forum.model.Topic;
import com.forum.model.User;
import com.forum.service.TopicService;
import com.forum.service.UserService;
import com.forum.service.impl.TopicServiceImpl;
import com.forum.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 得到作者相关类信息
 * 
 * @author haigang
 * 
 */
public class AuthorInfoAction extends ActionSupport {

	private int pageNow = 1; // 初始化为1,默认从第一页开始显示
	private int pageSize = 3; // 每页显示5条记录
	private int pageCount;// 总页数

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * 从帖子里点击得到单个用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAuthorInfo() throws Exception {

		
		
		HttpServletRequest request = ServletActionContext.getRequest();

		String userID = request.getParameter("userID");

		String authorID = request.getParameter("authorID");

		String userName = request.getParameter("userName");

		String flag = request.getParameter("flag");
		// 得到了个人信息
		UserService userService = new UserServiceImpl();

		User user = userService.getSingleUserById(authorID);

		request.setAttribute("user", user);

		// 获得用户的帖子

		TopicService topicService = new TopicServiceImpl();

		// 得到作者最新动态
		List<Topic> newList = topicService.getAuthorHotTopic(authorID);

		request.setAttribute("newList", newList);

		pageNow = Integer.parseInt(request.getParameter("pageNow")); // 获得当前页码

		int pageCount = topicService.getpageCount(pageSize, authorID);// 页面数(从数据库里得到的记录数)
		// 添加验证，看页面请求是否合法
		List<Topic> list = null;

		if (pageNow >= pageCount) {
			SortPage sortPage = new SortPage();
			sortPage.setPageNow(pageCount - 1);
			pageNow = sortPage.getPageNow();
			list = topicService.queryByPage(pageCount, pageNow, authorID);

		}

		else {
			list = topicService.queryByPage(pageCount, pageNow, authorID);
		}

		MessageDAOImpl mdi = new MessageDAOImpl();
		if (flag.equals("1")) {// 得到用户留言

			Message message = new Message();

			String content = request.getParameter("content");
			
			// message.setMessageID(messageID);

			// String user_ID=request.getParameter("user_ID");

			message.setAuthorID(authorID);

			message.setContent(content);

			
			
			java.sql.Date publishDate = new java.sql.Date(
					new java.util.Date().getTime());

			message.setPublishDate(publishDate);

			message.setUserID(userID);

			mdi.saveMessage(message);

			// 用户留言结束

		}

		List<Message> listMessage = mdi.listOneMessage(userID);

		request.setAttribute("listMessage", listMessage);

		request.setAttribute("list", list);

		request.setAttribute("pageNow", pageNow);

		request.setAttribute("pageCount", pageCount);

		request.setAttribute("authorID", authorID);

		request.setAttribute("userID", userID);

		request.setAttribute("userName", userName);

		return SUCCESS;
		
	}

	/**
	 * 搜索
	 * 
	 * @return
	 * @throws Exception
	 */

	public String search() throws Exception {

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
		
		else{//如果用户存在（即用户已经登录）
		
		String searchText = request.getParameter("searchText");

		String sel = request.getParameter("Item");
		
		List<User> listUser = null;
		List<Topic> list = null;
		if (sel.equals("0")) {
			TopicService topicService = new TopicServiceImpl();
			list = topicService.searchTopics(searchText);
			request.setAttribute("list", list);

			return SUCCESS;
		} else {
			
			UserService userService = new UserServiceImpl();
			
			listUser = userService.searchUser(searchText);
			
			request.setAttribute("listUser", listUser);
			
			return "searchSuccess";
		}

	}
	}
}
