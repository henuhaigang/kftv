package com.forum.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.forum.dao.NoticeDAO;
import com.forum.model.Notice;

import com.forum.util.HibernateUtil;

public class NoticeDAOImpl implements NoticeDAO {

	
	public List<Notice> listNotice() {

		Session session = HibernateUtil.openSession();

		Transaction tx = session.beginTransaction();

		List<Notice> list = null;

		try {
			Query query = session.createQuery("from Notice notice order by notice.publishDate desc");

			query.setFirstResult(0);//开始从第几条开始取数据
		        
		    query.setMaxResults(10);//取多少条数据
				
			list = (List<Notice>) query.list();

			tx.commit();

		} catch (Exception ex) {

			if (null != tx) // 如果为空则返回
			{
				tx.rollback();
			}

		} finally {
			HibernateUtil.close(session); // 关闭session
		}

		return list;
	}

	
	
	
	
	
}
