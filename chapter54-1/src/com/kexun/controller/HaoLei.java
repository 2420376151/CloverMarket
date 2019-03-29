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
	// ����ӳ��һ��������ע��;�˴��н�������������Ⲣ��ָ��Ϊpost
	@RequestMapping(value="/go",produces = "text/json;charset=UTF-8",method=RequestMethod.POST)
	// ����Ҫ�������Ƿ���һ��json��ʽ���ַ�����xml�ļ�
	// ��ǰ�˵���,������ע��
	@ResponseBody
	public String play() {
		//String json="{\"name\":\"tom\"}";
		String json=iProductService.getJsonString();
		return json;
	}
	
	//(2)�������@RequestParm,���Դ���HTTPServletRequest
	@RequestMapping(value="/go2",produces = "text/json;charset=UTF-8")
	public ModelAndView playTwo(@RequestParam String hqy){
		System.out.println("�����:"+hqy);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/index.html");
		return mv;
		
	}
	
	//(3)·������ע��,���ڻ�ȡ�ڶ����󴮽�һ��ֵ
	@RequestMapping("go3/{id}")
	public void playthree(@PathVariable String id){
		System.out.println("�����:"+id);
	}
	
	//(4)�ض���ʵ�ִ�ֵ����,Ӧ��Flash����
	@RequestMapping(value="go4",method=RequestMethod.GET)
	public String playFour(RedirectAttributes rds){
		rds.addFlashAttribute("msg","������Flash������ֵ");
		return "redirect:/show.jsp";
	}
}
