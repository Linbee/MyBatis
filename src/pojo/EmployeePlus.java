package pojo;

public class EmployeePlus {
	private Integer id;
	private String lastName;
	private String email;
	private String gender;
	private Department department;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "EmployeePlus [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender
				+ ", department=" + department + "]";
	}
	
	
}
