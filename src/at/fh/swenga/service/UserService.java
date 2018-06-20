package at.fh.swenga.service;


import at.fh.swenga.controller.UserDto;
import at.fh.swenga.model.User;

public interface UserService 
{
	
	void save(UserDto user);
	
	void createGuest();
	
	boolean exists(String nickname);

}
