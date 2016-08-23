package com.atguigu.crm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crm.entity.CustomerService;
import com.atguigu.crm.entity.User;
import com.atguigu.crm.mappers.CustomerServiceMapper;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.orm.PropertyFilter;

@Service
public class CustomerServiceService {
	
	@Autowired
	private CustomerServiceMapper customerServiceMapper;
	
	@Transactional
	public void save(CustomerService customerService) {
		customerServiceMapper.save(customerService);
	}
	@Transactional(readOnly=true)
	public Page<CustomerService> getPage(String pageNoStr,
			Map<String, Object> parameters) {
		
		//把map类型先转换为List<PropertyFilter>
		List<PropertyFilter> filters = PropertyFilter.parseRequestParamsToPropertyFilters(parameters);
		
		//把List<PropertyFilter>转化为mybatis可用的map
		Map<String, Object> mybatisParams = PropertyFilter.parsePropertyFiltersToMybatisParams(filters);
		
		//获取带条件查询的总记录数
		int totalRecordNo = customerServiceMapper.getTotalRecordNo(mybatisParams);
		
		//创建page对象,构造器中计算出totalPageNo并纠正pageNo
		Page<CustomerService> page = new Page<>(totalRecordNo, pageNoStr);
		
		//获取firstIndex 和 endIndex
		int firstIndex = (page.getPageNo()-1)*page.getPageSize()+1;
		int endIndex = firstIndex + page.getPageSize();
		mybatisParams.put("firstIndex", firstIndex);
		mybatisParams.put("endIndex", endIndex);
		
		//获取pageList,并设置到page类中
		List<CustomerService> pageList = customerServiceMapper.getPageList(mybatisParams);
		page.setPageList(pageList);
		return page;
	}
	@Transactional(readOnly=true)
	public Page<CustomerService> getDealPage(String pageNoStr,
			Map<String, Object> parameters,User allotTo) {
		
		parameters.put("EQO_allotTo", allotTo);
		
		//把map类型先转换为List<PropertyFilter>
		List<PropertyFilter> filters = PropertyFilter.parseRequestParamsToPropertyFilters(parameters);
		
		//把List<PropertyFilter>转化为mybatis可用的map
		Map<String, Object> mybatisParams = PropertyFilter.parsePropertyFiltersToMybatisParams(filters);
		
		//获取带条件查询的总记录数
		int totalRecordNo = customerServiceMapper.getDealTotalRecordNo(mybatisParams);
		
		//创建page对象,构造器中计算出totalPageNo并纠正pageNo
		Page<CustomerService> page = new Page<>(totalRecordNo, pageNoStr);
		
		//获取firstIndex 和 endIndex
		int firstIndex = (page.getPageNo()-1)*page.getPageSize()+1;
		int endIndex = firstIndex + page.getPageSize();
		mybatisParams.put("firstIndex", firstIndex);
		mybatisParams.put("endIndex", endIndex);
		
		//获取pageList,并设置到page类中
		List<CustomerService> pageList = customerServiceMapper.getDealPageList(mybatisParams);
		page.setPageList(pageList);
		return page;
	}
	
	@Transactional(readOnly=true)
	public Page<CustomerService> getFeedBackPage(String pageNoStr,
			Map<String, Object> parameters) {
		//把map类型先转换为List<PropertyFilter>
		List<PropertyFilter> filters = PropertyFilter.parseRequestParamsToPropertyFilters(parameters);
		
		//把List<PropertyFilter>转化为mybatis可用的map
		Map<String, Object> mybatisParams = PropertyFilter.parsePropertyFiltersToMybatisParams(filters);
		
		//获取带条件查询的总记录数
		int totalRecordNo = customerServiceMapper.getFeedBackTotalRecordNo(mybatisParams);
		
		//创建page对象,构造器中计算出totalPageNo并纠正pageNo
		Page<CustomerService> page = new Page<>(totalRecordNo, pageNoStr);
		
		//获取firstIndex 和 endIndex
		int firstIndex = (page.getPageNo()-1)*page.getPageSize()+1;
		int endIndex = firstIndex + page.getPageSize();
		mybatisParams.put("firstIndex", firstIndex);
		mybatisParams.put("endIndex", endIndex);
		
		//获取pageList,并设置到page类中
		List<CustomerService> pageList = customerServiceMapper.getFeedBackPageList(mybatisParams);
		page.setPageList(pageList);
		return page;
	}
	@Transactional(readOnly=true)
	public Page<CustomerService> getArchivePage(String pageNoStr,
			Map<String, Object> parameters) {
		//把map类型先转换为List<PropertyFilter>
		List<PropertyFilter> filters = PropertyFilter.parseRequestParamsToPropertyFilters(parameters);
		
		//把List<PropertyFilter>转化为mybatis可用的map
		Map<String, Object> mybatisParams = PropertyFilter.parsePropertyFiltersToMybatisParams(filters);
		
		//获取带条件查询的总记录数
		int totalRecordNo = customerServiceMapper.getArchiveTotalRecordNo(mybatisParams);
		
		//创建page对象,构造器中计算出totalPageNo并纠正pageNo
		Page<CustomerService> page = new Page<>(totalRecordNo, pageNoStr);
		
		//获取firstIndex 和 endIndex
		int firstIndex = (page.getPageNo()-1)*page.getPageSize()+1;
		int endIndex = firstIndex + page.getPageSize();
		mybatisParams.put("firstIndex", firstIndex);
		mybatisParams.put("endIndex", endIndex);
		
		//获取pageList,并设置到page类中
		List<CustomerService> pageList = customerServiceMapper.getArchivePageList(mybatisParams);
		page.setPageList(pageList);
		return page;
	}
	@Transactional(readOnly=true)
	public void allot(Long id, Long allotId) {
		User allotTo = new User();
		allotTo.setId(allotId);
		CustomerService customerService = new CustomerService();
		customerService.setId(id);
		customerService.setAllotDate(new Date());
		customerService.setAllotTo(allotTo);
		customerService.setServiceState("已分配");
		customerServiceMapper.allot(customerService);
	}
	@Transactional
	public void delete(Long id) {
		customerServiceMapper.delete(id);
	}
	@Transactional(readOnly=true)
	public CustomerService get(Long id) {
		return customerServiceMapper.get(id);
	}
	@Transactional
	public void deal(CustomerService customerService) {
		customerServiceMapper.deal(customerService);
	}
	@Transactional
	public void feedBack(CustomerService customerService) {
		customerServiceMapper.feedBack(customerService);
	}
	
}
