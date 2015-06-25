package logos.office.officeProject.dao;

import logos.office.officeProject.model.Type;

public interface TypeDao extends ElementDAO<Type> {
	
	Type findByEmail(String name);

	Type findByEmail(boolean isPersonal);
}
