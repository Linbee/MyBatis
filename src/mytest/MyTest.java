package mytest;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import dao.EmployeeDao;
import pojo.Employee;
import pojo.EmployeeMapperAnnotation;

public class MyTest {

	/*
	 * 根据xml配置文件，创建SqlSessionFactory对象
	 * 		有数据源的一些运行环境信息
	 * sql映射文件，配置了每一个sql，以及sql的封装规则等
	 * 将sql映射文件注册证全局配置文件中
	 * 代码编写
	 * 		跟去全局配置文件得到SqlSessionFactory
	 * 		使用sqlSession工厂，获取到sqlSession对象使用来完成增删改查
	 * 		一个sqlSession就是代表着和数据库的一次会话，用完需要关闭
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
	
	public SqlSession getSqlSession()
	{
		SqlSession sqlSession=null;
		try
		{
			String resource ="mybatis-config.xml";
			InputStream inputStream=Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession=sqlSessionFactory.openSession();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return sqlSession;
	}
	
	
	@Test
	public void interfaceTest()
	{
		SqlSession sqlSession=null;
		try
		{	
			/*创建sqlSessionFactory 获取sqlSession*/
			String resource="mybatis-config.xml";
			InputStream inputStream=Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession=sqlSessionFactory.openSession();
		
			
			/*mybaits的接口编程
			 * 
			*/
			EmployeeDao employeeDao=sqlSession.getMapper(EmployeeDao.class);
			Employee emp=employeeDao.getEmployeeById(1);
			System.out.println(emp);
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			sqlSession.close();
		}
	}
	
	@Test
	public void testAnnotation()
	{
		SqlSession sqlSession=getSqlSession();
		EmployeeMapperAnnotation employeeMapperAnnotation= sqlSession.getMapper(EmployeeMapperAnnotation.class);
		System.out.println(employeeMapperAnnotation.getEmpById(1));
	}
	
	@Test
	public void testCRUD()
	{
		SqlSession sqlSession = null;
		try
		{
			String resource="mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession(true); //开启自动提交
			
			EmployeeDao employeeDao=sqlSession.getMapper(EmployeeDao.class);
			Employee emp=employeeDao.getEmployeeById(1);
			
			//employeeDao.addEmployee(new Employee("sccc","sccc@mail.com","0"));
			
			Employee old = employeeDao.getEmployeeById(1);
			old.setEmail("oldtom33@mail.com");
			old.setLastName("old_Tom");
			employeeDao.updateEmployee(old);
			
			employeeDao.deleteEmployeeById(3);
			
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testGeneratedKey()
	{
		try
		{
			String resource ="mybatis-config.xml";
			InputStream inputStream=Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession =sqlSessionFactory.openSession(true);
			
			EmployeeDao employeeDao=sqlSession.getMapper(EmployeeDao.class);
			
			Employee newEmployee = new Employee("Jery","jery@mail.com","0");
			employeeDao.addEmployee(newEmployee);
			System.out.println(newEmployee.getId());
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
	}
	
	
	@Test
	public void testParameters()
	{
		SqlSession sqlSession = getSqlSession();
		EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
		Employee temp= employeeDao.getEmployeeById(2);
		System.out.println(temp);
		
		temp=employeeDao.getEmployeeByIdAndLastName(2, "sccc");
		
		temp.setId(5);
		temp.setLastName("Jery");
		
		temp=employeeDao.getEmployeeByPojo(temp);
		System.out.println(temp);
		
		sqlSession.commit();
	}
	
	@Test
	public void testSelectByMap()
	{
		try
		{
			String resource="mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
			
			EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
			Map<String,Object> info = new HashMap<>();
			info.put("tableName","tbl_employee");
			info.put("id",1);
			Employee temp = employeeDao.getEmployeeByIdAndTableName(info);
			System.out.println(temp);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			
		}
	}
	
	@Test
	public void testSelectOtherResultType()
	{
		try
		{
			String resource="mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession(true);
			
			EmployeeDao employeeDao = sqlSession.getMapper(EmployeeDao.class);
			List<Employee> list =employeeDao.getEmployeeByLastName("sccc");
			System.out.println(list);
			
			Map<String,Object> testMap = employeeDao.getEmployeeByIdReturnMap(1);
			System.out.println(testMap);
			
			Map<Integer,Employee> employeeList = employeeDao.getEmployeeByLastNameLikeReturnMap("%c%");
			System.out.println(employeeList);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			
		}
	}
}
