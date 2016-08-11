package com.forum.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.forum.dao.UserDAO;
import com.forum.model.Topic;
import com.forum.model.User;
import com.forum.util.HibernateUtil;


/**
 * 本类用于逻辑处理，相当于JavaBean，实现UserDAO
 * 
 * @author haigang
 * 
 */
public class UserDAOImpl implements UserDAO {
	/**
	 * 事务处理
	 */
	public void saveUser(User user) {

		Session session = HibernateUtil.openSession();

		Transaction tx = session.beginTransaction();
		try {
			session.save(user);
			tx.commit();

		} catch (Exception ex) {

			if (null != tx) {
				tx.rollback();// 回滚
			}
		} finally {
			HibernateUtil.close(session);// 关闭
		}

	}
	/**
	 * 得到所有用户
	 */
	public List<User> listAllUser() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();

		List<User> list = null;

		try {
			// Person是类的名字而不是表的名字，既然是类的名字就需要严格区分大小写
			Query query = session.createQuery("from User"); // 从Person类创建查询

			list = (List<User>) query.list();// 获得列表

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
	/**
	 * 用户登录验证
	 */
	public List<User> getSingleUserByName(String userName, String password) {

		Session session = HibernateUtil.openSession();
		//Transaction tx = session.beginTransaction();

		List<User> list = null;
		try {
			// user = (User) session.get(User.class, userName);
			Query query = session.createQuery("from User u where u.userName=:userName and u.password=:password");
			query.setString("userName", userName);
			query.setString("password", password);
			list = (List<User>) query.list();// 获得列表
			//tx.commit();

		} catch (Exception ex) {
			//if (null != tx) {
			//	tx.rollback();
			//}
			ex.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
		return list;
	}
/**
 * 删除用户
 */
	
	public void removeUser(String userID) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user=null;
		try{
			
			 user=(User)session.get(User.class, userID);    //根据id得到person对象
			session.delete(user);
			tx.commit();
			
		}catch(Exception ex)
		{
			if(tx!=null){
			tx.rollback();
		}
			
		}finally{
			HibernateUtil.close(session);
		}
		
	
	}
	
	
	/**
	 * 修改用户
	 * 
	 */
	

	public void updateUser(User user) {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
try{
	        session.update(user);
			tx.commit();
			
		}catch(Exception ex)
		{
			if(tx!=null){
			tx.rollback();
		}
			
		}finally{
			HibernateUtil.close(session);
		}
		
	}
	/**
	 * 根据用户id得到单个用户
	 */
	public User getSingleUserById(String userID) {
		
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user=null;
		try{
			user=(User)session.get(User.class, userID);
			tx.commit();
		}catch(Exception ex)
		{if(null != tx)
		{
			tx.rollback();
		}
			
		}finally{
			
			HibernateUtil.close(session);
		}
	
		return user;
	}

	/*public Set<Topic> getMyTopicsById(String userID){
		
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user=null;
		try{
			user=(User)session.get(User.class, userID);
			
			tx.commit();
		}catch(Exception ex)
		{if(null != tx)
		{
			tx.rollback();
		}
			
		}finally{
			
			HibernateUtil.close(session);
		}
		
		Set set = user.getTopics();
		for(Iterator iter = set.iterator(); iter.hasNext();)
			{
				Topic topic = (Topic)iter.next();
				
				
			}
		
		return set;
	}*/
	public List<User> getUserByName(String userName, String password) {
		// 
		return null;
	}
	/**
	 * 测试是否存在改用户
	 */
	public List<User> getUserByName(String userName) {
		Session session = HibernateUtil.openSession();
		//Transaction tx = session.beginTransaction();

		List<User> list = null;
		try {
			
			Query query = session.createQuery("from User u where u.userName=:userName ");
			query.setString("userName", userName);
			
			list = (List<User>) query.list();// 获得列表
			//tx.commit();

		} catch (Exception ex) {
			//if (null != tx) {
			//	tx.rollback();
			//}
			ex.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
		return list;
	}
	
	public List<User> searchUser(String userName){
		Session session = HibernateUtil.openSession();

			Transaction tx = session.beginTransaction();

			List<User> list = null;
			
			try {
				Query query = session.createQuery("from User fs  where fs.userName like :userName");

				query.setString("userName","%"+userName+"%");
				
				list = (List<User>) query.list();

				System.out.println(list.size());
				
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
