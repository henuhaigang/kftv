package com.forum.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.forum.dao.impl.NoticeDAOImpl;
import com.forum.dao.impl.TopicDAOImpl;
import com.forum.model.Notice;
import com.forum.model.Section;
import com.forum.model.Topic;
import com.forum.model.User;
import com.forum.service.NoticeService;
import com.forum.service.SectionService;
import com.forum.service.TopicService;
import com.forum.service.impl.NoticeServiceImpl;
import com.forum.service.impl.SectionServiceImpl;
import com.forum.service.impl.TopicServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * section的逻辑处理
 * 
 * @author haigang
 * 
 */
public class SectionAction extends ActionSupport {

	private int sectionID;
	private Integer  parentSectionID;
	private String sectionName;
	private String sectionIntro;

	public int getSectionID() {
		return sectionID;
	}

	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
	}
	

//	public int getParentSectionID() {
//		return parentSectionID;
//	}
//
//	public void setParentSectionID(int parentSectionID) {
//		this.parentSectionID = parentSectionID;
//	}

	public Integer getParentSectionID() {
		return parentSectionID;
	}

	public void setParentSectionID(Integer parentSectionID) {
		this.parentSectionID = parentSectionID;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getSectionIntro() {
		return sectionIntro;
	}

	public void setSectionIntro(String sectionIntro) {
		this.sectionIntro = sectionIntro;
	}

	/**
	 * 用户没有登录下的首页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String achieveIndex() throws Exception {

		SectionService sectionService = new SectionServiceImpl();
		// 得到父亲板块
		List<Section> listParent = sectionService.achieveParent();

		HttpServletRequest request = ServletActionContext.getRequest(); // 得到请求

		request.setAttribute("listParent", listParent);

		// 得到子版块
		List<Section> listchildren = sectionService.achievechildren();

		request.setAttribute("listchildren", listchildren);

		// 得到最新的帖子
		TopicService topicService = new TopicServiceImpl();
		List<Topic> newHotList = topicService.getNewHotTopic();
		request.setAttribute("newHotList", newHotList);

		// 得到最热的帖子

		List<Topic> hotList = topicService.getHotTopic();

		request.setAttribute("hotList", hotList);

		// 得到通告

		NoticeService noticeService = new NoticeServiceImpl();

		List<Notice> noticelist = noticeService.listNotice();

		request.setAttribute("noticelist", noticelist);

		
		
		String userID = request.getParameter("userID");
		
		String userName = request.getParameter("userName");
		
//		List<User> list=(List<User>)request.getAttribute("list");
//		
//		request.setAttribute("list", list);
		
		
		
		request.setAttribute("userName", userName);
		
		request.setAttribute("userID", userID);
		
		return SUCCESS;
	}

	
	public String achieveSection() throws Exception {

		SectionService sectionService = new SectionServiceImpl();
		// 得到父亲板块
		List<Section> listParent = sectionService.achieveParent();

		HttpServletRequest request = ServletActionContext.getRequest(); // 得到请求

		request.setAttribute("listParent", listParent);

		// 得到子版块
		List<Section> listchildren = sectionService.achievechildren();

		request.setAttribute("listchildren", listchildren);

		// 得到最新的帖子
		TopicService topicService = new TopicServiceImpl();
		List<Topic> newHotList = topicService.getNewHotTopic();
		request.setAttribute("newHotList", newHotList);

		// 得到最热的帖子

		List<Topic> hotList = topicService.getHotTopic();

		request.setAttribute("hotList", hotList);

		// 得到通告

		NoticeService noticeService = new NoticeServiceImpl();

		List<Notice> noticelist = noticeService.listNotice();

		request.setAttribute("noticelist", noticelist);

		
		
		String userID = request.getParameter("userID");
		
		String userName = request.getParameter("userName");
		
//		List<User> list=(List<User>)request.getAttribute("list");
//		
//		request.setAttribute("list", list);
		
		
		
		request.setAttribute("userName", userName);
		
		request.setAttribute("userID", userID);
		
		return SUCCESS;
	}

	
	
	
	
	
	
	
	
	/**
	 * 得到相应类别的帖子
	 */
	public String selclas() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();

		int sectionID = Integer.parseInt(request.getParameter("sectionID"));
		SectionService sectionService = new SectionServiceImpl();

		Section section = sectionService.getSignleSectionByID(sectionID);

		// 得到子贴列表
		List<Topic> list = sectionService.selectTopicsById(sectionID);
		request.setAttribute("list", list);

		request.setAttribute("section", section);

		String userName = request.getParameter("userName");
		String userID = request.getParameter("userID");
		request.setAttribute("userID", userID);
		request.setAttribute("userName", userName);

		return SUCCESS;
	}
}
