package com.atguigu.crm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crm.entity.Product;
import com.atguigu.crm.mappers.ProductMapper;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.orm.PropertyFilter;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Transactional(readOnly=true)
	public Page<Product> getPage(String pageNoStr, Map<String, Object> parameters) {
		
		//把map类型先转换为List<PropertyFilter>
		List<PropertyFilter> filters = PropertyFilter.parseRequestParamsToPropertyFilters(parameters);
		
		//把List<PropertyFilter>转化为mybatis可用的map
		Map<String, Object> mybatisParams = PropertyFilter.parsePropertyFiltersToMybatisParams(filters);
		
		//获取带条件查询的总记录数
		long totalRecordNo = productMapper.getTotalRecordNoForCondition(mybatisParams);
		
		//创建page对象,构造器中计算出totalPageNo并纠正pageNo
		Page<Product> page = new Page<>(totalRecordNo, pageNoStr);
		
		//获取firstIndex 和 endIndex
		int firstIndex = (page.getPageNo() - 1)*page.getPageSize() + 1;
		int endIndex = firstIndex + page.getPageSize();
		mybatisParams.put("firstIndex", firstIndex);
		mybatisParams.put("endIndex", endIndex);
		//获取pageList,并设置到page类中
		List<Product> pageList = productMapper.getPageList(mybatisParams);
		page.setPageList(pageList);
		
		return page;
	}
	
	@Transactional
	public void save(Product product) {
		productMapper.save(product);
		
	}
	@Transactional
	public void delete(Long id) {
		productMapper.delete(id);
	}
	@Transactional(readOnly=true)
	public Product get(Long id) {
		return productMapper.get(id);
	}
	@Transactional
	public void update(Product product) {
		productMapper.update(product);
	}
	
	@Transactional(readOnly=true)
	public List<Product> getAll() {
		return productMapper.getAll();
	}
}
