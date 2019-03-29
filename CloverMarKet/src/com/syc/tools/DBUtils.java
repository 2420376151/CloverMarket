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
	 * @detail ʵ��mybatis���ݿ����Ӳ���
	 */
	public static SqlSession getSession(){
		Logger log=Logger.getLogger(DBUtils.class);
		SqlSessionFactory sf=null;
		SqlSession ss=null;
		Reader rd;
		try {
			//�����ַ��������,����SessionFactory��
			rd = Resources.getResourceAsReader("my.xml");
			//sfָ�������������
			sf=new SqlSessionFactoryBuilder().build(rd);
			ss=sf.openSession();
			log.info("���ӳɹ�!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("������!");
			e.printStackTrace();
		}
		return ss;
		
	}
	
	//�ر����ݿ��������
	public static void closeDB(SqlSession ss){
		if(ss!=null){
			ss.close();
		}
	}

}
