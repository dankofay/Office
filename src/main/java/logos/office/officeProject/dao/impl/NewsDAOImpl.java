package logos.office.officeProject.dao.impl;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import logos.office.officeProject.dao.NewsDAO;
import logos.office.officeProject.model.News;


@Repository
public class NewsDAOImpl extends ElementDAOImpl<News> implements NewsDAO {

	public NewsDAOImpl() {
		super(News.class);

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<News> findNewsByUserEmail(String email) {
		try {
			return entityManager.createQuery("From News e Where e.user.email =:email")
	     		   .setParameter("email", email).getResultList();
			}
	        catch (NoResultException e) {
	    		return new ArrayList<>();
	}	
  
}
}