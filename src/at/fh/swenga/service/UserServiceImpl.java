package at.fh.swenga.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void save(UserDto userDto)
	{
		User user = new User();
		user.setName(userDto.getNickname());
		user.setPasswort(passwordEncoder.encode(userDto.getPasswort()));
		user.setVorname(userDto.getVorname());
		user.setNachname(userDto.getNachname());
		user.setAktiv(true);
		user.setRole(roleDao.getRole(2));
		userDao.persist(user);

	}
	
	public void createGuest()
	{
		User admin = userDao.getUser("admin");
		if(admin == null)
		{
			admin = new User("admin", "", "", passwordEncoder.encode("password"), true);
			admin.setRole(roleDao.getRole(1));
			userDao.persist(admin);
		}
		User guest = userDao.getUser("guest");
		if(guest == null)
		{
			guest = new User("guest", "", "", passwordEncoder.encode("password"), true);
			guest.setRole(roleDao.getRole(3));
			userDao.persist(guest);
		}
		/*Random rand = new Random();
		int number = rand.nextInt();
		if(exists("guest"+number))
			number = rand.nextInt();
		
		User user = new User();
		user.setName("guest"+number);
		user.setPasswort("");
		user.setVorname("");
		user.setNachname("");
		user.setAktiv(true);
		user.setRole(roleDao.getRole(3));
		userDao.persist(user);*/
		
	}

	public boolean exists(String nickname)
	{
		User user = userDao.getUser(nickname);
		if(user == null)
			return false;
		else
			return true;
	}

}
