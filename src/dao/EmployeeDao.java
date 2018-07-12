package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import pojo.Employee;

public interface EmployeeDao {
	
	public Employee getEmployeeById(int id);

	public void addEmployee(Employee employee);
	
	public boolean updateEmployee(Employee employee);
	
	public boolean deleteEmployeeById(int id);
	
	public Employee getEmployeeByPojo(Employee employee);
	
	public List<Employee> getEmployeeByLastName(String lastName);
	
//	返回一条记录的map key为列名 value为对应的值
	public Map<String,Object> getEmployeeByIdReturnMap(int id);
	
//	返回多条封装一个map Map<Integer,Object> key是这个记录的主键 value是对应的类
	@MapKey("id") //告诉mybatis使用哪个属性作为map的key
	public Map<Integer,Employee> getEmployeeByLastNameLikeReturnMap(String lastName);
	
	public Employee getEmployeeByIdAndTableName(Map<String,Object> info);
	
//	@Param 为map指定key值 使其可以映射到xml文件中
	public Employee getEmployeeByIdAndLastName(@Param("id")int id,@Param("lastName")String lastName);
}
