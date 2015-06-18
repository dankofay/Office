package logos.office.officeProject.service;


import java.util.List;

import logos.office.officeProject.dto.UserDTO;
import logos.office.officeProject.model.User;



public interface UserService {
	
	
	List<UserDTO> getAllUsers();
	 
    User getUserInfo(long userId);
	
	void saveUser(String first_Name, String last_Name, Integer age, String email, String password);
	
	User getUserInfoByEmail(String email);
	
}