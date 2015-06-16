package logos.office.officeProject.service;

import java.util.List;

import logos.office.officeProject.model.Salary;

public interface SalaryService {

	List<Salary> getAllSalarys();

	List<Salary> findSalaryByUserId(long id);

	List<Salary> findSalaryByUserByTimeDuration(long id, String from, String to);

}
