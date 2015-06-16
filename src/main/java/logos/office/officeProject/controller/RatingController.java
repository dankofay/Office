package logos.office.officeProject.controller;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import logos.office.officeProject.model.Rating;
import logos.office.officeProject.service.RatingService;

@Controller
@RequestMapping ("/ratings")
public class RatingController {

	@Inject
	private RatingService ratingService;
	
	@RequestMapping
	public ModelAndView getRatings (ModelAndView model){
		model.addObject("ratingsList", ratingService.getAllRatings());
		model.setViewName("rating");
		return model;
	}
	
	@RequestMapping (value = "{/getRatingByNewsTitle}", method = RequestMethod.GET)
		public String getRatingByNewsTitle (Model model, @PathVariable String title){
		List<Rating> ratings = ratingService.findRatingByNewsTitle(title);
		model.addAttribute("title", ratings);
		
		return "ratings";
	}
	
}
