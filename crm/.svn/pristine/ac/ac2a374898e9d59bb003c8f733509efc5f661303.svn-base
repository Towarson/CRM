package com.atguigu.crm.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.atguigu.crm.entity.Storage;
import com.atguigu.crm.mappers.StorageMapper;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.orm.PropertyFilter;

@Service
public class StorageService {
	
	@Autowired
	private StorageMapper storageMapper;
	
	@Transactional(readOnly=true)
	public Page<Storage> getPage(String pageNoStr, Map<String, Object> parameters) {
		
		
		//把map类型先转换为List<PropertyFilter>
		List<PropertyFilter> filters = PropertyFilter.parseRequestParamsToPropertyFilters(parameters);
		
		//把List<PropertyFilter>转化为mybatis可用的map
		Map<String, Object> mybatisParams = PropertyFilter.parsePropertyFiltersToMybatisParams(filters);
		
		//获取带条件查询的总记录数
		long totalRecordNo = storageMapper.getTotalRecordNoForCondition(mybatisParams);
		
		//2.创建page对象,构造器中计算出totalPageNo并纠正pageNo
		Page<Storage> page = new Page<Storage>(totalRecordNo, pageNoStr);
		
		//3.获取firstIndex 和 endIndex
		int firstIndex = (page.getPageNo() - 1)*page.getPageSize() + 1;
		int endIndex = firstIndex + page.getPageSize();
		mybatisParams.put("firstIndex", firstIndex);
		mybatisParams.put("endIndex", endIndex);
		//4.获取pageList,并设置到page类中
		List<Storage> pageList = storageMapper.getPageList(mybatisParams);
		
		page.setPageList(pageList);
		
		return page;
	}
	
	@Transactional(readOnly=true)
	public void save(Storage storage) {
		storageMapper.save(storage);
	}
	@Transactional
	public void delete(Long id) {
		storageMapper.delete(id);
	}
	@Transactional(readOnly=true)
	public Storage get(Long id) {
		return storageMapper.get(id);
	}
	@Transactional
	public void updateCount(Storage storage, Long incrementCount) {
		Long currentCount = storageMapper.getCurrentCount(storage);
		Long nowCount = currentCount + incrementCount;
		storageMapper.updateCount(nowCount);
	}

}
