package logos.office.officeProject.dao.impl;



import javax.persistence.NoResultException;

import logos.office.officeProject.dao.RateDAO;
import logos.office.officeProject.model.Rate;
import logos.office.officeProject.model.Role;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RateDaoImpl extends ElementDAOImpl<Rate> implements RateDAO {

	public RateDaoImpl() {
		super(Rate.class);
	}

	@Transactional
	public Rate findRateByUserRole(Role role) {
		try {
	           return (Rate) entityManager.createQuery("from Rate r  Where r.role =:role").
	        		   setParameter("role", role).getSingleResult();}///÷è resultlist?
		catch (NoResultException e) {
			return new Rate();///ÓÂÀÃÀ!!!
		}
		
		

}
}

	