package logos.office.officeProject.service;

import java.util.Date;
import java.util.List;

import logos.office.officeProject.dto.SalaryDTO;
import logos.office.officeProject.model.Salary;

public interface SalaryService {

	List<Salary> getAllSalarys();

	List<Salary> findSalaryByUserId(long id);

	List<Salary> findSalaryByUserByTimeDuration(long id, String from, String to);

	//List<SalaryDTO> createSalary(long userId, Date from, Date to);
}
