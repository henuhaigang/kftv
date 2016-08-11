package com.forum.service;

import java.util.List;

import com.forum.model.Section;
import com.forum.model.Topic;

public interface SectionService {
	public List<Section> achieveParent();
	public List<Section> achievechildren();
	public List<Topic> selectTopicsById(int sectionID);
	public Section getSignleSectionByID(int sectionID);
}
