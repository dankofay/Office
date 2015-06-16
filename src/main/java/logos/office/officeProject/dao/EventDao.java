package logos.office.officeProject.dao;

import java.sql.Date;
import java.util.List;

import logos.office.officeProject.model.Event;

public interface EventDao extends ElementDAO<Event>{

	List<Event> findEventsByTypeName(String typeName);
	List<Event> findEventsByTypePersonl(boolean isPersonal);
	List<Event> findEventsByTypeDate(Date date);
}
