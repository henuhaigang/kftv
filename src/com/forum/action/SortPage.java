package com.forum.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.forum.model.Topic;
import com.forum.service.TopicService;
import com.forum.service.impl.TopicServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class SortPage extends ActionSupport {
	private int pageNow = 1; // 初始化为1,默认从第一页开始显示
	private int pageSize = 3; // 每页显示5条记录
	private int pageCount;// 总页数
	private String returnValue;// 标记Action返回的值

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

	public String getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(String returnValue) {
		this.returnValue = returnValue;
	}

	/**
	 * 给当前用户的帖子进行分页
	 * @return
	 * @throws Exception
	 */
	public String pageSort() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();

	     pageNow = Integer.parseInt(request.getParameter("pageNow")); // 获得当前页码

		String userID = request.getParameter("userID");

		String userName = request.getParameter("userName");

		TopicService topicService = new TopicServiceImpl();

		int pageCount = topicService.getpageCount(pageSize, userID);// 页面数(从数据库里得到的记录数)
		// 添加验证，看页面请求是否合法
		List<Topic> list = null;
		// if(pageNow<1)
		// {
		// pageNow=1;
		// list= topicDAOImpl.queryByPage(pageCount, pageNow, userID);
		// }else if(pageNow>pageCount)
		// {
		// pageNow=pageCount;
		// list= topicDAOImpl.queryByPage(pageCount, pageNow, userID);
		// }
		if (pageNow >= pageCount) {
			SortPage sortPage=
			new SortPage();
			sortPage.setPageNow(pageCount-1);
			pageNow=sortPage.getPageNow();
			list = topicService.queryByPage(pageCount, pageNow, userID);

		}
		// List<Topic> list= topicDAOImpl.queryByPage(pageCount, pageNow,
		// userID);
		else{
		list = topicService.queryByPage(pageCount, pageNow, userID);
		}
		request.setAttribute("list", list);

		request.setAttribute("pageNow", pageNow);

		request.setAttribute("pageCount", pageCount);

		request.setAttribute("userID", userID);

		request.setAttribute("userName", userName);

		return "success";
	}
    /**
       * 给总帖子数分页
      * @return
      * @throws Exception
    */
	public String allPageSort() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();

	     pageNow = Integer.parseInt(request.getParameter("pageNow")); // 获得当前页码

	   
		String userID = request.getParameter("userID");

		String userName = request.getParameter("userName");

		TopicService topicService = new TopicServiceImpl();

		int pageCount = topicService.getpageCount(pageSize);//.getpageCount(pageSize);// 页面数(从数据库里得到的记录数)
		// 添加验证，看页面请求是否合法
		List<Topic> list = null;
		
		if (pageNow >= pageCount) {
			SortPage sortPage=
			new SortPage();
			sortPage.setPageNow(pageCount-1);
			pageNow=sortPage.getPageNow();
			list = topicService.queryAllByPage(pageCount, pageNow);

		}
		else{
			
		list = topicService.queryAllByPage(pageCount, pageNow);
		
		}
		request.setAttribute("list", list);

		request.setAttribute("pageNow", pageNow);

		request.setAttribute("pageCount", pageCount);

		request.setAttribute("userID", userID);

		request.setAttribute("userName", userName);
		
		
		
		return SUCCESS;
	}
	
	/**
	 * 给子版块进行分页
	 * @return
	 * @throws Exception
	 */
    public String childrenPageSort() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();

	     pageNow = Integer.parseInt(request.getParameter("pageNow")); // 获得当前页码

	    // System.out.println(pageNow);
		
	     int sectionID =Integer.parseInt(request.getParameter("sectionID"));

		String userID = request.getParameter("userID");

	     TopicService topicService = new TopicServiceImpl();

		int pageCount = topicService.getChildrenpageCount(pageSize, sectionID);//.getpageCount(pageSize);//.getpageCount(pageSize);// 页面数(从数据库里得到的记录数)
		// 添加验证，看页面请求是否合法
		List<Topic> list = null;
		
		if (pageNow >= pageCount) {
			SortPage sortPage=
			new SortPage();
			sortPage.setPageNow(pageCount-1);
			pageNow=sortPage.getPageNow();
			list = topicService.queryChildrenByPage(pageCount, pageNow, sectionID);//.queryAllByPage(pageCount, pageNow);  //给当前的子版块进行分页

		}
		else{
			
		list = topicService.queryChildrenByPage(pageCount, pageNow,sectionID);
		
		}
		request.setAttribute("list", list);

		request.setAttribute("pageNow", pageNow);

		request.setAttribute("pageCount", pageCount);

		request.setAttribute("sectionID", sectionID);
		
	request.setAttribute("userID", userID);
//
//		request.setAttribute("userName", userName);
	
		return SUCCESS;
	}
	
}
