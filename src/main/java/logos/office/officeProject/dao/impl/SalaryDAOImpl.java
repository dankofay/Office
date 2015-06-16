package logos.office.officeProject.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import logos.office.officeProject.dao.SalaryDAO;
import logos.office.officeProject.model.Salary;

@Repository
public class SalaryDAOImpl extends ElementDAOImpl<Salary> implements SalaryDAO {

	public SalaryDAOImpl() {
		super(Salary.class);

	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Salary> getSalaryByUserId(long userId) {
		try {
			return entityManager
					.createQuery("From Salary s  Where s.user.id =:userId")
					.setParameter("userId", userId).getResultList();
		} catch (NoResultException e) {
			return new ArrayList<>();
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Salary> getSalaryByUserByTimeDuration(long id, Date from,
			Date to) {
		try {
			return entityManager
					.createQuery(
							"FROM Salary WHERE date BETWEEN :from AND :to ")
					.setParameter("from", from).setParameter("to", to)
					.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<>();
		}
	}

}
