package logos.office.officeProject.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;

import logos.office.officeProject.dao.ElementDAO;


public class ElementDAOImpl<E> implements ElementDAO<E> {

	private Class<E> elementClass;

	public ElementDAOImpl(Class<E> elementClass) {
		this.elementClass = elementClass;
	}

	@PersistenceContext(name = "OfficeProject")
	EntityManager entityManager;

	@Transactional
	public void addElement(E element) {
		entityManager.persist(element);
		entityManager.flush();
	}

	@Transactional
	public void updateElement(E element) {
		entityManager.merge(element);
	}

	@Transactional
	public void deleteElement(E element) {
		entityManager.remove(entityManager.merge(element));
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public E getElementByID(Long elementId) {
		try {
			return (E) entityManager
					.createQuery(
							"select e from " + elementClass.getSimpleName()
									+ " e where e.id = :id")
					.setParameter("id", elementId).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> getAllElements() {
		return entityManager
				.createQuery("from " + elementClass.getSimpleName())
				.getResultList();

	}
}