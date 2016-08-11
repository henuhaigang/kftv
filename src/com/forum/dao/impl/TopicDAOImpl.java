package com.forum.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.forum.dao.TopicDAO;
import com.forum.model.Topic;
import com.forum.model.User;
import com.forum.util.HibernateUtil;

/**
 * 对数据库的操作
 * 
 * @author haigang
 * 
 */
public class TopicDAOImpl implements TopicDAO {
	@SuppressWarnings("unchecked")
	// 去掉警告
	public List<Topic> listTopic() {

		Session session = HibernateUtil.openSession();

		Transaction tx = session.beginTransaction();

		List<Topic> list = null;

		try {
			Query query = session.createQuery("from Topic");

			list = (List<Topic>) query.list();

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

	/**
	 * 得到单个帖子
	 */
	public Topic getSingleTopicById(int topicID) {

		Session session = HibernateUtil.openSession();

		Transaction tx = session.beginTransaction();

		Topic topic = null;

		try {
			topic = (Topic) session.get(Topic.class, topicID);

			tx.commit();

		} catch (Exception ex) {
			if (null != tx) {
				tx.rollback();
			}
		} finally {
			HibernateUtil.close(session);
		}

		return topic;
	}

	public void saveTopic(Topic topic) {
		Session session = HibernateUtil.openSession();

		Transaction tx = session.beginTransaction();

		try {

			session.save(topic);

			tx.commit();

		} catch (Exception ex) {
			if (null != tx) {
				tx.rollback();
			}
		} finally {
			HibernateUtil.close(session);
		}
	}

	/**
	 * 列出自己的帖子
	 */
	public List<Topic> listMyTopic(String user_ID) {
		Session session = HibernateUtil.openSession();

		// Transaction tx = session.beginTransaction();

		List<Topic> list = null;

		try {

			Query query = session
					.createQuery("from Topic topic where topic.userID = :user_ID");
			query.setString("user_ID", user_ID);
			list = (List<Topic>) query.list();

			// /tx.commit();

		} catch (Exception ex) {

			ex.printStackTrace();
			// if (null != tx) // 如果为空则返回
			// {
			// tx.rollback();
			// }

		} finally {
			HibernateUtil.close(session); // 关闭session
		}

		return list;
	}

	/**
	 * 删除指定的帖子
	 */
	public void removeTopic(int topicID) {
		Session session = HibernateUtil.openSession();

		Transaction tx = session.beginTransaction();
		Topic topic = null;
		try {

			topic = (Topic) session.get(Topic.class, topicID);

			session.delete(topic);

			tx.commit();

		} catch (Exception ex) {

			if (null != tx) // 如果为空则返回
			{
				tx.rollback();
			}

		} finally {
			HibernateUtil.close(session); // 关闭session
		}
	}

	/**
	 * 添加点击次数
	 * 
	 * @param topicID
	 *            帖子Id
	 * @param count
	 *            点击次数
	 */
	public void addClickCount(Topic topic) { // int topicID,int count){
		Session session = HibernateUtil.openSession();

		Transaction tx = session.beginTransaction();

		
		try {

			// Query query =
			// session.createQuery("update Topic topic set topic.clickCount=:count where topic.topicID = :topicID");

			session.update(topic);

			tx.commit();

		} catch (Exception ex) {
			if (null != tx) {
				tx.rollback();
			}
		} finally {
			HibernateUtil.close(session);
		}
	}

	/**
	 * 分页用的方法
	 * 
	 * @param pageSize
	 *            每一页的记录数
	 * @param pageNow
	 *            当前页
	 * @param HQL
	 *            查询语句
	 * @return
	 */

	public List<Topic> queryByPage(int pageSize, int pageNow, String userID) {
		Session session = HibernateUtil.openSession();

		// Transaction tx = session.beginTransaction();

		List<Topic> list = null;
		try {

			Query query = session
					.createQuery("from Topic topic where topic.userID=:userID");// 执行查询操作
			query.setString("userID", userID);
			query.setFirstResult(pageSize * (pageNow - 1));
			query.setMaxResults(pageSize);
			list = (List<Topic>) query.list();
		} catch (Exception ex) {
			// if (null != tx) {
			// tx.rollback();
			// }
			ex.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
		return list;
	}

	/**
	 * 得到页面总数
	 * 
	 * @param pagesize
	 *            页面的大小
	 * @param HQL
	 * @return返回页数
	 */
	public int getpageCount(int pagesize, String userID) {
		int pageCount;
		int Datacount = 0;
		Session session = HibernateUtil.openSession();

		// Transaction tx = session.beginTransaction();

		List<Topic> list = null;
		try {
			Query query = session
					.createQuery("from Topic topic where topic.userID=:userID");// 执行查询操作
			query.setString("userID", userID);
			Datacount = query.list().size(); // 获得记录总数
		} catch (Exception ex) {
			// if (null != tx) {
			// tx.rollback();
			// }
			ex.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
		if (Datacount % pagesize == 0) {
			pageCount = Datacount / pagesize;
		} else {
			pageCount = Datacount / pagesize + 1;
		}

		return pageCount;

	}

	/**
	 * 查询所有帖子
	 * 
	 * @param pageSize
	 * @param pageNow
	 * @return
	 */
	public List<Topic> queryAllByPage(int pageSize, int pageNow) {
		Session session = HibernateUtil.openSession();

		// Transaction tx = session.beginTransaction();

		List<Topic> list = null;
		try {

			Query query = session.createQuery("from Topic");// 执行查询操作

			query.setFirstResult(pageSize * (pageNow - 1));
			query.setMaxResults(pageSize);
			list = (List<Topic>) query.list();
		} catch (Exception ex) {
			// if (null != tx) {
			// tx.rollback();
			// }
			ex.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
		return list;
	}

	/**
	 * 得到所有帖子页面总数
	 * 
	 * @param pagesize
	 *            页面的大小
	 * @return返回页数
	 */
	public int getpageCount(int pagesize) {
		int pageCount;
		int Datacount = 0;
		Session session = HibernateUtil.openSession();

		// Transaction tx = session.beginTransaction();

		List<Topic> list = null;
		try {
			Query query = session.createQuery("from Topic");// 执行查询操作
			Datacount = query.list().size(); // 获得记录总数
		} catch (Exception ex) {
			// if (null != tx) {
			// tx.rollback();
			// }
			ex.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
		if (Datacount % pagesize == 0) {
			pageCount = Datacount / pagesize;
		} else {
			pageCount = Datacount / pagesize + 1;
		}

		return pageCount;
	}

	/**
	 * 查询当前板块的所有帖子
	 * 
	 * @param pageSize
	 * @param pageNow
	 * @return
	 */
	public List<Topic> queryChildrenByPage(int pageSize, int pageNow,
			int sectionID) {
		Session session = HibernateUtil.openSession();

		// Transaction tx = session.beginTransaction();

		List<Topic> list = null;
		try {

			Query query = session
					.createQuery("from Topic topic where topic.sectionID=?");// 执行查询操作
			query.setInteger(0, sectionID);
			query.setFirstResult(pageSize * (pageNow - 1));
			query.setMaxResults(pageSize);
			list = (List<Topic>) query.list();
		} catch (Exception ex) {
			// if (null != tx) {
			// tx.rollback();
			// }
			ex.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
		return list;
	}

	/**
	 * 得到当前板块所有帖子页面总数
	 * 
	 * @param pagesize
	 *            页面的大小
	 * @param HQL
	 * @return返回页数
	 */
	public int getChildrenpageCount(int pagesize, int sectionID) {
		int pageCount;
		int Datacount = 0;
		Session session = HibernateUtil.openSession();

		// Transaction tx = session.beginTransaction();

		List<Topic> list = null;
		try {
			Query query = session
					.createQuery("from Topic topic where topic.sectionID=?");// 执行查询操作
			query.setInteger(0, sectionID);
			Datacount = query.list().size(); // 获得记录总数
		} catch (Exception ex) {
			// if (null != tx) {
			// tx.rollback();
			// }
			ex.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
		if (Datacount % pagesize == 0) {
			pageCount = Datacount / pagesize;
		} else {
			pageCount = Datacount / pagesize + 1;
		}

		return pageCount;
	}

	/**
	 * 得到最热的帖子
	 * 
	 * @return 帖子列表
	 */
	public List<Topic> getHotTopic() {

		Session session = HibernateUtil.openSession();

		Transaction tx = session.beginTransaction();

		List<Topic> list = null;

		try {
			Query query = session
					.createQuery("from Topic topic order by topic.clickCount desc");

			query.setFirstResult(0);// 开始从第几条开始取数据

			query.setMaxResults(10);// 取多少条数据

			list = (List<Topic>) query.list();

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

	/**
	 * 得到最热的帖子
	 * 
	 * @return 帖子列表
	 */
	public List<Topic> getNewHotTopic() {

		Session session = HibernateUtil.openSession();

		Transaction tx = session.beginTransaction();

		List<Topic> list = null;

		try {
			Query query = session
					.createQuery("from Topic topic order by topic.publishDate desc");

			query.setFirstResult(0);// 开始从第几条开始取数据

			query.setMaxResults(10);// 取多少条数据

			list = (List<Topic>) query.list();

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

	/**
	 * 得到发帖人的信息---帖子
	 * 
	 * @return
	 */
	public List<Topic> getAuthorHotTopic(String userID) {

		Session session = HibernateUtil.openSession();

		Transaction tx = session.beginTransaction();

		List<Topic> list = null;

		try {
			Query query = session
					.createQuery("from Topic topic  where topic.userID=:userID order by topic.publishDate desc");

			query.setString("userID", userID);

			query.setFirstResult(0);// 开始从第几条开始取数据

			query.setMaxResults(5);// 取多少条数据

			list = (List<Topic>) query.list();

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

	public List<Topic> searchTopics(String title) {

		Session session = HibernateUtil.openSession();

		//Transaction tx = session.beginTransaction();

		List<Topic> list = null;

		try {
			Query query = session
					.createQuery("from Topic topic  where topic.title like :title");

			System.out.println(title+"===============");
			query.setString("title", "%"+title+"%");

//			query.setFirstResult(pageSize * (pageNow - 1));
//
//			query.setMaxResults(pageSize);

			list = (List<Topic>) query.list();

		
			//tx.commit();

		} catch (Exception ex) {
//
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
}
