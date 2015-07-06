package logos.office.officeProject.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import logos.office.officeProject.dao.CommentDAO;
import logos.office.officeProject.dao.NewsDAO;
import logos.office.officeProject.dto.NewsDTO;
import logos.office.officeProject.model.News;
import logos.office.officeProject.model.Rating;
import logos.office.officeProject.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	@Inject
	NewsDAO newsdao;

	@Transactional
	public List<NewsDTO> getAllNewsByIdUser(Long id_user) {
		List<NewsDTO> ndto = new ArrayList<>();

		for (News news : newsdao.getAllElements()) {
			Long n = news.getUser().getId();
			if (news.getId() == id_user) {
				NewsDTO dto = new NewsDTO(news.getTitle(), news.getComment().size(),
						news.getRating());
				
				for(Rating rating : news.getRating()){
					
				}
				
				ndto.add(dto);

			}
		}
		return ndto;
	}

	@Transactional
	public void addNews(Date date, String title, int comment, double rating) {

	}

	@Transactional
	public List<News> getAllNews() {

		return newsdao.getAllElements();
	}

	@Transactional
	public List<News> findNewsByUserEmail(String email) {

		return newsdao.findNewsByUserEmail(email);
	}

}
