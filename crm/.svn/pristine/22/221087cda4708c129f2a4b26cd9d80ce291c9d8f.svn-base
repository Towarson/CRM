package com.atguigu.crm.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crm.entity.Order;

public interface OrderMapper {

	int getTotalRecordNo(@Param("id") Long id);

	List<Order> getPageList(@Param("id") Long id,@Param("firstIndex") int firstIndex,@Param("endIndex") int endIndex);

	Order getWithOrderItem(@Param("id") Long id);

}
