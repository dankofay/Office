package logos.office.officeProject.dto;

import java.util.List;

public class SalaryDTO {
	private String userName;
	private Integer salaryValue;
	private List<String> roles;

	public SalaryDTO() {

	}

	public SalaryDTO(String userName, Integer salaryValue, List<String> roles) {
		this.userName = userName;
		this.salaryValue = salaryValue;
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getSalaryValue() {
		return salaryValue;
	}

	public void setSalaryValue(Integer salaryValue) {
		this.salaryValue = salaryValue;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
