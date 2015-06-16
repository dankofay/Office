package logos.office.officeProject.service.impl;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import logos.office.officeProject.dao.EventDao;
import logos.office.officeProject.model.Event;
import logos.office.officeProject.service.EventService;


@Service
public class EventServiceImpl implements EventService {
	@Inject
	private EventDao eventDao;

	@Transactional
	public List<Event> getAllEvents() {
		return eventDao.getAllElements();

	}
	
	
	@Transactional
	public List<Event> findEventsByTypeName(String typeName) {
		return eventDao.findEventsByTypeName(typeName);

	}

	@Transactional
	public List<Event> findEventsByTypePersonl(boolean isPersonal) {
		return eventDao.findEventsByTypePersonl(isPersonal);
	}

	@Transactional
	public List<Event> findEventsByTypeDate(Date date) {
		
		return eventDao.findEventsByTypeDate(date);
	}

}
