package com.mvc.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.app.dao.UserLoginDaoImpl;
import com.mvc.app.model.UserModel;
import com.mvc.app.service.UserLoginService;
import com.mvc.app.service.UserRegistrationService;
import com.mvc.app.util.AppConstants;

/**
 * This class for handling request related to User
 * 
 * @author Shiv
 *
 */
@Controller
public class UserController {

	@Autowired(required = true)
	private UserRegistrationService userRegService;
	
	@Autowired(required = true)
	private UserLoginService userLoginService;
	/**
	 * This method for show User Login form
	 * @return
	 */
	@RequestMapping(value = "/login.action",method = RequestMethod.GET )
	public String userLoginForm(Model model) {
		initializeFormData(model);
		return "login";
	}
	
	/**
	 * This method is to display registration form
	 * @param model
	 * @return
	 */
	@RequestMapping("/register.action")
	public String showRegisterForm(Model model) {
		initializeFormData(model);
		return "registerUser";
	}
	
	@RequestMapping(value = "/registerProcess.action", method = RequestMethod.POST)
	public String registerUserProcess(@ModelAttribute("user") UserModel user,Model model) {
		boolean flag=userRegService.registerUser(user);
		
		if(flag) {
			model.addAttribute(AppConstants.REG_SUCC,"Congratulations...!Registration Sucessfull..!");
		}
		else {
			model.addAttribute(AppConstants.REG_FAIL, "Sorry Username or Email-id  already registerd !");
		}
		initializeFormData(model);
		return "registerUser";
	}
	
	@RequestMapping(value = "loginProcess.action", method = RequestMethod.POST)
	public String userLoginProcess(@ModelAttribute("user") UserModel user,Model model) {
		boolean loginFlag=userLoginService.checkLogin(user);
		
		if(loginFlag) {
			return "dashboard";
		}
		else {
			model.addAttribute(AppConstants.LOGIN_FAIL,"Invalid Credentials..!try Again..!");
			initializeFormData(model);
			return "login";
		}
		
	}
	
	/**
	 * this method to initialize form data
	 * @param model
	 */
	public void initializeFormData(Model model) {
		model.addAttribute(AppConstants.USER_MODEL, new UserModel());
		List<String> genders=new ArrayList<String>();
		genders.add("Male");
		genders.add("Female");
		model.addAttribute(AppConstants.GENDERS, genders);
	}
}
