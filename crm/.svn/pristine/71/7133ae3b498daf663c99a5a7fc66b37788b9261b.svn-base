package com.atguigu.crm.handlers;

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
import org.springframework.web.util.WebUtils;

import com.atguigu.crm.entity.SalesChance;
import com.atguigu.crm.entity.SalesPlan;
import com.atguigu.crm.entity.User;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.service.SalesChanceService;
import com.atguigu.crm.service.SalesPlanService;
import com.atguigu.crm.utils.CRMUtils;

@RequestMapping("/plan")
@Controller
public class SalesPlanHandler {
	
	@Autowired
	private SalesPlanService salesPlanService;
	
	@Autowired
	private SalesChanceService salesChanceService;
	
	@ResponseBody
	@RequestMapping("/saveresult/{id}")
	public String saveresult(@PathVariable("id") Long id,SalesPlan salesPlan) {
		
		if("".equals(salesPlan.getResult())) {
			return "0";
		}else {
			salesPlanService.saveresult(salesPlan);
			return "1";
		}
	}
	
	@RequestMapping(value="/execute/{id}",method=RequestMethod.GET)
	public String execute(@PathVariable("id") Long id,Map<String,Object> map) {
		
		SalesChance chance = salesChanceService.getWithPlan(id);
		
		map.put("chance", chance);
		
		return "plan/execute";
	}
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public String delete(SalesPlan plan) {
		salesPlanService.delete(plan.getId());
		return "1";
	}
	
	@ResponseBody
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public String update(SalesPlan plan) {
		
		SalesPlan planPre = salesPlanService.get(plan.getId());
		
		if(planPre.getTodo() != null && !"".equals(planPre.getTodo()) && planPre.getTodo().equals(plan.getTodo())){
			return "0";
		}
			
		salesPlanService.update(plan);
		
		return "1";
	}
	
	@ResponseBody
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String newPlan(SalesPlan plan) {
		
		salesPlanService.save(plan);
		
		return ""+ plan.getId();
	}
	
	@RequestMapping("/make/{id}")
	public String toMakePlan(@PathVariable("id") Long id,Map<String,Object> map) {
		
		SalesChance chance = salesChanceService.getWithPlan(id);
		
		map.put("chance", chance);
		
		return "plan/make";
	}
	
	@RequestMapping("/chance/list")
	public String list(@RequestParam(value="pageNoStr",required=false) String pageNoStr,
			Map<String, Object> map,
			HttpSession session,
			HttpServletRequest request) {
		
		//从请求request对象中获取参数的map集合
		Map<String, Object> parameters = WebUtils.getParametersStartingWith(request, "search_");
		
		//将map转换为字符串
		String queryString = CRMUtils.encodeParameterMapToQueryString(parameters, "search_");
		
		//将queryString放置在map域中,用page标签的属性queryString来接受
		map.put("queryString", queryString);
		
		
		User designee = (User) session.getAttribute("user");
		Page<SalesChance> page = salesChanceService.getPageForDesignee(pageNoStr,designee,parameters);
		map.put("page", page);
		
		return "plan/list";
	}
}
