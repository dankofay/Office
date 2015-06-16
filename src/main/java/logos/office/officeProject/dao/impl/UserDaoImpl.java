package logos.office.officeProject.dao.impl;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import logos.office.officeProject.dao.UserDao;
import logos.office.officeProject.model.User;

@Repository
public class UserDaoImpl extends ElementDAOImpl<User> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@Transactional
	public User findByEmail(String email) {
		try {
			return (User) entityManager
					.createQuery("From user u where u.email =:email")
					.setParameter("email", email).getSingleResult();
		} catch (NoResultException e) {
			return new User();
		}
	}

	@Transactional
	public User findByName(String name) {
		try {
			return (User) entityManager
					.createQuery("From user u where u.userName = :name")
					.setParameter("name", name).getSingleResult();
		} catch (NoResultException e) {
			return new User();
		}
	}

}

// package com.office.logos.dao.impl;
//
// import javax.persistence.NoResultException;
//
// import org.hibernate.Session;
// import org.springframework.transaction.annotation.Transactional;
//
// import com.office.logos.dao.UserDao;
// import com.office.logos.model.User;
//
// public class UserDaoImpl extends ElementDAOImpl<User> implements UserDao{
//
// public UserDaoImpl() {
// super(User.class);
//
// }
//
// @Transactional
// public User findByEmail(String email) {
// try {
// return (User) entityManager
// .createNamedQuery("From user u where u.email =:email")
// .setParameter("email", email).getSingleResult();
// } catch (NoResultException e) {
// return new User();
// }
//
//
//
// return user;
// }
// @Transactional
// public User findByName(String name) {
// Session session = null;
// User user = null;
// try{
// return (User) entityManager
// .createNamedQuery("From user u where u.userName = :name")
// .setParameter("name", name).getSingleResult();
// } catch (NoResultException e) {
// return new User();
// }
//
// return user;
//
// }
//
// }

// package com.office.logos.dao.impl;
//
// import javax.persistence.NoResultException;
//
// import org.springframework.transaction.annotation.Transactional;
//
// import com.office.logos.dao.UserDao;
// import com.office.logos.model.User;
//
// public class UserDaoImpl extends ElementDAOImpl<User> implements UserDao {
//
// public UserDaoImpl() {
// super(User.class);
//
// }
// public User findUserByEmail(String email) {
// Session session = null;
// User user = null;
// try{
// HibernateUtil.getSessionFactory().openSession();
// user = (User) session.createQuery("From user u where u.email =:email")
// .setParameter("email", email).uniqueResult();
// }finally{
// if((session != null) && (session.isOpen())){
// session.close();
// }
// }
// return user;
// }
// @Transactional
// public User findByEmail(String email) {
// try {
// return (User) entityManager
// .createNamedQuery("From user u where u.email =:email")
// .setParameter("email", email).getSingleResult();
// } catch (NoResultException e) {
// return new User();
// }
// }
// public User findUserByEmail(String email) {
// Session session = null;
// User user = null;
// try{
// HibernateUtil.getSessionFactory().openSession();
// user = (User) session.createQuery("From user u where u.email =:email")
// .setParameter("email", email).uniqueResult();
// }finally{
// if((session != null) && (session.isOpen())){
// session.close();
// }
// }
// return user;
// }

