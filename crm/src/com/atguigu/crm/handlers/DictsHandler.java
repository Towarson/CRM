package com.atguigu.crm.handlers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.atguigu.crm.entity.Dict;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.service.DictsService;
import com.atguigu.crm.utils.CRMUtils;

@RequestMapping("/dicts")
@Controller
public class DictsHandler {
	
	@Autowired
	private DictsService dictsService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id,RedirectAttributes attributes) {
		dictsService.delete(id);
		attributes.addFlashAttribute("message","删除成功!");
		return "redirect:/dicts/list";
	}
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String update(Dict dict,RedirectAttributes attributes) {
		dictsService.update(dict);
		attributes.addFlashAttribute("message","修改成功!");
		return "redirect:/dicts/list";
	}
	
	@RequestMapping(value="/create/{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id")Long id,Map<String,Object> map) {
		Dict dict = dictsService.get(id);
		map.put("dict", dict);
		return "dicts/input";
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String save(Dict dict,RedirectAttributes attributes) {
		dictsService.save(dict);
		attributes.addFlashAttribute("message", "保存成功！");
		return "redirect:/dicts/list";
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String input(Map<String,Object> map) {
		Dict dict = new Dict();
		map.put("dict", dict);
		return "dicts/input";
	}
	
	@RequestMapping("/list")
	public String list(@RequestParam(value="pageNoStr",required=false) String pageNoStr,
			Map<String, Object> map,HttpServletRequest request) {
		
		//从请求request对象中获取参数的map集合
		Map<String, Object> parameters = WebUtils.getParametersStartingWith(request, "search_");
		
		//将map转换为字符串  queryString
		String queryString = CRMUtils.encodeParameterMapToQueryString(parameters, "search_");
		
		//将queryString放置在map域中,用page标签的属性queryString来接收
		map.put("queryString", queryString);
		
		Page<Dict> page = dictsService.getPage(pageNoStr,parameters);
		
		map.put("page", page);
		
		return "dicts/list";
	}
}
