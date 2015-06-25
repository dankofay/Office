package logos.office.officeProject.dto;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class ScheduleDTO {

	private Date date;
	private String name;
	private Time startTime;
	private Time duration;
	private List<UserDTO>users;
	
	public ScheduleDTO(Date date, String name, Time startTime, Time duration,
			List<UserDTO> users) {
		
		this.date = date;
		this.name = name;
		this.startTime = startTime;
		this.duration = duration;
		this.users = users;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	public List<UserDTO> getUsers() {
		return users;
	}
	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

	
}
