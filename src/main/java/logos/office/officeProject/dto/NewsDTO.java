package logos.office.officeProject.dto;

import java.util.Date;

public class NewsDTO {

	private Date date;
	private String title;
	private int comment;
	private double rating;

	public NewsDTO(Date date, String title, int comment, double rating) {
		this.date = date;
		this.title = title;
		this.comment = comment;
		this.rating = rating;
	}

	public NewsDTO(Date date, String title, int comment) {
		this.date = date;
		this.title = title;
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

}
