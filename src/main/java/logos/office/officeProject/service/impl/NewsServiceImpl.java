package logos.office.officeProject.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import logos.office.officeProject.dao.NewsDAO;
import logos.office.officeProject.dto.NewsDTO;
import logos.office.officeProject.model.News;
import logos.office.officeProject.model.Rating;
import logos.office.officeProject.service.NewsService;

import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {
	@Inject
	private NewsDAO newsdao;

	@Transactional
	public List<NewsDTO> getAllNewsByIdUser(Long userId) {
		List<NewsDTO> ndto = new ArrayList<>();

		for (News news : newsdao.findNewsByUserId(userId)) {

			NewsDTO dto = new NewsDTO(news.getDate(), news.getTitle(), news
					.getComment().size());

			for (Rating rating : news.getRating()) {

			}

			ndto.add(dto);

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
