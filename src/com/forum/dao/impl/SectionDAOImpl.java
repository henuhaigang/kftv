package com.forum.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.forum.dao.SectionDAO;
import com.forum.model.Reply;
import com.forum.model.Section;
import com.forum.model.Topic;
import com.forum.util.HibernateUtil;

public class SectionDAOImpl implements SectionDAO {
/**
 * 得到所有的一级板块
 */
	public List<Section> achieveParent() {
		
		
		Session session = HibernateUtil.openSession();

		//Transaction tx = session.beginTransaction();
		List<Section> list=null;
		try{
			Query query=session.createQuery("from Section se where se.parentSectionID is null");//= ?");
			//query.setInteger(0, 0);
		   
			list=(List<Section>)query.list();
			//tx.commit();
		    System.out.println("haha"+list.size());
		}catch(Exception ex){
//			if (null != tx) {
//				tx.rollback();
//			}
			ex.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
	
		return list;
	}
/**
 *得到所有不是顶级的板块
 */
	public List<Section> achievechildren() {
		

		Session session = HibernateUtil.openSession();

		Transaction tx = session.beginTransaction();
		List<Section> list=null;
		try{
			
			Query query=session.createQuery("from Section se where se.parentSectionID is not null");// !=? ");
			//query.setInteger(0, 0);
			
			list=(List<Section>)query.list();
			
			System.out.println("====="+list.size());
			tx.commit();
			
		}catch(Exception ex){
			if (null != tx) {
				tx.rollback();
			}
		} finally {
			HibernateUtil.close(session);
		}
	
		
		
		return list;
	}
public List<Topic> selectTopicsById(int sectionID) {
	Session session = HibernateUtil.openSession();

	Transaction tx = session.beginTransaction();
	List<Topic> list=null;
	
	try{
		
		Query query=session.createQuery("from Topic tp where tp.sectionID =?");
		query.setInteger(0,sectionID);
		list=(List<Topic>)query.list();
		tx.commit();
		
	}catch(Exception ex){
		if (null != tx) {
			tx.rollback();
		}
	} finally {
		HibernateUtil.close(session);
	}

	return list;
}
/**
 * 得到板块记录
 */
public Section getSignleSectionByID(int sectionID) {
	Session session = HibernateUtil.openSession();

	Transaction tx = session.beginTransaction();
	Section section=null;
	
try{
	section = (Section) session.get(Section.class, sectionID);
		
		tx.commit();
		
	}catch(Exception ex){
		if (null != tx) {
			tx.rollback();
		}
		
	} finally {
		
		HibernateUtil.close(session);
	}
	
	return section;
}

}
