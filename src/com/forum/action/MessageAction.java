package com.forum.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.forum.dao.impl.MessageDAOImpl;
import com.forum.model.Message;
import com.opensymphony.xwork2.ActionSupport;

public class MessageAction extends ActionSupport {
    
	private int messageID;
	
    private String content;
	
	private String userID;
	
	private String authorID;
	public int getMessageID() {
		return messageID;
	}

	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getAuthorID() {
		return authorID;
	}

	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}

	/**
	 * 留言
	 * @return
	 * @throws Exception
	 */
	
	public String leaveMessage() throws Exception{
		
		Message message=new Message();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//message.setMessageID(messageID);
		
		//String user_ID=request.getParameter("user_ID");
		
		message.setAuthorID(authorID);
		
		message.setContent(content);
		
		message.setUserID(userID);
		
		MessageDAOImpl mdi=new MessageDAOImpl();
		
		mdi.saveMessage(message);
		
		List<Message> listMessage=mdi.listOneMessage(userID);
				
		request.setAttribute("listMessage", listMessage);
				
		return SUCCESS;
		
	}
	
}
