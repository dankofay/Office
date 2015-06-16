package logos.office.officeProject.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import logos.office.officeProject.dao.SalaryDAO;
import logos.office.officeProject.model.Salary;
import logos.office.officeProject.service.SalaryService;

@Service
public class SalaryServiceImpl implements SalaryService {
	@Inject
	private SalaryDAO salaryDao;

	@Transactional
	public List<Salary> getAllSalarys() {

		return salaryDao.getAllElements();
	}

	@Transactional
	public List<Salary> findSalaryByUserId(long id) {

		return salaryDao.getSalaryByUserId(id);

	}

	@Transactional
	public List<Salary> findSalaryByUserByTimeDuration(long id, String from,
			String to) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFrom = null;
		Date dateTo = null;
		try {
			dateFrom = sdf.parse(from);
			dateTo = sdf.parse(to);
		} catch (ParseException e) {
			e.printStackTrace();
			dateFrom = new Date();
			dateTo = new Date();
		}

		return salaryDao.getSalaryByUserByTimeDuration(id, dateFrom, dateTo);
	}

}
