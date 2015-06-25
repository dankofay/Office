package logos.office.officeProject.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import logos.office.officeProject.dao.ScheduleDao;
import logos.office.officeProject.model.Event;
import logos.office.officeProject.model.Schedule;

@Repository
public class ScheduleDaoImp extends ElementDAOImpl<Schedule> implements ScheduleDao{


	public ScheduleDaoImp() {
		super(Schedule.class);
		
	}

	@SuppressWarnings("unchecked")
	public Schedule findScheduleByDate(Date date) {
		try {
	           return (Schedule) entityManager.createQuery("From Schedule s Where s.date =:date")
	        		   .setParameter("date", date).getResultList();
	           
	        } catch(NoResultException e) {
	            return new Schedule();
	        }
	}
	
}
