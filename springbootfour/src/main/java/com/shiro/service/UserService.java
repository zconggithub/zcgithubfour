package com.shiro.service;

import com.shiro.entity.User;

public interface UserService {
	/**
	 * 
			* @methodDesc: 功能描述:(通过名字查询用户)
	        * @author: 周聪 
			* @param: @param username
			* @param: @return   
	        * @createTime:2017年6月21日 上午9:55:28
	        * @returnType:@param username
	        * @returnType:@return User  
			* @copyright:科瑞达科技
	 */
	public User findUserByUserName(String username);
}
  
    