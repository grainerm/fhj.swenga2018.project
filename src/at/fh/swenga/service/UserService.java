package at.fh.swenga.service;


import at.fh.swenga.controller.UserDto;

public interface UserService 
{
	
	void save(UserDto user);
	
	boolean exists(String nickname);

}
