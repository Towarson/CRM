package com.atguigu.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crm.entity.Contact;
import com.atguigu.crm.mappers.ContactMapper;
import com.atguigu.crm.orm.Page;

@Service
public class ContactService {
	
	@Autowired
	private ContactMapper contactMapper;
	
	@Transactional
	public Page<Contact> getPage(String pageNoStr,Long id) {
		
		//1.获取totalPageNo
		int totalRecordNo = contactMapper.getTotalRecordNo(id);
		
		//2.new 对象
		Page<Contact> page = new Page<Contact>(totalRecordNo, pageNoStr);
		
		//3.获取firstIndex 和 endIndex
		int firstIndex = (page.getPageNo() - 1)*page.getPageSize() + 1;
		int endIndex = firstIndex + page.getPageSize();
		
		//4.获取pageList，并设置到page对象中
		List<Contact> pageList = contactMapper.getPageList(id,firstIndex,endIndex);
		page.setPageList(pageList);
		
		return page;
	}
	@Transactional(readOnly=true)
	public int getTotalRecordNo(Long id) {
		return contactMapper.getTotalRecordNo(id);
	}
	@Transactional
	public void delete(Long id) {
		contactMapper.delete(id);
	}
	@Transactional(readOnly=true)
	public Contact get(Long id) {
		return contactMapper.get(id);
	}
	@Transactional
	public void update(Contact contact) {
		contactMapper.update(contact);
	}
	@Transactional
	public void save(Contact contact) {
		contactMapper.save(contact);
	}
}
