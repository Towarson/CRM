package com.atguigu.crm.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atguigu.crm.entity.Order;
import com.atguigu.crm.orm.Page;
import com.atguigu.crm.service.OrderService;

@RequestMapping("/order")
@Controller
public class OrderHandler {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/{id}")
	public String details(@PathVariable("id") Long id,Map<String,Object> map) {
		Order order = orderService.getWithOrderItem(id);
		map.put("order", order);
		return "order/details";
	}
	
	@RequestMapping("/list/{id}")
	public String list(@PathVariable("id") Long id,@RequestParam(value="pageNoStr",required=false) String pageNoStr,Map<String,Object> map) {
		Page<Order> page = orderService.getPage(pageNoStr,id);
		map.put("page", page);
		return "order/list";
	}
}
