package com.kexun.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kexun.dao.ProductDao;
import com.kexun.entity.Product;

import net.sf.json.JSONObject;
//�˴�Ϊ���Զ���Ķ�����ipd,Ҳ����ʹ��Ĭ�ϵĶ�����
//iProductDao
@Repository("ipd")
public class IProductDao implements ProductDao{

	@Override
	public String selectAll() {
		// TODO Auto-generated method stub
		List<Product> list=new ArrayList<Product>();
		Product p1=new Product(1005, "iphone20", "ƻ��", 8888.6);
		Product p2=new Product(1005, "HUAWEIp90", "��Ϊ", 5000.3);
		Product p3=new Product(1005, "SUMSUNG30", "����", 4000.0);
		list.add(p1);
		list.add(p2);
		list.add(p3);
		//����json���߶���
		JSONObject obj=new JSONObject();
		//�Լ�ֵ�Եķ�ʽ����һ������
		obj.put("list", list);
		//������ת��json�ַ���[{},{},{},{}]
		String json=obj.toString();
		return json;
	}

}
