package com.atguigu.crm.handlers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.atguigu.crm.entity.Customer;
import com.atguigu.crm.entity.CustomerService;
import com.atguigu.crm.entity.Dict;
import com.atguigu.crm.entity.User;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.service.CustomerServiceService;
import com.atguigu.crm.service.CustomerServices;
import com.atguigu.crm.service.DictsService;
import com.atguigu.crm.service.UserService;
import com.atguigu.crm.utils.CRMUtils;

@RequestMapping("/service")
@Controller
public class CustomerServiceHandler {
	
	@Autowired
	private CustomerServiceService service;
	
	@Autowired
	private DictsService dictsService; 
	
	@Autowired
	private CustomerServices custService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/archive/{id}")
	public String archive(@PathVariable("id") Long id,Map<String,Object> map) {
		
		CustomerService customerService = service.get(id);
		
		map.put("customerService", customerService);
		
		return "customerService/archive";
	}
	
	@RequestMapping(value="/feedback",method=RequestMethod.POST)
	public String doFeedBack(@RequestParam("id") Long id,
			@RequestParam("dealResult") String dealResult,
			@RequestParam("satisfy") String satisfy,
			RedirectAttributes attributes) {
		CustomerService customerService = service.get(id);
		customerService.setSatisfy(satisfy);
		customerService.setDealResult(dealResult);
		customerService.setServiceState("已归档");
		service.feedBack(customerService);
		attributes.addFlashAttribute("message","保存成功!");
		
		return "redirect:/service/feedback/list";
	}
	
	@RequestMapping("/feedback/{id}")
	public String toFeedBack(@PathVariable("id") Long id,Map<String,Object> map,HttpSession session) {
		
		CustomerService customerService = service.get(id);
		
		User user = (User)session.getAttribute("user");
		List<String> satifyList = dictsService.getAllSatify();
		
		map.put("customerService", customerService);
		map.put("user", user);
		map.put("satifyList", satifyList);
		
		return "customerService/back";
	}
	@RequestMapping(value="/deal",method=RequestMethod.POST)
	public String doDeal(@RequestParam("id") Long id,
						@RequestParam("serviceDeal") String serviceDeal,
						RedirectAttributes attributes) {
		CustomerService customerService = service.get(id);
		customerService.setServiceDeal(serviceDeal);
		customerService.setDealDate(new Date());
		customerService.setServiceState("已处理");
		service.deal(customerService);
		attributes.addFlashAttribute("message","保存成功!");
		
		return "redirect:/service/deal/list";
	}
	
	@RequestMapping(value="/deal/{id}",method=RequestMethod.GET)
	public String toDeal(@PathVariable("id") Long id,Map<String,Object> map,HttpSession session) {
		CustomerService customerService = service.get(id);
		customerService.setDealDate(new Date());
		
		User user = (User)session.getAttribute("user");
		
		map.put("customerService", customerService);
		map.put("user", user);
		
		return "customerService/deal";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/service/list";
	}
	
	@ResponseBody
	@RequestMapping("/allot")
	public String allot(Long id,Long allotId) {
		try {
			service.allot(id,allotId);
			return "1";
		} catch (Exception e) {
			return "0";
		}
	}
	@RequestMapping("/save")
	public String save(CustomerService customerService,RedirectAttributes attributes) {
		
		service.save(customerService);
		attributes.addFlashAttribute("message", "保存成功!");
		
		return "redirect:/service/list";
	}
	
	@RequestMapping("/create")
	public String input(HttpSession session,Map<String, Object> map) {
		
		User createdby = (User)session.getAttribute("user");
		
		CustomerService customerService = new CustomerService();
		customerService.setCreateDate(new Date());
		customerService.setCreatedby(createdby);
		
		List<Dict> serviceTypeList = dictsService.getAllServiceType();
		List<Customer> custList = custService.getCustName();
		
		map.put("createdby", createdby);
		map.put("serviceTypeList", serviceTypeList);
		map.put("custList", custList);
		map.put("customerService", customerService);
		
		return "customerService/input";
	}
	
	@RequestMapping("/list")
	public String list(@RequestParam(value="pageNoStr",required=false) String pageNoStr,
			  			HttpServletRequest request,
			  			Map<String, Object> map) {
		
		//从请求request对象中获取参数的map集合
		Map<String, Object> parameters = WebUtils.getParametersStartingWith(request, "search_");
		
		//将map转换为字符串  queryString
		String queryString = CRMUtils.encodeParameterMapToQueryString(parameters, "search_");
		
		//将queryString放置在map域中,用page标签的属性queryString来接收
		map.put("queryString",queryString);
		
		Page<CustomerService> page = service.getPage(pageNoStr,parameters);
		List<User> userList = userService.getAllUser();
		
		map.put("page", page);
		map.put("userList", userList);
		
		return "customerService/list";
	}
	@RequestMapping("/deal/list")
	public String dealList(@RequestParam(value="pageNoStr",required=false) String pageNoStr,
				  			HttpServletRequest request,
				  			Map<String, Object> map) {
		User allotTo = (User)request.getSession().getAttribute("user");
		//从请求request对象中获取参数的map集合
		Map<String, Object> parameters = WebUtils.getParametersStartingWith(request, "search_");
		
		//将map转换为字符串  queryString
		String queryString = CRMUtils.encodeParameterMapToQueryString(parameters, "search_");
		
		//将queryString放置在map域中,用page标签的属性queryString来接收
		map.put("queryString",queryString);
		System.out.println("handler中的queryString:"+queryString);
		Page<CustomerService> page = service.getDealPage(pageNoStr,parameters,allotTo);
		List<User> userList = userService.getAllUser();
		
		map.put("page", page);
		map.put("userList", userList);
		
		return "customerService/serviceDealList";
	}
	@RequestMapping("/feedback/list")
	public String feedBackList(@RequestParam(value="pageNoStr",required=false) String pageNoStr,
  			HttpServletRequest request,
  			Map<String, Object> map) {
		
		//从请求request对象中获取参数的map集合
		Map<String, Object> parameters = WebUtils.getParametersStartingWith(request, "search_");
		
		//将map转换为字符串  queryString
		String queryString = CRMUtils.encodeParameterMapToQueryString(parameters, "search_");
		
		//将queryString放置在map域中,用page标签的属性queryString来接收
		map.put("queryString",queryString);
		System.out.println("handler中的queryString:"+queryString);
		Page<CustomerService> page = service.getFeedBackPage(pageNoStr,parameters);
		List<User> userList = userService.getAllUser();
		
		map.put("page", page);
		map.put("userList", userList);
		
		return "customerService/feedbackList";
	}
	@RequestMapping("/archive/list")
	public String archiveList(@RequestParam(value="pageNoStr",required=false) String pageNoStr,
				  			  HttpServletRequest request,
				  			  Map<String, Object> map) {
		//从请求request对象中获取参数的map集合
		Map<String, Object> parameters = WebUtils.getParametersStartingWith(request, "search_");
		
		//将map转换为字符串  queryString
		String queryString = CRMUtils.encodeParameterMapToQueryString(parameters, "search_");
		
		//将queryString放置在map域中,用page标签的属性queryString来接收
		map.put("queryString",queryString);
		Page<CustomerService> page = service.getArchivePage(pageNoStr,parameters);
		List<User> userList = userService.getAllUser();
		
		map.put("page", page);
		map.put("userList", userList);
		
		return "customerService/archiveList";
	}
}
