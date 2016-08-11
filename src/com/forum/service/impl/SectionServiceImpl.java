package com.forum.service.impl;

import java.util.List;

import com.forum.dao.SectionDAO;
import com.forum.dao.impl.SectionDAOImpl;
import com.forum.model.Section;
import com.forum.model.Topic;
import com.forum.service.SectionService;

public class SectionServiceImpl implements SectionService {

	public List<Section> achieveParent() {
		SectionDAO setionDAO=new SectionDAOImpl();
		return setionDAO.achieveParent();
	}

	public List<Section> achievechildren() {
		SectionDAO setionDAO=new SectionDAOImpl();
		return setionDAO.achievechildren();
	}

	public List<Topic> selectTopicsById(int sectionID) {
		SectionDAO setionDAO=new SectionDAOImpl();
		return setionDAO.selectTopicsById(sectionID);
	}

	public Section getSignleSectionByID(int sectionID) {
		SectionDAO sectionDAO=new SectionDAOImpl();
		
		return sectionDAO.getSignleSectionByID(sectionID);
	}

}
