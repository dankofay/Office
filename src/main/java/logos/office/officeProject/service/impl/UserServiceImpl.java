package logos.office.officeProject.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import logos.office.officeProject.dao.RateDAO;
import logos.office.officeProject.dao.UserDao;
import logos.office.officeProject.dto.UserDTO;
import logos.office.officeProject.model.Rate;
import logos.office.officeProject.model.Role;
import logos.office.officeProject.model.User;
import logos.office.officeProject.service.UserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {// по зразку

	@Inject
	private UserDao userDao;
	@Inject
	private RateDAO rateDao;

	@Transactional
	public Long idUserByEmail(String email){
		long id=0;
		for (User u : userDao.getAllElements()) {
			if(u.getEmail().equals(email)){
				id=u.getId();
			}
		}
		return id;	
	}
	
	
	
	@Transactional
	public List<UserDTO> getAllUsers() {
		List<UserDTO> dtos = new ArrayList<>();
		for (User user : userDao.getAllElements()) {

			List<String> roles = new ArrayList<>();
			Integer rateVal = 0;
			for (Role role : user.getRoles()) {
				roles.add(role.getName());

				Rate rate = rateDao.findRateByUserRole(role);

				if (rate != null) {
					rateVal = rate.getValue();
				}

			}

			dtos.add(new UserDTO(
					user.getFirstName() + " " + user.getLastName(), user
							.getAge(), user.getEmail(), roles, rateVal));

		}

		return dtos;
	}

	@Transactional
	public User getUserInfo(long userId) {
		User user = userDao.getElementByID(userId);
		if (user != null) {
			return user;
		} else {
			return new User();
		}
	}

	@Transactional
	public void saveUser(String first_Name, String last_Name, Integer age,
			String email, String password) {
		userDao.addElement(new User(first_Name, last_Name, age, email, password));
	}

	@Transactional
	public User getUserInfoByEmail(String email) {
		User user = userDao.findByEmail(email);
		if (user != null) {
			return user;
		} else {
			return new User();
		}
	}
}
