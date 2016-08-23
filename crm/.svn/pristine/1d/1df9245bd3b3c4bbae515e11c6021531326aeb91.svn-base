package com.atguigu.crm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crm.entity.Dict;
import com.atguigu.crm.mappers.DictsMapper;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.orm.PropertyFilter;

@Service
public class DictsService {
	
	@Autowired
	private DictsMapper dictsMapper;
	
	public Page<Dict> getPage(String pageNoStr,
			Map<String, Object> parameters) {
		
		//把map类型先转换为List<PropertyFilter>
		List<PropertyFilter> filters = PropertyFilter.parseRequestParamsToPropertyFilters(parameters);
		
		//把List<PropertyFilter>转化为mybatis可用的map
		Map<String, Object> mybatisParams = PropertyFilter.parsePropertyFiltersToMybatisParams(filters);
		
		//获取带条件查询的总记录数
		int totalRecordNo = dictsMapper.getTotalRecordNo(mybatisParams);
		
		//创建page对象,构造器中计算出totalPageNo并纠正pageNo
		Page<Dict> page = new Page<Dict>(totalRecordNo, pageNoStr);
		
		//获取firstIndex 和 endIndex
		int firstIndex = (page.getPageNo()-1)*page.getPageSize()+1;
		int endIndex = firstIndex + page.getPageSize();
		mybatisParams.put("firstIndex", firstIndex);
		mybatisParams.put("endIndex", endIndex);
		
		//获取pageList,并设置到page类中
		List<Dict> pageList = dictsMapper.getPageList(mybatisParams);
		page.setPageList(pageList);
		
		return page;
	}
	@Transactional
	public void save(Dict dict) {
		dictsMapper.save(dict);
	}
	@Transactional
	public void update(Dict dict) {
		dictsMapper.update(dict);
	}
	@Transactional
	public void delete(Long id) {
		dictsMapper.delete(id);
	}
	@Transactional(readOnly=true)
	public Dict get(Long id) {
		return dictsMapper.get(id);
	}
	@Transactional(readOnly=true)
	public List<String> getAllLevel() {
		return dictsMapper.getAllLevel();
	}
	@Transactional(readOnly=true)
	public List<String> getAllRegion() {
		return dictsMapper.getAllRegion();
	}

	@Transactional(readOnly=true)
	public List<String> getAllSatify() {
		return dictsMapper.getAllSatify();
	}
	@Transactional(readOnly=true)
	public List<String> getAllCredit() {
		return dictsMapper.getAllCredit();
	}
	@Transactional(readOnly=true)
	public List<Dict> getAllServiceType() {
		return dictsMapper.getAllServiceType();
	}
}
