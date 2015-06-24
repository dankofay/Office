package logos.office.officeProject.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import logos.office.officeProject.dto.EventDTO;
import logos.office.officeProject.model.Event;

public interface EventService {
	 List<Event> findEventsByTypeName(String typeName);
	 List<Event> findEventsByTypePersonl(boolean isPersonal);
	 List<Event> findEventsByTypeDate(Date date);
	 List<Event> getAllEvents();
	 List<EventDTO> getAllEventsByIdEmail(String email);
	 void saveEvent(Time timeFrom,Time duration,String nameType,boolean isPersonal,Date date,
				boolean isConfirmed);
	 void addPersonalBreak(Time timeFrom,Time duration,Date date,String email);
	 void addAllUsersToEvent(Date date,String nameType);
}
