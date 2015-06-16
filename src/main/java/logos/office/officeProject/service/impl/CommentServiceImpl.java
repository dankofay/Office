package logos.office.officeProject.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import logos.office.officeProject.dao.CommentDAO;
import logos.office.officeProject.model.Comment;
import logos.office.officeProject.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	@Inject
	CommentDAO commentdao;


	@Transactional
	public List<Comment> getAllComments() {
		
		return commentdao.getAllElements();
	}

	@Transactional
	public List<Comment> findCommentByNewsTitle(String title) {
		
		return commentdao.findCommentByNewsTitle(title);
	}	
	
}
