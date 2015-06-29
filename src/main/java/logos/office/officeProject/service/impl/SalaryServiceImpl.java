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

///�� ����� �����,�� ����� �������� SalaryDTO, �� �������� ��������� ������, �� ������ � ���������
@Service
public class SalaryServiceImpl implements SalaryService {
	@Inject
	private SalaryDAO salaryDao;
	@Inject
	private UserDao userDao;
	@Inject
	private RateDAO rateDao;
	private Integer actualHours;
	private static final Integer workingHours = 198;

	
	@Transactional// ����� �������� �� ���� - ������ �������� �������� ����� 
	public List<SalaryDTO> findSalaryByUserId(long id) {
		List<SalaryDTO> sdtos = new ArrayList<>();
		User user = userDao.getElementByID(id);
		Integer rateVal;
		List<String> roles = new ArrayList<>();
		for (Role role : user.getRoles()) {
			roles.add(role.getName());
			Rate rate = rateDao.findRateByUserRole(role);
			if (rate != null) {
				rateVal = rate.getValue();
				for (Salary salary : user.getSalaries()) {
					Integer salaryVal = salary.getValue() * rateVal;
					sdtos.add(new SalaryDTO((user.getFirstName() + " " + user
							.getLastName()), salaryVal, roles));
				}
			}

		}
		return sdtos;

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

	@Transactional
	// ��������� �������� - ����� �����, ������� �� ���� � ����� �������
	// ����������,
	// ���� ����, �� ������ �� ���������� ������� ���� ������� ��������
	// �-�� �����.����� ���� ����, ������� �� �������,
	// �������� �������� ������� �� �������� ��������(������� �� �������������
	// �����), ������� �� ��� SalaryDTO.
	public List<SalaryDTO> createSalary(long userId, Date from, Date to) {
		User user = userDao.getElementByID(userId);
		List<SalaryDTO> sdtos = new ArrayList<>();
		actualHours = workingHours;
		for (Event event : user.getEvents()) {

			if (from.before(event.getSchedule().getDate())
					&& to.after(event.getSchedule().getDate())) {
				// ���� ����� ������������ � ������������ � ��� ������ ��
				// ����� ��� ������ Personal Break,�� ������� ��� -1 ���
				if (event.getType().isPersonal()
						&& event.isConfirmed2()
						&& event.getType().getEvets()
								.contains("Personal Break")) {
					actualHours = actualHours - 1;
					Integer rateVal;
					List<String> roles = new ArrayList<>();
					for (Role role : user.getRoles()) {
						roles.add(role.getName());
						Rate rate = rateDao.findRateByUserRole(role);
						if (rate != null) {
							rateVal = rate.getValue();
							for (Salary salary : user.getSalaries()) {
								Integer salaryVal = salary.getValue() * rateVal;
								Integer salarySum = salaryVal * actualHours;
								sdtos.add(new SalaryDTO((user.getFirstName()
										+ " " + user.getLastName()), salarySum,
										roles));
							}
						}
					}
				}
				// ���� ��� ������, �� -5 ����� �� ��� ����
				if (event.getType().isPersonal() && event.isConfirmed2()
						&& event.getType().getEvets().contains("Sick")) {
					actualHours = actualHours - 5;
					Integer rateVal;
					List<String> roles = new ArrayList<>();
					for (Role role : user.getRoles()) {
						roles.add(role.getName());
						Rate rate = rateDao.findRateByUserRole(role);
						if (rate != null) {
							rateVal = rate.getValue();
							for (Salary salary : user.getSalaries()) {
								Integer salaryVal = salary.getValue() * rateVal;
								Integer salarySum = salaryVal * actualHours;
								sdtos.add(new SalaryDTO((user.getFirstName()
										+ " " + user.getLastName()), salarySum,
										roles));
							}
						}
					}
				}
				// ���� ����������� ������� �� �����������, �� ������������
				// ������, ����� -8 �����
				if (event.getType().isPersonal()
						&& event.isConfirmed2() == false) {
					actualHours = actualHours - 8;
					Integer rateVal;
					List<String> roles = new ArrayList<>();
					for (Role role : user.getRoles()) {
						roles.add(role.getName());
						Rate rate = rateDao.findRateByUserRole(role);
						if (rate != null) {
							rateVal = rate.getValue();
							for (Salary salary : user.getSalaries()) {
								Integer salaryVal = salary.getValue() * rateVal;
								Integer salarySum = salaryVal * actualHours;
								sdtos.add(new SalaryDTO((user.getFirstName()
										+ " " + user.getLastName()), salarySum,
										roles));
							}
						}
					}
				}

				// ���� ��� ���������� ��� ����, �� ����� �� ���������
				// ������� ����
				if (event.getType().isPersonal() && event.isConfirmed2()
						&& event.getType().getEvets().contains("Meeting")
						|| event.getType().getEvets().contains("Corporative")) {
					Integer rateVal;
					List<String> roles = new ArrayList<>();
					for (Role role : user.getRoles()) {
						roles.add(role.getName());
						Rate rate = rateDao.findRateByUserRole(role);
						if (rate != null) {
							rateVal = rate.getValue();
							for (Salary salary : user.getSalaries()) {
								Integer salaryVal = salary.getValue() * rateVal;
								Integer salarySum = salaryVal * actualHours;
								sdtos.add(new SalaryDTO((user.getFirstName()
										+ " " + user.getLastName()), salarySum,
										roles));
							}
						}
					}
				}
			}
		}
		return sdtos;
	}

	@Transactional
	public List<Salary> getAllSalarys() {
		return salaryDao.getAllElements();

	}

}