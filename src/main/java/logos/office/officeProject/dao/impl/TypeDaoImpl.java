package logos.office.officeProject.dao.impl;

import org.springframework.stereotype.Repository;

import logos.office.officeProject.dao.TypeDao;
import logos.office.officeProject.model.Type;

@Repository
public class TypeDaoImpl extends ElementDAOImpl<Type> implements TypeDao{

	public TypeDaoImpl() {
		super(Type.class);
		
	}

}
