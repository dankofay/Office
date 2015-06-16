package logos.office.officeProject.dao;

import java.util.List;
import logos.office.officeProject.model.News;

public interface NewsDAO extends ElementDAO<News>{

	List <News> findNewsByUserEmail (String email);
	
	
}
