package logos.office.officeProject.service.impl;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

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

@Service
public class EventServiceImpl implements EventService {
	@Inject
	private EventDao eventDao;

	@Inject
	private TypeDao typeDao;  //чого воно випендрюється в мене тут?

	@Inject
	private ScheduleDao scheduleDao;
@Inject
private UserDao userDao;
	
	@Transactional//  по запиту юзера видати йому всі події в яких він приймав чи приймає участь..  тобто шоб запит йшов по його милу
	public List<EventDTO> getAllEventsByIdEmail(String email) {
		List<EventDTO> edto = new ArrayList<>();
		UserServiceImpl us = new UserServiceImpl();
		Long id_user = us.idUserByEmail(email);
		for (Event ek : eventDao.getAllElements()) {
			Iterator<User> iter = ek.getUsers().iterator();
			while (iter.hasNext()) {
				User i = iter.next();
				if (i.getId() == id_user) {
					edto.add(new EventDTO(ek.getType().getNameType(),ek.getSchedule().getDate(), ek.getTimeFrom(),
							ek.getDuration(), ek.isConfirmed2()));
				}
			}
		}return edto;

	}
	@Transactional// можна додати подію
	public void saveEvent(Time timeFrom,Time duration,String nameType,boolean isPersonal,Date date,
			boolean isConfirmed){
		eventDao.addElement(new Event(timeFrom, duration, new Type(nameType, isPersonal),new Schedule(date), isConfirmed, new ArrayList<User>()));
	}
	@Transactional// запит на персональну перерву///   як в дюрекшен поставити іксований час?тобто шоб перерва тривала годин часу
	public void addPersonalBreak(Time timeFrom,Time duration,Date date,String email){
		UserServiceImpl userImpl=new UserServiceImpl();
		User user=userImpl.getUserInfoByEmail(email);
		List<User>list=new ArrayList<User>();
		list.add(user);  
		eventDao.addElement(new Event(timeFrom, duration, new Type("Personal Break", true),new Schedule(date), false,list));
	}
	@Transactional
	public void addAllUsersToEvent(Date date,String nameType){
		List<User>list=new ArrayList<User>();
		for (User user : userDao.getAllElements()) {
			list.add(user);
		}
		for (Event ev : eventDao.getAllElements()) {
			if(ev.getSchedule().getDate().equals(date) && ev.getType().getNameType().equalsIgnoreCase(nameType)){
				ev.getUsers().addAll(list);
			}
		}
		
	}
	
	
}
