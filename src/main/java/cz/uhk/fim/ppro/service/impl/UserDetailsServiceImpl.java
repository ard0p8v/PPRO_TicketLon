package cz.uhk.fim.ppro.service.impl;

import cz.uhk.fim.ppro.dao.IUserDao;
import cz.uhk.fim.ppro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	 @Autowired
	 private IUserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userDao.findByUsername(username);
		if(u == null)  {
			throw new UsernameNotFoundException("Uzivatel se nenalezl");
		}
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(u.getRole().getRoleName());

		return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), Collections.singleton(grantedAuthority));
    }
	
}
