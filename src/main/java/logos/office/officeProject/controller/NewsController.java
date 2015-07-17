package logos.office.officeProject.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import logos.office.officeProject.model.News;
import logos.office.officeProject.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController<addNewsDTO> {

	@Inject
	private NewsService newsService;

	@RequestMapping()
	public ModelAndView getNews(ModelAndView model) {
		model.addObject("newsList", newsService.getAllNews());
		model.setViewName("news");

		return model;
	}

	@RequestMapping(value = "{/getNewsByUserEmail}", method = RequestMethod.GET)
	public String getNewsByUserEmail(Model model, @PathVariable String email) {
		List<News> news = newsService.findNewsByUserEmail(email);
		model.addAttribute("email", news);

		return "news";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addNews(Model model, @RequestParam(value = "date") Date date,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "comment") String content, Principal principal) {

		long userId = Long.parseLong(principal.getName());
		newsService.addNews(date, title, content, userId);

		return "event";
	}
}