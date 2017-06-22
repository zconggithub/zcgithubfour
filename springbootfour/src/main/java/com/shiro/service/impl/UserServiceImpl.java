package com.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiro.entity.User;
import com.shiro.mapper.UserMapper;
import com.shiro.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findUserByUserName(String username) {
		    
		        return userMapper.findByUserName(username);  
		    
	}

}
  
    