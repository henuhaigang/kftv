package com.forum.service.impl;

import java.util.List;

import com.forum.dao.NoticeDAO;
import com.forum.dao.impl.NoticeDAOImpl;
import com.forum.model.Notice;
import com.forum.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	public List<Notice> listNotice() {
		NoticeDAO noticeDAO=new NoticeDAOImpl();
		
		return noticeDAO.listNotice();
	}

}
