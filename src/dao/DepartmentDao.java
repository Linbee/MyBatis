package dao;

import java.util.List;

import pojo.Department;

public interface DepartmentDao {
	
	public Department getDepartmentById(int id);

	public Department getDepartmentPlusById(int id);

	public Department getDepartmentPlusByIdAndStep(int id);
}
