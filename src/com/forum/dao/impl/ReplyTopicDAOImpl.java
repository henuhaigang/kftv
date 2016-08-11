package com.forum.dao.impl;



import java.util.List;



import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.forum.dao.ReplyTopicDAO;
import com.forum.model.Reply;

import com.forum.util.HibernateUtil;


public class ReplyTopicDAOImpl implements ReplyTopicDAO {

	public void saveReplyTopic(Reply reply) {
		Session session = HibernateUtil.openSession();

		Transaction tx = session.beginTransaction();
		try{
			
			    session.save(reply);
			
				tx.commit();
			
		}catch(Exception ex){
			if (null != tx) {
				tx.rollback();
			}
		} finally {
			HibernateUtil.close(session);
		}
	}

	public List<Reply> ListAllReplyTopics(int topic_ID) {
		Session session = HibernateUtil.openSession();
 
		Transaction tx = session.beginTransaction();
		
		List<Reply> list=null;
		 ScrollableResults srs = null;
		
		try{
			
			
			
			//Query query=session.createQuery("from Reply re where re.topicID =?");
			Query query=session.createQuery("from Reply re ,User user where re.topicID =? and user.userID=re.userID");
			//query.setString("_rUsername", _rUsername);
			query.setInteger(0, topic_ID);
			//System.out.println(_rUsername+"aaa");
			
			//srs=query.scroll();
			
			list=(List<Reply>)query.list();
			

			
			System.out.println(list.size());
			
			
			
			//tx.commit();
			
		} catch (Exception ex) {

//			if (null != tx) // 如果为空则返回
//			{
//				tx.rollback();
//			}
          ex.printStackTrace();
		} finally {
			HibernateUtil.close(session); // 关闭session
		}

		return list;
	
	}

	public void removeReplyTopic(int topic_ID) {
		Session session = HibernateUtil.openSession();
		 
		Transaction tx = session.beginTransaction();
		
		
		try{
//			 reply=(Reply)session.get(Reply.class, topic_ID);//有问题
//			 session.delete(reply);		
			Query query=session.createQuery("delete from Reply re where re.topicID =?");
			query.setInteger(0, topic_ID);
			query.executeUpdate();
			
			tx.commit();
			

		} catch (Exception ex) {

			if (null != tx) // 如果为空则回滚
			{
				tx.rollback();
			}

		} finally {
			HibernateUtil.close(session); // 关闭session
		}
	}

	
}
