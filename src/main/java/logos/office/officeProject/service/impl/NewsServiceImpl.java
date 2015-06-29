package logos.office.officeProject.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import logos.office.officeProject.dao.NewsDAO;
import logos.office.officeProject.dto.NewsDTO;
import logos.office.officeProject.model.News;
import logos.office.officeProject.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{
    @Inject
    NewsDAO newsdao;

//    @Transactional
//    public List<NewsDTO> getAllNewsByIdUser(Long id){
//    	List<NewsDTO> ndto = new ArrayList<>();
//    	
//    	for (News news : newsdao.getAllElements()) {
//    		List<News> ln = news.getUser().getNews();
//    		Long ln = news.getUser().getId();
//    		if (ln.equals(id)){
//    			id = getAllNews();
//    			return id;
//    	    if (news.getId() == id){
//    		  ndto.add(new NewsDTO(news.getTitle(),
//    				  news.getComment(), news.getRating()));
    		
//    		}
//    	}
//    	  return ndto;
//    }
    
    @Transactional
    public void News (){
    	
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
