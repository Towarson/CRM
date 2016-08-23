package com.atguigu.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.crm.entity.Authority;
import com.atguigu.crm.entity.Role;
import com.atguigu.crm.mappers.RoleMapper;
import com.atguigu.crm.orm.Page;

@Service
public class RoleService {
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Transactional(readOnly=true)
	public Page<Role> getPage(String pageNoStr) {
		
		//获取totalRecordNo
		long totalRecordNo = roleMapper.getTotalRecordNo();
		
		//new page对象
		Page<Role> page = new Page<>(totalRecordNo, pageNoStr);
		
		//获取firstIndex 和 endIndex
		int firstIndex = (page.getPageNo() - 1)*page.getPageSize() + 1;
		int endIndex = firstIndex + page.getPageSize();
		
		//获取pageList,并设置进去
		List<Role> pageList = roleMapper.getPageList(firstIndex,endIndex);
		page.setPageList(pageList);
		
		return page;
	}
	@Transactional
	public void save(Role role) {
		roleMapper.save(role);
	}
	
	@Transactional
	public void delete(Long id) {
		roleMapper.delete(id);
	}
	@Transactional(readOnly=true)
	public Role get(Long id) {
		return roleMapper.get(id);
	}
	@Transactional(readOnly=true)
	public List<Authority> getAllParentAuthorities() {
		return roleMapper.getAllParentAuthorities();
	}
	@Transactional
	public void update(Role role) {
		roleMapper.clearRole(role);
		roleMapper.updateRoleAuthority(role);
	}
}
