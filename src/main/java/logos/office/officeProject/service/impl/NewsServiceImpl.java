package logos.office.officeProject.service.impl;

import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import logos.office.officeProject.dao.NewsDAO;
import logos.office.officeProject.model.News;
import logos.office.officeProject.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{
    @Inject
    NewsDAO newsdao;


@Transactional
public List<News> getAllNews() {
	
	return newsdao.getAllElements();
}

@Transactional
	public List<News> findNewsByUserEmail(String email) {
		
		return newsdao.findNewsByUserEmail(email);
	}
	
}
