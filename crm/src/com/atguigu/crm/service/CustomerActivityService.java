package com.atguigu.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crm.entity.CustomerActivity;
import com.atguigu.crm.mappers.CustomerActivityMapper;
import com.atguigu.crm.orm.Page;

@Service
public class CustomerActivityService {
	
	@Autowired
	private CustomerActivityMapper customerActivityMapper;
	
	@Transactional(readOnly=true)
	public Page<CustomerActivity> getPage(String pageNoStr, Long id) {
		
		//总记录数
		int totalRecordNo = customerActivityMapper.getTotalRecordNo(id);
		
		//new page对象
		Page<CustomerActivity> page = new Page<CustomerActivity>(totalRecordNo, pageNoStr);
		
		//firstIndex,endIndex
		int firstIndex = (page.getPageNo()-1)*page.getPageSize()+1;
		int endIndex = firstIndex + page.getPageSize();
		
		List<CustomerActivity> pageList = customerActivityMapper.getPageList(id,firstIndex,endIndex);
		page.setPageList(pageList);
		
		return page;
	}
	@Transactional
	public void delete(Long id) {
		customerActivityMapper.delete(id);
	}
	@Transactional(readOnly=true)
	public CustomerActivity get(Long id) {
		return customerActivityMapper.get(id);
	}
	@Transactional
	public void update(CustomerActivity customerActivity) {
		customerActivityMapper.update(customerActivity);
	}
	@Transactional
	public void save(CustomerActivity customerActivity) {
		customerActivityMapper.save(customerActivity);
	}
}
