package com.atguigu.crm.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crm.entity.Dict;


public interface DictsMapper {

	int getTotalRecordNo(Map<String, Object> mybatisParams);

	List<Dict> getPageList(Map<String, Object> mybatisParams);

	void save(Dict dict);

	void update(Dict dict);

	void delete(@Param("id") Long id);

	Dict get(@Param("id") Long id);
	
	List<String> getAllLevel();

	List<String> getAllRegion();

	List<String> getAllSatify();

	List<String> getAllCredit();
	
	List<Dict> getAllServiceType();

}
