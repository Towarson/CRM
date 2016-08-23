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

import com.atguigu.crm.entity.Product;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.service.ProductService;
import com.atguigu.crm.utils.CRMUtils;

@RequestMapping("/product")
@Controller
public class ProductHandler {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String update(Product product,RedirectAttributes attributes) {
		productService.update(product);
		attributes.addFlashAttribute("message","修改成功!");
		return "redirect:/product/list";
	}
	/**
	 * 用于修改产品时，表单回显
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id") Long id, Map<String,Object> map) {
		
		map.put("product", productService.get(id));
		
		return "product/input";
	}
	
	/**
	 * 删除产品
	 * @param id
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id,RedirectAttributes attributes) {
		
		productService.delete(id);
		
		attributes.addFlashAttribute("message","删除成功!");
		
		return "redirect:/product/list";
	}
	
	/**
	 * 保存新创建的产品
	 * @param product
	 * @param attributes
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String save(Product product,RedirectAttributes attributes) {
		productService.save(product);
		attributes.addFlashAttribute("message", "保存成功！");
		return "redirect:/product/list";
	}
	
	/**
	 * 前往添加界面
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String input(Map<String,Object> map) {
		Product product = new Product();
		map.put("product", product);
		return "product/input";
	}
	
	
	/**
	 * 分页显示所有的产品
	 * @param pageNoStr
	 * @param map
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="pageNoStr",required=false) String pageNoStr,
			Map<String, Object> map,
			HttpServletRequest request) {
		//从请求request对象中获取参数的map集合
		Map<String, Object> parameters = WebUtils.getParametersStartingWith(request, "search_");
		
		//将map转换为字符串
		String queryString = CRMUtils.encodeParameterMapToQueryString(parameters, "search_");
		
		//将queryString放置在map域中,用page标签的属性queryString来接受
		map.put("queryString", queryString);
		
		Page<Product> page = productService.getPage(pageNoStr,parameters);
		
		map.put("page", page);
		
		return "product/list";
	}
	
}
