package com.syc.tools;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class DBUtils {
	/**
	 * @author wsh
	 * @data 2019-3-26 15:46
	 * @detail 实现mybatis数据库连接操作
	 */
	public static SqlSession getSession(){
		Logger log=Logger.getLogger(DBUtils.class);
		SqlSessionFactory sf=null;
		SqlSession ss=null;
		Reader rd;
		try {
			//生成字符输入对象,传入SessionFactory中
			rd = Resources.getResourceAsReader("my.xml");
			//sf指向它的子类对象
			sf=new SqlSessionFactoryBuilder().build(rd);
			ss=sf.openSession();
			log.info("连接成功!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("出错了!");
			e.printStackTrace();
		}
		return ss;
		
	}
	
	//关闭数据库操作对象
	public static void closeDB(SqlSession ss){
		if(ss!=null){
			ss.close();
		}
	}

}
