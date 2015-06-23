package logos.office.officeProject.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

public class EventDTO {

	private String type;
	private Date date;
	private Time timeFrom;
	private Time duraction;
	public EventDTO(String type, Date date2, Time time,
			Time time2) {
		
		this.type = type;
		this.date = date2;
		this.timeFrom = time;
		this.duraction = time2;

	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTimeFrom() {
		return timeFrom;
	}
	public void setTimeFrom(Time timeFrom) {
		this.timeFrom = timeFrom;
	}
	public Time getDuraction() {
		return duraction;
	}
	public void setDuraction(Time duraction) {
		this.duraction = duraction;
	}
	
	

	
	
	
}
