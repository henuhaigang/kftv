package com.forum.model;
/**
 * section的持久化類
 * @author haigang
 *
 */
public class Section {

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

	

}
