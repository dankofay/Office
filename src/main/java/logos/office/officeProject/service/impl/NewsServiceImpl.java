package logos.office.officeProject.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import logos.office.officeProject.dao.CommentDAO;
import logos.office.officeProject.dao.NewsDAO;
import logos.office.officeProject.dao.RatingDAO;
import logos.office.officeProject.dto.NewsDTO;
import logos.office.officeProject.model.News;
import logos.office.officeProject.model.Rating;
import logos.office.officeProject.service.NewsService;

import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {
	@Inject
	private NewsDAO newsdao;
	@Inject
	private CommentDAO commentdao;
	@Inject
	private RatingDAO ratingdao;
	

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


//	@Transactional
//	public void addNews(Date date, String title, int comment, double rating) {
//		Comment comment1 = commentdao.getElementByID(commentId);
//        Rating rating1 = ratingdao.getElementByID(ratingId);
//        
//		newsdao.addElement(new News(date, comment, title, rating,
//        		 user, new ArrayList<Rating>(), new ArrayList<Comment>()));
//		
//
//	}
	
	
	
	
	
	
	@Transactional
	public List<News> getAllNews() {

		return newsdao.getAllElements();
	}

	@Transactional
	public List<News> findNewsByUserEmail(String email) {

		return newsdao.findNewsByUserEmail(email);
	}

}
