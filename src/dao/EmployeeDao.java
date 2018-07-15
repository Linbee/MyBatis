package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import pojo.Employee;
import pojo.EmployeePlus;

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
	
//	使用resultMap自定义返回的结果集 确保在列名和类的属性名不同时正确的映射
	public Employee getEmployeeByIdUseResultMap(int id);

//	关联属性 级联查询
	public EmployeePlus getEmployPlusById(int id);
//   association的分步查询  一对一
	public EmployeePlus getEmployeePlusByStep(int id);

//  某部门下的所有员工
	public List<EmployeePlus> getAllEmployeeBydepartmentId(int dep_id);
	
// 鉴别器查询
	public EmployeePlus getEmployeePlusByStepAndDiscriminator(int id);
	
// 动态SQL查询之if
	public List<Employee> getEmployeeByConditionIf(Employee employee);

// 动态SQL查询之choose
	public List<Employee> getEmployeeByConditionChoose(Employee employee);

// 动态SQL查询 之 set
	public void updateEmployeeByDynamic(Employee employee);

// 动态SQL批量保存 foreach
	public void addEmployeeDynamic(@Param("emps")List<EmployeePlus> employees);

	public List<EmployeePlus> getEmployeeTestInnerParameter(EmployeePlus temp);
}
