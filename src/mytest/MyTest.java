package mytest;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import pojo.Employee;

public class MyTest {

	/*
	 * 
	*/
	@Test
	public void start() throws IOException
	{
		String resource ="mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSession=new SqlSessionFactoryBuilder().build(inputStream);
	
		SqlSession openSession = sqlSession.openSession();
	
		Employee emp=openSession.selectOne("selectEmp",1);
		
		openSession.close();
		
		System.out.println(emp);
		
	}
}
