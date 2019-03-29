package com.kexun.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kexun.dao.impl.IProductDao;
import com.kexun.service.ProductService;

@Service
public class IProductService implements ProductService {
	@Resource
	private IProductDao ipd;

	@Override
	public String getJsonString() {
		// TODO Auto-generated method stub

		return ipd.selectAll();
	}

}
