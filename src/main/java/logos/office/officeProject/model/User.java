package logos.office.officeProject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name", nullable = false, length = 80)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 80)
	private String lastName;

	@Column(nullable = false, length = 80)
	private Integer age;

	@Column(nullable = false, unique = true, length = 80)
	private String email;

	@Column(nullable = false, unique = true, length = 80)
	private String password;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "user")
	private List<News> news;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Salary> salaries;

	// @OneToMany (cascade={CascadeType.ALL}, fetch=FetchType.LAZY,
	// mappedBy="user")
	// private List<Message>massage;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Event_has_User", joinColumns = { @JoinColumn(name = "id_user", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_event", nullable = false, updatable = false) })
	List<Event> events;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Role_has_User", joinColumns = { @JoinColumn(name = "id_user", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_role", nullable = false, updatable = false) })
	List<Role> roles;

	public User() {
	}

	public User(String firstName, String lastName, int age, String email,
			String password) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	public List<Salary> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((events == null) ? 0 : events.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((news == null) ? 0 : news.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result
				+ ((salaries == null) ? 0 : salaries.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (news == null) {
			if (other.news != null)
				return false;
		} else if (!news.equals(other.news))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (salaries == null) {
			if (other.salaries != null)
				return false;
		} else if (!salaries.equals(other.salaries))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + ", email=" + email
				+ ", password=" + password + ", news=" + news + ", salaries="
				+ salaries + ", events=" + events + ", roles=" + roles + "]";
	}

	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + age;
	// result = prime * result + ((email == null) ? 0 : email.hashCode());
	// result = prime * result
	//
	// + ((firstName == null) ? 0 : firstName.hashCode());
	// result = prime * result
	// + ((lastName == null) ? 0 : lastName.hashCode());
	// result = prime * result
	// + ((password == null) ? 0 : password.hashCode());
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// User other = (User) obj;
	// if (age != other.age)
	// return false;
	// if (email == null) {
	// if (other.email != null)
	// return false;
	// } else if (!email.equals(other.email))
	// return false;
	// if (firstName == null) {
	// if (other.firstName != null)
	// return false;
	// } else if (!firstName.equals(other.firstName))
	// return false;
	// if (lastName == null) {
	// if (other.lastName != null)
	// return false;
	// } else if (!lastName.equals(other.lastName))
	// return false;
	// if (password == null) {
	// if (other.password != null)
	// return false;
	// } else if (!password.equals(other.password))
	// return false;
	// return true;
	// }
	//
	// @Override
	// public String toString() {
	// return "User [firstName=" + firstName + ", lastName=" + lastName
	// + ", age=" + age + ", email=" + email + ", password="
	// + password + "]";
	// }
	//
}
