package logos.office.officeProject.dao;

import java.util.List;

import logos.office.officeProject.model.Comment;

public interface CommentDAO extends ElementDAO<Comment>{

	List <Comment> findCommentByNewsTitle (String title);
	
}
