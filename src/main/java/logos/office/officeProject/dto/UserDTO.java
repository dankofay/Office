package logos.office.officeProject.dto;

import java.util.List;

public class UserDTO {

	private String fullName;
	private int age;
	private String email;
	private List<String> roles;
	private Integer rateValue;

	public UserDTO() {
	}

	public UserDTO(String fullName, int age, String email, List<String> roles,
			Integer rateValue) {
		this.fullName = fullName;
		this.age = age;
		this.email = email;
		this.roles = roles;
		this.rateValue = rateValue;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public Integer getRateValue() {
		return rateValue;
	}

	public void setRateValue(Integer rateValue) {
		this.rateValue = rateValue;
	}

}
