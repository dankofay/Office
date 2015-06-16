package logos.office.officeProject.service;

import java.sql.Date;
import java.util.List;

import logos.office.officeProject.model.Event;

public interface EventService {
	 List<Event> findEventsByTypeName(String typeName);
	 List<Event> findEventsByTypePersonl(boolean isPersonal);
	 List<Event> findEventsByTypeDate(Date date);
	 List<Event> getAllEvents();
}
