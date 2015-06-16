package logos.office.officeProject.service;

import java.util.List;
import logos.office.officeProject.model.News;

public interface NewsService {

	List <News> findNewsByUserEmail (String email);
	List<News> getAllNews();
	
}
