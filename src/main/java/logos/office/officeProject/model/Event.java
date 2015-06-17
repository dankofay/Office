package logos.office.officeProject.model;

import java.sql.Time;
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
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "Event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "time_from")
	private Time timeFrom;

	@Column(name = "duration")
	private Time duration;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private Type type;

	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "schedule_id")
	private Schedule schedule;

	@Column(name = "is_Confirmed")
	private boolean isConfirmed;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "User_has_Event", joinColumns = { @JoinColumn(name = "id_event", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_user", nullable = false, updatable = false) })
	List<User> users;

	public Event() {
	
	}

	@Override
	public String toString() {
		return "timeFrom=" + timeFrom + ", duration=" + duration
				+ ", type=" + type + ", schedule=" + schedule
				+ ", isConfirmed=" + isConfirmed + ", users=" + users + "]";
	}

	
	
	public Event(Long id, Time timeFrom, Time duration, Type type,
			Schedule schedule, boolean isConfirmed, List<User> users) {
		super();
		this.id = id;
		this.timeFrom = timeFrom;
		this.duration = duration;
		this.type = type;
		this.schedule = schedule;
		this.isConfirmed = isConfirmed;
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Time getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(Time timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Time getDuration() {
		return duration;
	}

	public void setDuration(Time duration) {
		this.duration = duration;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public boolean isConfirmed() {
		return isConfirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isConfirmed ? 1231 : 1237);
		result = prime * result
				+ ((schedule == null) ? 0 : schedule.hashCode());
		result = prime * result
				+ ((timeFrom == null) ? 0 : timeFrom.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Event other = (Event) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isConfirmed != other.isConfirmed)
			return false;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		if (timeFrom == null) {
			if (other.timeFrom != null)
				return false;
		} else if (!timeFrom.equals(other.timeFrom))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	

}
