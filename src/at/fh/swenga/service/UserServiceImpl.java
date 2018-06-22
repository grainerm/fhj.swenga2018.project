package at.fh.swenga.service;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import at.fh.swenga.controller.UserDto;
import at.fh.swenga.model.User;
import at.fh.swenga.repositories.RoleRepository;
import at.fh.swenga.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService 
{	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
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
		user.setAktiv(false);
		user.setRegDate(new Date());
		user.setRole(roleRepo.findByBezeichnung("ROLE_USER"));
		userRepo.save(user);

	}
	
	public void createUsers()
	{
		Date now = new Date();
		User admin = userRepo.findByName("admin");
		if(admin == null)
		{
			admin = new User("admin", "", "", passwordEncoder.encode("password"), true, now);
			admin.setRole(roleRepo.findByBezeichnung("ROLE_ADMIN"));
			userRepo.save(admin);
		}
		User guest = userRepo.findByName("guest");
		if(guest == null)
		{
			guest = new User("guest", "", "", passwordEncoder.encode("password"), true, now);
			guest.setRole(roleRepo.findByBezeichnung("ROLE_GUEST"));
			userRepo.save(guest);
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
		User user = userRepo.findByName(nickname);
		if(user == null)
			return false;
		else
			return true;
	}

}
