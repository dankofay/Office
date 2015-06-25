package logos.office.officeProject.dao;

import java.sql.Date;

import logos.office.officeProject.model.Schedule;

public interface ScheduleDao extends ElementDAO<Schedule> {
	Schedule findScheduleByDate(Date date);
}
