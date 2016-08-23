package com.atguigu.crm.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crm.entity.Contact;
import com.atguigu.crm.entity.Customer;

public interface CustomerMapper {

	void saveCustomer(Customer customer);

	long getTotalRecordNo(Map<String, Object> mybatisParams);

	List<Customer> getPageList(Map<String, Object> mybatisParams);

	List<String> getAllState();

	List<Contact> getMyManager(@Param("id") Long id);

	Customer getWithDictsAndContacts(@Param("id") Long id);

	void update(Customer customer);

	Customer get(@Param("id") Long id);

	void delete(@Param("id") Long id);

	List<Customer> getCustName();
	
}
