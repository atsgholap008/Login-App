package com.mvc.app.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.mvc.app.entity.UserMasterEntity;
import com.mvc.app.util.HibernateUtil;

@Repository
public class UserRegistationDaoImpl implements UserRegistationDao {

	/**
	 * This 
	 */
	public boolean registerUserEntity(UserMasterEntity entity) {
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSf().openSession()){
			tx=ses.beginTransaction();
			Long id=(Long)ses.save(entity);
			tx.commit();
			if(id>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			return false;
		}
		
	}

}
