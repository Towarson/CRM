package com.atguigu.crm.mappers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crm.entity.SalesChance;
import com.atguigu.crm.entity.User;

public interface SalesChanceMapper {
	
	List<SalesChance> getPageList(Map<String, Object> params);
	
	long getTotalRecordNo(@Param("createBy") User createBy);

	void save(SalesChance salesChance);

	void delete(@Param("id") Long id);

	SalesChance get(@Param("id") Long id);

	void update(SalesChance chance);

	void updateDispatch(@Param("id") Long id,@Param("designeeId") Long designeeId,@Param("designeeDate") Date designeeDate);

	long getTotalRecordNoForDesignee(@Param("designee") User designee);

	List<SalesChance> getPageListForDesignee(Map<String, Object> params);
	
	SalesChance getWithPlans(@Param("id") Long id);

	void updateStatus(@Param("status") String status,@Param("id") Long id);

	long getTotalRecordNoForCondition(Map<String, Object> mybatisParams);

	long getTotalRecordNoForDesigneeForCondition(
			Map<String, Object> mybatisParams);

}
