package dao;

import pojo.Employee;

public interface EmployeeDao {
	public Employee getEmployeeById(int id);

	public boolean addEmployee(Employee employee);
	
	public boolean updateEmployee(Employee employee);
	
	public boolean deleteEmployeeById(int id);
}
