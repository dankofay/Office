package logos.office.officeProject.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import logos.office.officeProject.dto.EventDTO;
import logos.office.officeProject.model.Event;

public interface EventService {
	 List<Event> findEventsByTypeName(String typeName);
	 List<Event> getAllEvents();
	 void addAllUsersToEvent(Date date, String nameType);
	 void addPersonalBreak(Time timeFrom, Time duration, Date date,
				Long userId);
	 void saveEvent(Time timeFrom, Time duration, Long typeId, Date date);
	 void addUsersToEvent(Date date, String nameType,Long idUser);
	 List<EventDTO> getAllEventsById(Long id_user);
}
