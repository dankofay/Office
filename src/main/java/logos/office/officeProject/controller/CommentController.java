package logos.office.officeProject.controller;

import java.util.List;
import javax.inject.Inject;
import logos.office.officeProject.model.Comment;
import logos.office.officeProject.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/comments")
public class CommentController {

	@Inject
	private CommentService commentService;
	
	@RequestMapping
	public ModelAndView getComments (ModelAndView model){
		model.addObject("commentsList", commentService.getAllComments());
		model.setViewName("comment");
		return model;
	}
	
	@RequestMapping (value = "{/getCommentByNewsTitle}", method = RequestMethod.GET)
	public String getCommentByNewsTitle (Model model, @PathVariable String title){
		List<Comment> comments = commentService.findCommentByNewsTitle(title);
		model.addAttribute("title", comments);
		
		return "comments";
	}
	
}
