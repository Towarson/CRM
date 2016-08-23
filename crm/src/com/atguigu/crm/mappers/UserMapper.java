package com.atguigu.crm.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crm.entity.User;

public interface UserMapper {
	
	User getUserByName(@Param("userName") String userName);

	long getTotalRecordNo();

	List<User> getPageList(Map<String, Object> mybatisParams);

	List<User> getAllUser();

	long getTotalRecordNoForCondition(Map<String, Object> mybatisParams);

	void save(User user);

	void delete(@Param("id") Long id);

	User get(@Param("id") Long id);

	void update(User user);
}
