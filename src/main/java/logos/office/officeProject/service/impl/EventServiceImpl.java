package logos.office.officeProject.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import logos.office.officeProject.dao.EventDao;
import logos.office.officeProject.dao.ScheduleDao;
import logos.office.officeProject.dao.TypeDao;
import logos.office.officeProject.dao.UserDao;
import logos.office.officeProject.dto.EventDTO;
import logos.office.officeProject.model.Event;
import logos.office.officeProject.model.Schedule;
import logos.office.officeProject.model.Type;
import logos.office.officeProject.model.User;
import logos.office.officeProject.service.EventService;
import logos.office.officeProject.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
	@Inject
	private EventDao eventDao;

	@Inject
	private TypeDao typeDao; // чого воно випендрюється в мене тут?

	@Inject
	private ScheduleDao scheduleDao;

	@Inject
	private UserDao userDao;

	@Inject
	private UserService userService;

	@Transactional
	public List<EventDTO> getAllEventsById(Long id_user) {
		List<EventDTO> edto = new ArrayList<>();

		for (Event ek : eventDao.getAllElements()) {
			Iterator<User> iter = ek.getUsers().iterator();
			while (iter.hasNext()) {
				User i = iter.next();
				if (i.getId() == id_user) {
					edto.add(new EventDTO(ek.getType().getNameType(), ek
							.getSchedule().getDate(), ek.getTimeFrom(), ek
							.getDuration(), ek.getIsConfirmed()));
				}
			}
		}

		return edto;

	}

	@Transactional
	// можна додати подію
	public void saveEvent(Time timeFrom, Time duration, Long typeId, Date date) {

		Type type = typeDao.getElementByID(typeId);
		scheduleDao.addElement(new Schedule(date));
		;
		Schedule schedule = scheduleDao.findScheduleByDate(date);

		eventDao.addElement(new Event(timeFrom, duration, type, schedule,
				false, new ArrayList<User>()));
	}

	@Transactional
	// запит на персональну перерву/// як в дюрекшен поставити іксований
	// час?тобто шоб перерва тривала годин часу
	public void addPersonalBreak(Time timeFrom, Time duration, Date date,
			Long userId) {
		Type type = typeDao.getElementByID((long) 1);
		User user = userService.getUserInfo(userId);
		List<User> list = new ArrayList<User>();
		scheduleDao.addElement(new Schedule(date));
		list.add(user);
		eventDao.addElement(new Event(timeFrom, duration, type, scheduleDao
				.findScheduleByDate(date), false, list));
	}

	@Transactional
	public void addAllUsersToEvent(Date date, String nameType) {
		List<User> list = new ArrayList<User>();
		for (User u : userDao.getAllElements()) {
			list.add(u);
		}
		for (Event ev : eventDao.getAllElements()) {
			if (ev.getSchedule().getDate().equals(date)
					&& ev.getType().getNameType().equalsIgnoreCase(nameType)) {
				ev.getUsers().addAll(list);
			}
		}

	}

	@Transactional
	// додати юзера до події
	public void addUsersToEvent(Date date, String nameType, Long idUser) {
		List<User> list = new ArrayList<User>();
		for (User u : userDao.getAllElements()) {
			if (u.getId() == idUser) {
				list.add(u);
			}
		}
		for (Event ev : eventDao.getAllElements()) {
			if (ev.getSchedule().getDate().equals(date)
					&& ev.getType().getNameType().equalsIgnoreCase(nameType)) {
				ev.getUsers().addAll(list);
			}
		}

	}

	@Transactional

	public List<Event> findEventsByTypeName(String typeName) {

		return eventDao.findEventsByTypeName(typeName);
	}

	@Transactional

	public List<Event> getAllEvents() {

		return eventDao.getAllElements();
	}

}
