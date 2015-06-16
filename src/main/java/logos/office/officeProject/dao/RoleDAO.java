package logos.office.officeProject.dao;

import java.util.List;

import logos.office.officeProject.model.Role;


public interface RoleDAO extends ElementDAO<Role>{

	List<Role>findRolebyRoleName (String roleName);
}
