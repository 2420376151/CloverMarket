package com.kexun.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kexun.dao.ProductDao;
import com.kexun.entity.Product;

import net.sf.json.JSONObject;
//此处为有自定义的对象名ipd,也可以使用默认的对象名
//iProductDao
@Repository("ipd")
public class IProductDao implements ProductDao{

	@Override
	public String selectAll() {
		// TODO Auto-generated method stub
		List<Product> list=new ArrayList<Product>();
		Product p1=new Product(1005, "iphone20", "苹果", 8888.6);
		Product p2=new Product(1005, "HUAWEIp90", "华为", 5000.3);
		Product p3=new Product(1005, "SUMSUNG30", "三星", 4000.0);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		//生成json工具对象
		JSONObject obj=new JSONObject();
		//以键值对的方式放入一个对象
		obj.put("list", list);
		//将对象转成json字符串[{},{},{},{}]
		String json=obj.toString();
		return json;
	}

}
