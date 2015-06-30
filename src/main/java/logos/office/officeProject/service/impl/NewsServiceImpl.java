package logos.office.officeProject.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

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
	public List<NewsDTO> getAllNewsByIdUser(Long id) {
		List<NewsDTO> ndto = new ArrayList<>();

		for (News news : newsdao.getAllElements()) {
			Long ln = news.getUser().getId();
			
			if (news.get == id) {
				NewsDTO dto = new NewsDTO(news.getTitle(), news.getComment().size());
				
				for(Rating rating : news.getRating()){
					
				}
				
				ndto.add(dto);

			}
		}
		return ndto;
	}

	@Transactional
	public void News() {

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
