package logos.office.officeProject.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import logos.office.officeProject.dao.RatingDAO;
import logos.office.officeProject.model.Rating;

@Repository
public class RatingDAOImpl extends ElementDAOImpl<Rating> implements RatingDAO {

	public RatingDAOImpl() {
		super(Rating.class);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Rating> findRatingByNewsTitle(String title) {
		try {
			return entityManager.createQuery("From Rating e Where e.news.title =:title2")
					.setParameter("title2", title).getResultList();

		}
		catch (NoResultException e) {
			return new ArrayList<>();
		}
	}
}