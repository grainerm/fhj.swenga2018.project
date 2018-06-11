package at.fh.swenga.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fh.swenga.controller.UserDto;
import at.fh.swenga.dao.RoleDAO;
import at.fh.swenga.dao.UserDAO;
import at.fh.swenga.model.User;

@Service
public class UserServiceImpl implements UserService 
{	
	@Autowired
	private UserDAO userDao;
	@Autowired
	private RoleDAO roleDao;

	@Override
	public void save(UserDto userDto) 
	{
		User user = userDao.getUser(userDto.getNickname());
		if(user == null)
		{
			user = new User();
			user.setName(userDto.getNickname());
			user.setPasswort(userDto.getPasswort());
			user.setVorname(userDto.getVorname());
			user.setNachname(userDto.getNachname());
			user.setAktiv(false);
			user.setRole(roleDao.getRole(1));
			userDao.persist(user);
		}
	}



}
