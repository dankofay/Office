package logos.office.officeProject.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import logos.office.officeProject.dao.EventDao;
import logos.office.officeProject.dao.ScheduleDao;
import logos.office.officeProject.dao.TypeDao;
import logos.office.officeProject.dto.EventDTO;
import logos.office.officeProject.model.Event;
import logos.office.officeProject.model.Type;
import logos.office.officeProject.model.User;
import logos.office.officeProject.service.EventService;

@Service
public class EventServiceImpl implements EventService {
	@Inject
	private EventDao eventDao;

	@Inject
	private TypeDao typeDao;

	@Inject
	private ScheduleDao scheduleDao;

	@Transactional
	public List<EventDTO> getAllEventsByIdUser(String email) {
		List<EventDTO> edto = new ArrayList<>();
		UserServiceImpl us = new UserServiceImpl();
		Long id_user = us.idUserByEmail(email);
		for (Event ek : eventDao.getAllElements()) {
			Iterator<User> iter = ek.getUsers().iterator();
			while (iter.hasNext()) {
				User i = iter.next();
				if (i.getId() == id_user) {
					edto.add(new EventDTO(ek.getType().getNameType(), ek
							.getSchedule().getDate(), ek.getTimeFrom(), ek
							.getDuration()));
				}
			}
		}return edto;

	}

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

	@Override
	public List<EventDTO> getAllEventsByIdUser(Long id_user) {
		// TODO Auto-generated method stub
		return null;
	}

}
