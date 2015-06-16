package logos.office.officeProject.service.impl;

import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import logos.office.officeProject.dao.RatingDAO;
import logos.office.officeProject.model.Rating;
import logos.office.officeProject.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
   @Inject
   RatingDAO ratingdao;

	@Transactional
	public List<Rating> getAllRatings() {
		
		return ratingdao.getAllElements();
	}

	@Transactional
	public List<Rating> findRatingByNewsTitle(String title) {
		
		return ratingdao.findRatingByNewsTitle(title);
	}	

}
