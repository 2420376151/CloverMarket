package com.kexun.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kexun.service.impl.IProductService;

@Controller
public class HaoLei {
	@Resource
	IProductService iProductService;
	// 它是映射一个动作的注解;此处有解决汉字乱码问题并且指定为post
	@RequestMapping(value="/go",produces = "text/json;charset=UTF-8",method=RequestMethod.POST)
	// 它主要的作用是返回一个json格式的字符串或xml文件
	// 给前端调用,并进行注解
	@ResponseBody
	public String play() {
		//String json="{\"name\":\"tom\"}";
		String json=iProductService.getJsonString();
		return json;
	}
	
	//(2)请求参数@RequestParm,可以代替HTTPServletRequest
	@RequestMapping(value="/go2",produces = "text/json;charset=UTF-8")
	public ModelAndView playTwo(@RequestParam String hqy){
		System.out.println("这个是:"+hqy);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/index.html");
		return mv;
		
	}
	
	//(3)路径变量注解,用于获取在动作后串接一个值
	@RequestMapping("go3/{id}")
	public void playthree(@PathVariable String id){
		System.out.println("这个是:"+id);
	}
	
	//(4)重定向实现传值功能,应用Flash技术
	@RequestMapping(value="go4",method=RequestMethod.GET)
	public String playFour(RedirectAttributes rds){
		rds.addFlashAttribute("msg","我是用Flash技术传值");
		return "redirect:/show.jsp";
	}
}
