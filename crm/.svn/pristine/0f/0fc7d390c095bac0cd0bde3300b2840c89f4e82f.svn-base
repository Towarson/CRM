package com.atguigu.crm.handlers;

import java.util.List;
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
import com.atguigu.crm.entity.Storage;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.service.ProductService;
import com.atguigu.crm.service.StorageService;
import com.atguigu.crm.utils.CRMUtils;

@RequestMapping("/storage")
@Controller
public class StorageHandler {
	
	@Autowired
	private StorageService storageService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.PUT)
	public String update(@RequestParam("incrementCount") Long incrementCount,Storage storage,RedirectAttributes attributes) {
		storageService.updateCount(storage,incrementCount);
		attributes.addFlashAttribute("message","修改成功!");
		return "redirect:/storage/list";
	}
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id") Long id,Map<String,Object> map) {
		Storage storage = storageService.get(id);
		map.put("storage", storage);
		return "storage/input";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id,RedirectAttributes attributes) {
		
		storageService.delete(id);
		
		attributes.addFlashAttribute("message", "删除成功!");
		return "redirect:/storage/list";
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String save(Storage storage,RedirectAttributes attributes) {
		storageService.save(storage);
		attributes.addFlashAttribute("message", "操作成功!");
		
		return "redirect:/storage/list";
	}
	
	/**
	 * 到创建仓库的界面，需要在map中放置一个空的Storage对象,需要查询出storage.product.name
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String input(Map<String,Object> map) {
		
		List<Product> productList = productService.getAll();
		Storage storage = new Storage();
		
		map.put("storage", storage);
		map.put("productList", productList);
		
		return "storage/input";
	}
	
	/**
	 * 列出所有的库存信息
	 * @param pageNoStr
	 * @return
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value="pageNoStr",required=false) String pageNoStr,
			Map<String, Object> map,
			HttpServletRequest request) {
		
		/*Product product = new Product();
		if(productName != null && !productName.trim().equals("")) {
			product.setName(productName);
		}*/
		//从请求request对象中获取参数的map集合
		Map<String, Object> parameters = WebUtils.getParametersStartingWith(request, "search_");
		
		//将map转换为字符串
		String queryString = CRMUtils.encodeParameterMapToQueryString(parameters, "search_");
		
		//将queryString放置在map域中,用page标签的属性queryString来接受
		map.put("queryString", queryString);
		
		Page<Storage> page = storageService.getPage(pageNoStr,parameters);
		
		map.put("page", page);
		
		return "storage/list";
	}
}
