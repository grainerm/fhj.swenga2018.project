package at.fh.swenga.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.dao.UserDAO;
import at.fh.swenga.model.User;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService
{
	@Autowired
    private UserDAO userDao;

    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException 
    {
        User user = userDao.getUser(nickname);
        
        if(user == null)
        	throw new UsernameNotFoundException("Kein User mit diesem Namen gefunden!");

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getBezeichnung()));

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPasswort(), user.isAktiv(), true, true, true, grantedAuthorities);
    }

}
