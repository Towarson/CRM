package com.atguigu.crm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crm.entity.Contact;
import com.atguigu.crm.entity.Customer;
import com.atguigu.crm.entity.SalesChance;
import com.atguigu.crm.entity.User;
import com.atguigu.crm.mappers.ContactMapper;
import com.atguigu.crm.mappers.CustomerMapper;
import com.atguigu.crm.mappers.SalesChanceMapper;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.orm.PropertyFilter;

@Service
public class SalesChanceService {
	
	@Autowired
	private SalesChanceMapper salesChanceMapper;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private ContactMapper contactMapper;
	
/*	@Transactional(readOnly=true)
	public Page<SalesChance> getPage(String pageNoStr,User createBy) {
		
		long totalRecordNo = salesChanceMapper.getTotalRecordNo(createBy);
		
		Page<SalesChance> page = new Page<>(totalRecordNo, pageNoStr);
		
		int firstIndex = (page.getPageNo() - 1)*page.getPageSize() + 1;
		int endIndex = firstIndex + page.getPageSize();
		
		Map<String, Object> params = new HashMap<>();
		params.put("createBy", createBy);
		params.put("firstIndex", firstIndex);
		params.put("endIndex", endIndex);
		
		List<SalesChance> pageList = salesChanceMapper.getPageList(params);
		page.setPageList(pageList);
		
		return page;
		
	}*/
	
	@Transactional
	public void save(SalesChance salesChance) {
		salesChanceMapper.save(salesChance);
	}
	
	@Transactional
	public void delete(Long id) {
		salesChanceMapper.delete(id);
		
	}
	@Transactional(readOnly=true)
	public SalesChance get(Long id) {
		return salesChanceMapper.get(id);
	}
	@Transactional
	public void update(SalesChance chance) {
		salesChanceMapper.update(chance);
	}
	
	@Transactional
	public void updateDispatch(Long id,Long designeeId,Date designeeDate) {
		salesChanceMapper.updateDispatch(id, designeeId, designeeDate);
	}
	@Transactional(readOnly=true)
	public Page<SalesChance> getPageForCondition(String pageNoStr, User createBy,
			Map<String, Object> parameters) {
		//1. mybatis 如何来传递参数
		//1.1 传若干个单个参数, 使用 @Param 来进行映射
		//1.2 传递一个 Map. 
		//1.3 传递一个 bean
		//1.4 再没有其他的传递方式. 例如: 传一个 Map 和 一个单个的参数. 
		//2. 需要把 createBy 这个请求参数, 整合到 Map 中
		parameters.put("EQO_createBy", createBy);
		//3. 实际上若直接调用 Mapper 的方法还有些问题:
		//3.1 若是 LIKE 的比较方式, 则值的前后应该添加 %
		//3.2 若目标属性的类型是一个 Date 类型, 而前端传入的是一个字符串(例如: 1990-11-11), 还需要把字符串转为 Date 类型. 
		//birth:1990-11-11
		//4. 实际上查询条件的请求参数应该包含以下信息:
		//4.1 参数名
		//4.2 参数值
		//4.3 参数的类型
		//4.4 比较的方式. 
		//4.5 把上述信息可以封装到一个类中. 
		List<PropertyFilter> filters = PropertyFilter.parseRequestParamsToPropertyFilters(parameters);
		//5. 把 PropertyFilter 的集合转为 mybatis 可用的 Map. 
		//5.1 Map 的 key 是实际的属性名. 而不是参数名. 例如: contact, custName 而不是 LIKES_contact 或 LIKES_custName
		//5.2 若比较方式为 LIKE, 则值前后添加了 % 
		//5.3 若目标属性的类型为 Date, 则值被转为 Date 类型. 
		Map<String, Object> mybatisParams = PropertyFilter.parsePropertyFiltersToMybatisParams(filters);
		long totalRecordNo = salesChanceMapper.getTotalRecordNoForCondition(mybatisParams);
		
		Page<SalesChance> page = new Page<>(totalRecordNo, pageNoStr);
		
		int firstIndex = (page.getPageNo() - 1)*page.getPageSize() + 1;
		int endIndex = firstIndex + page.getPageSize();
		mybatisParams.put("firstIndex", firstIndex);
		mybatisParams.put("endIndex", endIndex);
		
		List<SalesChance> pageList = salesChanceMapper.getPageList(mybatisParams);
		page.setPageList(pageList);
		
		return page;
	}
	@Transactional(readOnly=true)
	public Page<SalesChance> getPageForDesignee(String pageNoStr, User designee, Map<String, Object> parameters) {
		
		//需要把 designee 这个请求参数, 整合到 Map 中 EQ代表=，O是object
		parameters.put("EQO_designee", designee);
		
		//把map类型先转换为List<PropertyFilter>
		List<PropertyFilter> filters = PropertyFilter.parseRequestParamsToPropertyFilters(parameters);
		
/*		再将List<PropertyFilter>转化为mybatis可用的map，Map 的 key 是实际的属性名. 而不是参数名. 例如: contact,
		 若比较方式为 LIKE, 则值前后添加了 %  若目标属性的类型为 Date, 则值被转为 Date 类型. */
		Map<String, Object> mybatisParams = PropertyFilter.parsePropertyFiltersToMybatisParams(filters);
		
		//获取带条件查询的总记录数
		long totalRecordNo = salesChanceMapper.getTotalRecordNoForDesigneeForCondition(mybatisParams);
		
		Page<SalesChance> page = new Page<>(totalRecordNo, pageNoStr);
		
		int firstIndex = (page.getPageNo() - 1)*page.getPageSize() + 1;
		int endIndex = firstIndex + page.getPageSize();
		mybatisParams.put("firstIndex", firstIndex);
		mybatisParams.put("endIndex", endIndex);
		
		List<SalesChance> pageList = salesChanceMapper.getPageListForDesignee(mybatisParams);
		page.setPageList(pageList);
		return page;
	}
	@Transactional(readOnly=true)
	public SalesChance getWithPlan(Long id) {
		return salesChanceMapper.getWithPlans(id);
	}
	@Transactional
	public void saveCustomer(Customer customer) {
		customerMapper.saveCustomer(customer);
	}
	@Transactional
	public void saveContact(Contact contact) {
		contactMapper.saveContact(contact);
	}
	@Transactional
	public void updateStatus(String status, Long id) {
		salesChanceMapper.updateStatus(status,id);
	}
	
}
