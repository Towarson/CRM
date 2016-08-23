package com.atguigu.crm.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crm.entity.Storage;

public interface StorageMapper {

	long getTotalRecordNo();

	List<Storage> getPageList(Map<String, Object> mybatisParams);

	void save(Storage storage);

	void delete(@Param("id") Long id);

	Storage get(@Param("id") Long id);

	Long getCurrentCount(Storage storage);

	void updateCount(@Param("count") Long count);

	long getTotalRecordNoForCondition(Map<String, Object> mybatisParams);


	
}
