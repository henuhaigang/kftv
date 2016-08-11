package com.forum.action;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.forum.dao.impl.NoticeDAOImpl;
import com.forum.model.Notice;
import com.opensymphony.xwork2.ActionSupport; 

public class NoticeAction extends ActionSupport {

	private int noticeID;
	private String content;
	private Date publishDate;
	private String userID;
	public int getNoticeID() {
		return noticeID;
	}
	public void setNoticeID(int noticeID) {
		this.noticeID = noticeID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
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
	 * 得到通告
	 * @return
	 * @throws Exception
	 */
	public String achieveNotice() throws Exception{
		
		NoticeDAOImpl ndi=new NoticeDAOImpl();
		
		List<Notice> noticelist=ndi.listNotice();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("noticelist", noticelist);
		
		return SUCCESS;
	}
}
