package at.fh.swenga.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.dao.UserDAO;
import at.fh.swenga.model.User;

public class UserDetailsServiceImpl implements UserDetailsService
{
	@Autowired
    private UserDAO userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException 
    {
    	System.out.println("________________________________"+ nickname);
        User user = userDao.getUser(nickname);
        
        if(user == null)
        	throw new UsernameNotFoundException("Kein User mit diesem Namen gefunden!");

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getBezeichnung()));
  

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPasswort(), grantedAuthorities);
    }

}
