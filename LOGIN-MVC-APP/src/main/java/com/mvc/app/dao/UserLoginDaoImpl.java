package com.mvc.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.mvc.app.util.HibernateUtil;
@Repository
public class UserLoginDaoImpl implements UserLoginDao {

	@Override
	public boolean userLoginCheck(String userName, String password) {
		try(Session ses=HibernateUtil.getSf().openSession()){
			Query query=ses.createQuery("FROM UserMasterEntity WHERE userName='"+userName+"' AND password='"+password+"'");
			List user=query.list();
			if(user.size()>0) {
				return true;
			}
			else {
				return false;
			}
			
		}
		catch (Exception e) {
			return false;
		}
	}

}
