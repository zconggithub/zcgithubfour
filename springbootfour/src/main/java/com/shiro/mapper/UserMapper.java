package com.shiro.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.shiro.entity.User;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    public User findByUserName(String username);
}