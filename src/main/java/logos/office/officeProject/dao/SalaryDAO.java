package logos.office.officeProject.dao;

import java.util.Date;
import java.util.List;

import logos.office.officeProject.model.*;

public interface SalaryDAO extends ElementDAO<Salary> {

	List<Salary> getSalaryByUserId(long id);

	List<Salary> getSalaryByUserByTimeDuration(long id, Date from, Date to);

}
