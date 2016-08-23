package com.atguigu.crm.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crm.entity.CustomerService;

public interface CustomerServiceMapper {

	void save(CustomerService customerService);

	int getTotalRecordNo(Map<String, Object> mybatisParams);

	List<CustomerService> getPageList(Map<String, Object> mybatisParams);

	void delete(@Param("id") Long id);

	void allot(CustomerService customerService);

	int getDealTotalRecordNo(Map<String, Object> mybatisParams);

	List<CustomerService> getDealPageList(Map<String, Object> mybatisParams);

	CustomerService get(@Param("id") Long id);

	void deal(CustomerService customerService);
	
	void feedBack(CustomerService customerService);

	int getFeedBackTotalRecordNo(Map<String, Object> mybatisParams);

	List<CustomerService> getFeedBackPageList(Map<String, Object> mybatisParams);

	int getArchiveTotalRecordNo(Map<String, Object> mybatisParams);

	List<CustomerService> getArchivePageList(Map<String, Object> mybatisParams);


}
