package com.atguigu.crm.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crm.entity.Product;

public interface ProductMapper {

	long getTotalRecordNo();

	List<Product> getPageList(Map<String, Object> mybatisParams);

	void save(Product product);

	void delete(@Param("id") Long id);

	Product get(@Param("id") Long id);

	void update(Product product);

	List<Product> getAll();

	long getTotalRecordNoForCondition(Map<String, Object> mybatisParams);
	
}
