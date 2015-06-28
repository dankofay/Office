package logos.office.officeProject.dto;

import java.sql.Date;

public class CommentDTO {

	private Date date;
	private String name;
	private String comment;
	
	public CommentDTO (Date date, String name, String comment){
		this.date = date;
		this.name = name;
		this.comment = comment;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
