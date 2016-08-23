package com.atguigu.crm.handlers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atguigu.crm.entity.Authority;
import com.atguigu.crm.entity.Role;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.service.RoleService;

@RequestMapping("/role")
@Controller
public class RoleHandler {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String update(Role role) {
		
		roleService.update(role);
		
		return "redirect:/role/list";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String toAssign(@PathVariable("id") Long id,Map<String,Object> map) {
		
		Role role = roleService.get(id);
		List<Authority> parentAuthorities = roleService.getAllParentAuthorities();
		
		map.put("role", role);
		map.put("parentAuthorities", parentAuthorities);
		return "role/edit";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id,RedirectAttributes attributes) {
		roleService.delete(id);
		attributes.addFlashAttribute("message", "删除成功！");
		return "redirect:/role/list";
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String save(Role role,RedirectAttributes attributes) {
		roleService.save(role);
		attributes.addFlashAttribute("message", "操作成功！");
		return "redirect:/role/list";
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String input(Map<String,Object> map) {
		Role role = new Role();
		map.put("role", role);
		return "role/input";
	}
	
	@RequestMapping(value="/list")
	public String list(@RequestParam(value="pageNoStr",required=false) String pageNoStr,Map<String, Object> map) {
		
		Page<Role> page = roleService.getPage(pageNoStr);
		map.put("page", page);
		return "role/list";
	}
}
