package com.shiro.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shiro.entity.User;

@Controller  
public class LoginController {
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/loginUser")
	public String loginUser(String username,String password,HttpSession session) {
		
		UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username, password);
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.login(usernamePasswordToken);//完成登录
			User user=(User) subject.getPrincipal();
			session.setAttribute("user", user);
			return "index";
		} catch (Exception e) {
			//e.printStackTrace();
			return "login";//返回登录页面
		}
		
	}
	
	@RequestMapping("/logOut")
	public String logOut(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		//session.removeAttribute("user");
		return "login";
	}
}
  
    