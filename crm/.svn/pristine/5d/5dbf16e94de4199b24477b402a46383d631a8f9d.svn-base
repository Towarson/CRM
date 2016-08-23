package com.atguigu.crm.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.crm.entity.Contact;
import com.atguigu.crm.entity.User;
import com.atguigu.crm.mappers.CustomerMapper;
import com.atguigu.crm.mappers.SalesChanceMapper;
import com.atguigu.crm.mappers.UserMapper;

public class ApplicationContextTest {
	
	private ApplicationContext ioc = null;
	private UserMapper userMapper = null;
	private SalesChanceMapper salesChanceMapper = null;
	private CustomerMapper customerMapper = null;
	
	{
		ioc= new ClassPathXmlApplicationContext("spring-context.xml");
		userMapper = ioc.getBean(UserMapper.class);
		salesChanceMapper = ioc.getBean(SalesChanceMapper.class);
		customerMapper = ioc.getBean(CustomerMapper.class);
		
	}
	@Test
	public void test01() {
		List<Contact> myManager = customerMapper.getMyManager(4L);
		System.out.println(myManager);
	}
	@Test
	public void testGetTotalRecordNo() {
		User createBy = new User();
		createBy.setId(21L);
		long recordNo = salesChanceMapper.getTotalRecordNo(createBy);
		System.out.println(recordNo);
	}
	
	@Test
	public void testGetByName() {
		User user = userMapper.getUserByName("bcde");
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		System.out.println(user.getRole().getName());
	}
}
