package com.atguigu.crm.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atguigu.crm.entity.Contact;
import com.atguigu.crm.entity.Customer;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.service.ContactService;
import com.atguigu.crm.service.CustomerServices;

@RequestMapping("/contact")
@Controller
public class ContactHandler {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private CustomerServices customerServices;
	
	@RequestMapping(value="/{custId}",method=RequestMethod.POST)
	public String save(@PathVariable("custId") Long custId,Contact contact,RedirectAttributes attributes) {
		Customer customer = customerServices.get(custId);
		contact.setCustomer(customer);
		contactService.save(contact);
		attributes.addFlashAttribute("message", "保存成功！");
		return "redirect:/contact/list/"+custId;
	}
	
	@RequestMapping(value="/{custId}",method=RequestMethod.GET)
	public String input(@PathVariable("custId") Long custId,Map<String,Object> map) {
		Contact contact = new Contact();
		map.put("contact", contact);
		return "contact/input";
	}
	
	@RequestMapping(value="/{custId}",method=RequestMethod.PUT)
	public String update(@PathVariable("custId") Long custId,Contact contact,RedirectAttributes attributes) {
		contactService.update(contact);
		attributes.addFlashAttribute("message", "修改成功！");
		return "redirect:/contact/list/"+custId;
	}
	
	@RequestMapping(value="/{id}/{custId}",method=RequestMethod.GET)
	public String input(@PathVariable("id") Long id,@PathVariable("custId") Long custId,Map<String,Object> map) {
		Contact contact = contactService.get(id);
		map.put("contact", contact);
		map.put("custId", custId);
		return "contact/input";
	}
	
	@RequestMapping(value="/{id}/{custId}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id,@PathVariable("custId") Long custId) {
		contactService.delete(id);
		return "redirect:/contact/list/"+custId;
	}
	
	@ResponseBody
	@RequestMapping(value="/check/{id}",method=RequestMethod.POST)
	public String check(@PathVariable("id") Long id) {
		int count = contactService.getTotalRecordNo(id);
		if(count>1) {
			return "2";
		}else {
			return "1";
		}
	}
	
	@RequestMapping(value="/list/{id}")
	public String list(@PathVariable("id") Long id,@RequestParam(value="pageNoStr",required=false) String pageNoStr,
						Map<String , Object> map) {
		Customer customer = customerServices.get(id);
		Page<Contact> page = contactService.getPage(pageNoStr,id);
		map.put("page", page);
		map.put("customer", customer);
		return "contact/list";
	}
}
