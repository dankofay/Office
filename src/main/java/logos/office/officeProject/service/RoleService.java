package logos.office.officeProject.service;
import java.util.List;


import logos.office.officeProject.model.Role;
public interface RoleService {

	List<Role> findRoleByRoleName(String roleName);
}
