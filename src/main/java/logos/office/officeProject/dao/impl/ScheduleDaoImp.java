package logos.office.officeProject.dao.impl;

import org.springframework.stereotype.Repository;

import logos.office.officeProject.dao.ScheduleDao;
import logos.office.officeProject.model.Schedule;

@Repository
public class ScheduleDaoImp extends ElementDAOImpl<Schedule> implements ScheduleDao{


	public ScheduleDaoImp() {
		super(Schedule.class);
		
	}

}
