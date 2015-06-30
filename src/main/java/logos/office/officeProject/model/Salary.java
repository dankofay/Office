package logos.office.officeProject.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Salary")
public class Salary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "value")
	private Integer value;

	@Column(name = "date")
	private Date date;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;

	public Salary() {

	}


	
	public Salary(Integer value, Date date, User user) {
		super();
		this.value = value;
		this.date = date;
		this.user = user;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Integer getValue() {
		return value;
	}



	public void setValue(Integer value) {
		this.value = value;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Salary [id=" + id + ", value=" + value + ", date=" + date + "]";
	}

	

}