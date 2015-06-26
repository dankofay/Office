package logos.office.officeProject.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import logos.office.officeProject.dao.UserDao;
import logos.office.officeProject.model.Role;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDatailServiceImpl implements UserDetailsService{

	@Inject
	private UserDao userDao;

	@Transactional
	public UserDetails loadUserByUsername(String email) {

		logos.office.officeProject.model.User userEntity = userDao.findByEmail(email);

		if (userEntity == null)
			throw new UsernameNotFoundException("Error in email, or password");

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		for (Role role : userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return new User(userEntity.getId().toString(),
				userEntity.getPassword(), authorities);
	}
	
}
