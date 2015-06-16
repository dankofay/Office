package logos.office.officeProject.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import logos.office.officeProject.dao.RoleDAO;
import logos.office.officeProject.model.Role;
import logos.office.officeProject.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Inject
	private RoleDAO roleDao;

	@Transactional
	public List<Role> findRoleByRoleName(String roleName) {

		return roleDao.findRolebyRoleName(roleName);
	}

}
