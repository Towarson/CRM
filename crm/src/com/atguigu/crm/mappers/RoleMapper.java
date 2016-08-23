package com.atguigu.crm.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.atguigu.crm.entity.Authority;
import com.atguigu.crm.entity.Role;

public interface RoleMapper {

	long getTotalRecordNo();

	List<Role> getPageList(@Param("firstIndex") int firstIndex, @Param("endIndex") int endIndex);

	void save(Role role);

	void delete(@Param("id") Long id);

	Role get(@Param("id") Long id);

	List<Authority> getAllParentAuthorities();

	void clearRole(Role role);

	void updateRoleAuthority(Role role);


}
