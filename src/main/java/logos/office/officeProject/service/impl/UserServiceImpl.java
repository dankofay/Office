package logos.office.officeProject.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import logos.office.officeProject.dao.UserDao;
import logos.office.officeProject.model.User;
import logos.office.officeProject.service.UserService;

@Service
public class UserServiceImpl implements UserService {// по зразку

	@Inject
	private UserDao userDao;

	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllElements();
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
