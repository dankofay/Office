package logos.office.officeProject.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import

java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import

javax.transaction.Transactional;

import logos.office.officeProject.dao.RateDAO;
import logos.office.officeProject.dao.RoleDAO;
import

logos.office.officeProject.dao.SalaryDAO;
import logos.office.officeProject.dao.UserDao;
import

logos.office.officeProject.dto.SalaryDTO;
import logos.office.officeProject.model.Event;
import logos.office.officeProject.model.Rate;
import

logos.office.officeProject.model.Role;
import logos.office.officeProject.model.Salary;
import

logos.office.officeProject.model.User;
import logos.office.officeProject.service.SalaryService;

import

org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {
	@Inject
	private SalaryDAO salaryDao;
	@Inject
	private UserDao userDao;
	@Inject
	private RateDAO rateDao;

	private Integer actualHours;
	private static final Integer workingHours = 160;// static final Integer

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

		return salaryDao.getSalaryByUserByTimeDuration(id,

		dateFrom, dateTo);
	}

	
	@Transactional//Створення зарплати - берем юзера, дивимся чи були в нього перерви персональні, 
	//якшо були, то віднімаєм від загального робЧасу його перерви отримуємо к-ть годин.берем його роль, дивимся на рейтинг, 
	//значення рейтинга множимо на значення зарплати(залежно від реальновідпрац годин), передаєм це все SalaryDTO.
	public List<SalaryDTO> createSalary(long userId, Date from, Date to) {
		User user = userDao.getElementByID(userId);
		List<SalaryDTO> sdtos = new ArrayList<>();
		for (Event event : user.getEvents()) {

			if (from.before(event.getSchedule().getDate()) && 
					to.after(event.getSchedule().getDate())) {
				if (event.getType().isPersonal()) {
					actualHours = workingHours - event.getDuration();// Duration в Integer
					Integer rateVal;
					List<String> roles = new ArrayList<>();
					for (Role role : user.getRoles()) {
						roles.add(role.getName());
						Rate rate = rateDao.findRateByUserRole(role);
						if (rate != null) {
							rateVal = rate.getValue();
							for (Salary salary : user.getSalaries()) {
								Integer salaryVal;
								Integer salarySum;
								if (salaryVal != 0) {
									salaryVal = salary.getValue() * rateVal;
									salarySum = salaryVal * actualHours;
									sdtos.add(new SalaryDTO((user.getFirstName() + " " + user.getLastName()), salarySum, roles));
								}
							}
						}
					}
				}

				return sdtos;

			}
		}
	}

	@Transactional
	public List<Salary> getAllSalarys() {
		return
		salaryDao.getAllElements();

	}
}