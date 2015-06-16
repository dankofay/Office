package logos.office.officeProject.dao;

import logos.office.officeProject.model.User;

public interface UserDao extends ElementDAO<User> {

	User findByName(String name);

	User findByEmail(String email);

}
