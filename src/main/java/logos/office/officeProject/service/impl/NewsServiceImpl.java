package logos.office.officeProject.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.inject.Inject;
import javax.transaction.Transactional;
import logos.office.officeProject.dao.NewsDAO;
import logos.office.officeProject.dao.UserDao;
import logos.office.officeProject.dto.NewsDTO;
import logos.office.officeProject.dto.RatingDTO;
import logos.office.officeProject.model.News;
import logos.office.officeProject.model.Rating;
import logos.office.officeProject.model.User;
import logos.office.officeProject.service.NewsService;

import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {
	@Inject
	private NewsDAO newsdao;
	@Inject
	private UserDao userdao;
	
	

	@Transactional
	public List<NewsDTO> getAllNewsByIdUser(Long userId) {
		List<NewsDTO> ndto = new ArrayList<>();

		for (News news : newsdao.findNewsByUserId(userId)) {

			NewsDTO dto = new NewsDTO(news.getDate(), news.getTitle(), news
					.getComment().size());

			for (Rating rat : news.getRating()) {
//				Scanner scan = new Scanner(System.in);
//				int count, rat =0;
//                for(count = 0, scan.hasNextInt(), count++){
//                	rat += scanNextInt();
//                }
				
//			RatingDTO rdto - new RatingDTO(news.getRating());  ???
				
						
			}

			ndto.add(dto);

		}
		return ndto;
	} 


	@Transactional
	public void addNews(Date date, String title, int comment, double rating) {
//		List<News>list = new ArrayList<News>();
		for(User u : userdao.getAllElements()){
			Long idUser = null;
			if(u.getId() == idUser){
				newsdao.addElement(new News());	
			}
		}
		
//		userdao.addElement(new News(date, comment, title, rating,
//        		 user, new ArrayList<Rating>(), new ArrayList<Comment>()));
	
	}
	
	@Transactional
	public void deleteNews(Date date, String title, int comment, double rating){
		for (News n : newsdao.getAllElements()){
			if(n.getId() != hashCode()){
				newsdao.deleteElement(n);;
			}
		}
	}
	
	
	@Transactional
	public List<News> getAllNews() {

		return newsdao.getAllElements();
	}

	@Transactional
	public List<News> findNewsByUserEmail(String email) {

		return newsdao.findNewsByUserEmail(email);
	}

	@Override
	public void saveNews(Date date, String title, int comment,
			double rating) {
		
	}

}
