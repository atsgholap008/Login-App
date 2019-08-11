package com.mvc.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.app.dao.UserLoginDao;
import com.mvc.app.model.UserModel;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	@Autowired(required = true)
	private UserLoginDao userLoginDao;
	@Override
	public boolean checkLogin(UserModel user) {
		return userLoginDao.userLoginCheck(user.getUserName(),user.getPassword());
	}

}
