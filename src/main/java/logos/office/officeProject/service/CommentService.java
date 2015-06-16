package logos.office.officeProject.service;

import java.util.List;
import logos.office.officeProject.model.Comment;

public interface CommentService {

	List <Comment> findCommentByNewsTitle (String title);
	List<Comment> getAllComments();
	
}
