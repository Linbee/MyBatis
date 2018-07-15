package pojo;

import java.io.Serializable;
import java.util.List;

public class Department  implements Serializable {
	int id;
	String departmentName;
	List<EmployeePlus> emps;
	
	
	
	public Department() {
		super();
	}
	public Department(int id) {
		super();
		this.id = id;
	}
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
