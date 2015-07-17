package logos.office.officeProject.dto;

import java.sql.Date;

public class RatingDTO {

	private Date date;
	private String name;
	private double rating;
	
	public RatingDTO(Date date, String name, double rating){
		this.date = date;
		this.name = name;
		this.rating = rating;
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

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
}
