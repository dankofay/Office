package logos.office.officeProject.dao;

import java.util.List;

import logos.office.officeProject.model.Rating;

public interface RatingDAO extends ElementDAO<Rating>{

	List <Rating> findRatingByNewsTitle (String title);
	
}
