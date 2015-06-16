package logos.office.officeProject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import logos.office.officeProject.dao.CommentDAO;
import logos.office.officeProject.model.Comment;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CommentDAOImpl extends ElementDAOImpl<Comment> implements CommentDAO {

	public CommentDAOImpl (){
		super(Comment.class);
	}

	@Transactional
	@SuppressWarnings("unchecked")
	public List <Comment> findCommentByNewsTitle (String title){

        try {
        	return entityManager.createQuery("From Comment e Where e.news.title =:title2")
        		.setParameter("title2", title).getResultList();
	} 
        catch (NoResultException e) {
		return new ArrayList<>();
	}
}	
}