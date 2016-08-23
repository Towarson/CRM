package com.atguigu.crm.handlers;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.atguigu.crm.entity.Contact;
import com.atguigu.crm.entity.Customer;
import com.atguigu.crm.entity.SalesChance;
import com.atguigu.crm.entity.User;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.service.SalesChanceService;
import com.atguigu.crm.service.UserService;
import com.atguigu.crm.utils.CRMUtils;

@RequestMapping("/chance")
@Controller
public class SalesChanceHandler {
	
	@Autowired
	private SalesChanceService salesChanceService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 修改销售机会用户
	 * @param chance
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value="/details/{id}",method=RequestMethod.GET)
	public String details(@PathVariable("id") Long id,Map<String,Object> map) {
		SalesChance chance = salesChanceService.getWithPlan(id);
		map.put("chance", chance);
		return "plan/showPlan";
	}
	@RequestMapping(value="/stop/{id}",method=RequestMethod.PUT)
	public String stop(@PathVariable("id") Long id) {
		String status = "4";
		salesChanceService.updateStatus(status,id);
		return "redirect:/plan/chance/list";
	}
	@RequestMapping(value="/finish/{id}",method=RequestMethod.PUT)
	public String finish(@PathVariable("id") Long id) {
		
		SalesChance chance = salesChanceService.get(id);
		String custName = chance.getCustName();
		String tel = chance.getContactTel();
		String no = UUID.randomUUID().toString();
		String status = "3";
		salesChanceService.updateStatus(status,id);
		
		Customer customer = new Customer();
		customer.setName(custName);
		customer.setNo(no);
		customer.setState("正常");
		
		salesChanceService.saveCustomer(customer);
		
		Contact contact = new Contact();
		contact.setCustomer(customer);
		contact.setName(custName);
		contact.setTel(tel);
		
		salesChanceService.saveContact(contact);
		
		return "redirect:/plan/chance/list";
	}
	@RequestMapping(value="/dispatch/{id}",method=RequestMethod.PUT)
	public String saveDispatch(@PathVariable("id") Long id,SalesChance salesChance) {
		Long designeeId = salesChance.getDesignee().getId();
		Date designeeDate = salesChance.getDesigneeDate();
		salesChanceService.updateDispatch(id, designeeId, designeeDate);
		return "redirect:/chance/list";
	}
	@RequestMapping(value="/dispatch/{id}",method=RequestMethod.GET)
	public String dispatch(@PathVariable("id") Long id,Map<String,Object> map) {
		
		SalesChance salesChance = salesChanceService.get(id);
		List<User> userList = userService.getAllUser();
		salesChance.setDesigneeDate(new Date());
		map.put("chance", salesChance);
		map.put("userList", userList);
		return "chance/dispatch";
	}
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String update(SalesChance chance,RedirectAttributes attributes) {
		salesChanceService.update(chance);
		attributes.addFlashAttribute("message", "修改成功！");
		return "redirect:/chance/list";
	}
	
	/**
	 * 用于修改销售机会用户时，表单回显
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id") Long id , Map<String,Object> map) {
		
		map.put("chance", salesChanceService.get(id));
		
		return "chance/input";
	}
	/**
	 * 删除销售机会用户
	 * @param id
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id,RedirectAttributes attributes) {
		
		salesChanceService.delete(id);
		attributes.addFlashAttribute("message", "删除成功!");
		
		return "redirect:/chance/list";
	}
	
	/**
	 * 保存销售机会用户
	 * @param salesChance
	 * @param session
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String save(SalesChance salesChance,HttpSession session,RedirectAttributes attributes) {
		
		User createBy = (User) session.getAttribute("user");
		salesChance.setCreateBy(createBy);
		salesChanceService.save(salesChance);
		
		attributes.addFlashAttribute("message", "创建成功!");
		
		return "redirect:/chance/list";
	}
	
	/**
	 * 创建新的销售机会用户,到达新建用户的界面
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String input(Map<String,Object> map) {
		SalesChance salesChance = new SalesChance();
		salesChance.setCreateDate(new Date());
		map.put("chance", salesChance);
		return "chance/input";
	}
	/**
	 * 1. 对 SalesChance 的不带查询条件的分页.
	 * 2. 显示的是 "才创建" 的销售机会, 且是 "当前登录用户创建" 的销售机会. 
	 * 1). 才创建: status=1 
	 * 2). 当前登录用户创建: createBy 为当前登录用户. 
	 * 
	 * 2. 关于分页:
	 * 1). 前端页面传入: pageNo 和 pageSize(可选). 
	 * 2). 服务端查询: totalRecordNo 和 pageList. 
	 * 3). 注意: 一定要先查询 totalRecordNo, 然后来校验 pageNo 的合法性, 然后再查询 pageList. 
	 * 
	 * 3. 编写 Page 类: 把分页信息都封装到 Page 类中. 
	 * 4. myBatis 分页: 因为 mybatis 的底层是一个 Mapper 接口, 则分页逻辑需要上移到 Service 层.
	 */
	/**
	 * 列出所有刚刚加入的销售机会用户,修改为带条件查询
	 * @param pageNoStr
	 * @param session
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/list")
	public String list(@RequestParam(value="pageNoStr",required=false) String pageNoStr,
			HttpSession session,
			Map<String, Object> map,
			HttpServletRequest request) {
		//1. 获取查询条件的请求参数. 能不能批量的获取查询条件的请求参数. 
		//1.1 查询条件的请求参数要和一般的参数有区别: 使请求参数有前缀: search_
		//1.2 可以通过 request.getParameterMap 来编写一个工具方法. 来获取指定前缀的请求参数的 Map.
		Map<String, Object> parameters = WebUtils.getParametersStartingWith(request, "search_");
		
		//2. 如何能能够保证查询条件不丢: 在点击 "翻页" 链接时, 可以保留查询条件.
		//2.1 把前面获取的请求参数的 Map 序列化为一个查询字符串: {LIKE_contact=c, LIKE_custName=a, LIKE_title=b}
		//search_LIKE_contact=c&search_LIKE_custName=a&search_LIKE_title=b
		//2.2 把改查询字符串传回到客户端，用map传过去
		//2.3 点击 "翻页" 链接时, 在传回来.用url传回来
		String queryString = CRMUtils.encodeParameterMapToQueryString(parameters, "search_");
		map.put("queryString", queryString);
		
		User createBy = (User) session.getAttribute("user");
		
		Page<SalesChance> page = salesChanceService.getPageForCondition(pageNoStr, createBy, parameters);
		map.put("page", page);
		
		return "chance/list";
	}
}
