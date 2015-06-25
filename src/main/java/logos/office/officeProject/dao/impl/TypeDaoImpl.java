package logos.office.officeProject.dao.impl;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import logos.office.officeProject.dao.TypeDao;
import logos.office.officeProject.model.Type;
import logos.office.officeProject.model.User;

@Repository
public class TypeDaoImpl extends ElementDAOImpl<Type> implements TypeDao{

	public TypeDaoImpl() {
		super(Type.class);
		
	}
	@Transactional
	public Type findByEmail(String name) {
		try {
			return (Type) entityManager
					.createQuery("From type t where t.nameType =:name")
					.setParameter("name", name).getSingleResult();
		} catch (NoResultException e) {
			return new Type();
		}
	}
	@Transactional
	public Type findByEmail(boolean isPersonal) {
		try {
			return (Type) entityManager
					.createQuery("From type t where t.isPersonal =:isPersonal")
					.setParameter("isPersonal", isPersonal).getSingleResult();
		} catch (NoResultException e) {
			return new Type();
		}
	}
	
}
