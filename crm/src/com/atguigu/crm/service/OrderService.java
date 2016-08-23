package com.atguigu.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crm.entity.Order;
import com.atguigu.crm.mappers.OrderMapper;
import com.atguigu.crm.orm.Page;

@Service
public class OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	@Transactional(readOnly=true)
	public Page<Order> getPage(String pageNoStr, Long id) {
		
		//总记录数
		int totalRecordNo = orderMapper.getTotalRecordNo(id);
		
		//new page 对象
		Page<Order> page = new Page<Order>(totalRecordNo, pageNoStr);
		
		//firstIndex,endIndex
		int firstIndex = (page.getPageNo() - 1)*page.getPageSize() + 1;
		int endIndex = firstIndex + page.getPageSize();
		
		//pageList
		List<Order> pageList= orderMapper.getPageList(id,firstIndex,endIndex);
		page.setPageList(pageList);
		
		return page;
	}
	@Transactional(readOnly=true)
	public Order getWithOrderItem(Long id) {
		return orderMapper.getWithOrderItem(id);
	}
}
