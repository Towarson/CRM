package com.atguigu.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crm.entity.SalesPlan;
import com.atguigu.crm.mappers.SalesPlanMapper;

@Service
public class SalesPlanService {
	
	@Autowired
	private SalesPlanMapper salesPlanMapper;
	
	@Transactional
	public void save(SalesPlan plan) {
		salesPlanMapper.save(plan);
	}
	@Transactional
	public void update(SalesPlan plan) {
		salesPlanMapper.update(plan);
	}
	@Transactional(readOnly=true)
	public SalesPlan get(Long id) {
		return salesPlanMapper.get(id);
	}
	@Transactional
	public void delete(Long id) {
		salesPlanMapper.delete(id);
	}
	@Transactional
	public void saveresult(SalesPlan salesPlan) {
		salesPlanMapper.saveresult(salesPlan);
	}
}
