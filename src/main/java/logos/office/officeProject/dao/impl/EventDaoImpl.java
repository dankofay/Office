package logos.office.officeProject.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.NoResultException;


import org.springframework.stereotype.Repository;

import logos.office.officeProject.dao.EventDao;
import logos.office.officeProject.model.Event;

@Repository
public class EventDaoImpl extends ElementDAOImpl<Event> implements EventDao {

	public EventDaoImpl() {
		super(Event.class);

	}

	@SuppressWarnings("unchecked")
	public List<Event> findEventsByTypeName(String typeName){
		
        try {
           return entityManager.createQuery("From Event e Where e.type.nameType =:typeName2 ")
        		   .setParameter("typeName2", typeName).getResultList();
           
        } catch(NoResultException e) {
           return new ArrayList<>();
           }
        
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> findEventsByTypePersonl(boolean isPersonal){
		
        try {
           return entityManager.createQuery("From Event e Where e.type.isPersonal =:isPersonal")
        		   .setParameter("isPersonal", isPersonal).getResultList();
           
        } catch(NoResultException e) {
            return new ArrayList<>();
            }
		
		
		
		
	}
	
	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findEventsByTypeDate(Date date) {
		try {
	           return entityManager.createQuery("From Event e Where e.schedule.date =:date")
	        		   .setParameter("date", date).getResultList();
	           
	        } catch(NoResultException e) {
	            return new ArrayList<>();
	        }
	}
	
}
