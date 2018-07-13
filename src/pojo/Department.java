package pojo;

import java.util.List;

public class Department {
	int id;
	String departmentName;
	List<EmployeePlus> emps;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public List<EmployeePlus> getEmps() {
		return emps;
	}
	public void setEmps(List<EmployeePlus> emps) {
		this.emps = emps;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", emps=" + emps + "]";
	}
	
	
	
}
