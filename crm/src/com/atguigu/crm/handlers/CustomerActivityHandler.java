package com.atguigu.crm.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atguigu.crm.entity.Customer;
import com.atguigu.crm.entity.CustomerActivity;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.service.CustomerActivityService;
import com.atguigu.crm.service.CustomerServices;

@RequestMapping("/activity")
@Controller
public class CustomerActivityHandler {
	
	@Autowired
	private CustomerActivityService customerActivityService;
	
	@Autowired
	private CustomerServices customerServices;
	
	@RequestMapping(value="/{custId}",method=RequestMethod.POST)
	public String save(@PathVariable("custId") Long custId,CustomerActivity customerActivity,
			RedirectAttributes attributes) {
		Customer customer = customerServices.get(custId);
		customerActivity.setCustomer(customer);
		customerActivityService.save(customerActivity);
		attributes.addFlashAttribute("message", "保存成功！");
		return "redirect:/activity/list/"+custId;
	}
	@RequestMapping(value="/{custId}",method=RequestMethod.GET)
	public String input(@PathVariable("custId") Long custId,Map<String,Object> map) {
		CustomerActivity customerActivity = new CustomerActivity();
		map.put("customerActivity", customerActivity);
		return "customerActivity/input";
	}
	
	@RequestMapping(value="/{custId}",method=RequestMethod.PUT)
	public String update(@PathVariable("custId") Long custId,CustomerActivity customerActivity,RedirectAttributes attributes) {
		customerActivityService.update(customerActivity);
		attributes.addFlashAttribute("message", "修改成功！");
		return "redirect:/activity/list/"+custId;
	}
	
	@RequestMapping(value="/{id}/{custId}",method=RequestMethod.GET)
	public String input(@PathVariable("id") Long id,@PathVariable("custId") Long custId,Map<String,Object> map) {
		CustomerActivity customerActivity = customerActivityService.get(id);
		map.put("customerActivity", customerActivity);
		map.put("custId", custId);
		return "customerActivity/input";
	}
	
	@RequestMapping(value="/{id}/{custId}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id,@PathVariable("custId") Long custId,
						RedirectAttributes attributes) {
		customerActivityService.delete(id);
		attributes.addFlashAttribute("message", "删除成功！");
		return "redirect:/activity/list/"+custId;
	}
	
	@RequestMapping(value="/list/{id}")
	public String list(@PathVariable("id") Long id,@RequestParam(value="pageNoStr",required=false) String pageNoStr,
						Map<String, Object> map) {
		
		Customer customer = customerServices.get(id);
		Page<CustomerActivity> page = customerActivityService.getPage(pageNoStr,id);
		
		map.put("customer", customer);
		map.put("page", page);
		
		return "customerActivity/list";
	}
}
