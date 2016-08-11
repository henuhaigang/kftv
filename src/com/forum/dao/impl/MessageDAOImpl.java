package com.forum.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.forum.model.Message;
import com.forum.util.HibernateUtil;

public class MessageDAOImpl {

	public void saveMessage(Message message){
		Session session = HibernateUtil.openSession();

		Transaction tx = session.beginTransaction();
		try {
			session.save(message);
			tx.commit();

		} catch (Exception ex) {

			if (null != tx) {
				tx.rollback();// 回滚
			}
		} finally {
			HibernateUtil.close(session);// 关闭
		}
	}
	
	public List<Message> listOneMessage(String userID) {
		
		Session session = HibernateUtil.openSession();
		
		Transaction tx = session.beginTransaction();

		List<Message> list = null;

		try {
			// Person是类的名字而不是表的名字，既然是类的名字就需要严格区分大小写
			Query query = session.createQuery("from Message where userID=:userID "); // 从Person类创建查询

			query.setString("userID", userID);
			
			list = (List<Message>) query.list();// 获得列表

			tx.commit();// 事务提交
		} catch (Exception ex) {
			if (null != tx) {
				tx.rollback();
			}
		} finally {
			HibernateUtil.close(session);// 关闭
		}

		return list;
	}
	
	
	
}
