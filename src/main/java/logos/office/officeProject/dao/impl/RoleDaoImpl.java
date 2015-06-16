package logos.office.officeProject.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;








import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import logos.office.officeProject.dao.RoleDAO;
import logos.office.officeProject.model.Role;

@Repository
public class RoleDaoImpl extends ElementDAOImpl<Role> implements RoleDAO{

	public RoleDaoImpl() {
		super(Role.class);
	}
@SuppressWarnings("unchecked")
@Transactional
	public List<Role> findRolebyRoleName(String roleName) {
		try {
			return entityManager
					.createQuery("From Role r  Where r.role.name =:roleName")///як вибрати яка роль якому юзеру належить(по first_name, last_name)
					.setParameter("name", roleName).getResultList();
		} catch (NoResultException e) {
			return new ArrayList<>();
		}
	}


}
