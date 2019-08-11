package com.mvc.app.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.app.dao.UserRegistationDao;
import com.mvc.app.entity.UserMasterEntity;
import com.mvc.app.model.UserModel;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired(required = true)
	private UserRegistationDao userRegDao;
	/**
	 * This method used to register user
	 */
	public boolean registerUser(UserModel model) {
		//create entity obj
		UserMasterEntity entity=new UserMasterEntity();
		//copying data model to entity
		BeanUtils.copyProperties(model, entity);
		//call Dao method to save record
		return userRegDao.registerUserEntity(entity);
	}

}
