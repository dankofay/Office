package logos.office.officeProject.service;

import java.util.Date;
import java.util.List;

import logos.office.officeProject.dto.SalaryDTO;
import logos.office.officeProject.model.Salary;

public interface SalaryService {

	List<SalaryDTO> getAllSalarys();

	List<SalaryDTO> findSalaryByUserId(Long id);
	
	//SalaryDTO findSalaryByUserId(long id);
	List<Salary> findSalaryByUserByTimeDuration(Long id, String from, String to);

	List<SalaryDTO> createSalary(Long userId, Date from, Date to);
}
