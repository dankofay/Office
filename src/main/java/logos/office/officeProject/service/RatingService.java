package logos.office.officeProject.service;

import java.util.List;
import logos.office.officeProject.model.Rating;

public interface RatingService {

	List <Rating> findRatingByNewsTitle (String title);
	List<Rating> getAllRatings();
	
}
