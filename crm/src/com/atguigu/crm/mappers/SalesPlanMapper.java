package com.atguigu.crm.mappers;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crm.entity.SalesPlan;

public interface SalesPlanMapper {

	void save(SalesPlan plan);

	void update(SalesPlan plan);

	SalesPlan get(@Param("id") Long id);

	void delete(@Param("id") Long id);

	void saveresult(SalesPlan salesPlan);
	
}
