package com.atguigu.crm.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crm.entity.CustomerActivity;

public interface CustomerActivityMapper {

	int getTotalRecordNo(@Param("id") Long id);

	List<CustomerActivity> getPageList(@Param("id") Long id,@Param("firstIndex") int firstIndex,@Param("endIndex") int endIndex);

	void delete(@Param("id") Long id);

	CustomerActivity get(@Param("id") Long id);

	void update(CustomerActivity customerActivity);

	void save(CustomerActivity customerActivity);

}
