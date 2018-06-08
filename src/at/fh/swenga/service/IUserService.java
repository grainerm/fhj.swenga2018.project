package at.fh.swenga.service;

import at.fh.swenga.controller.UserDto;
import at.fh.swenga.model.User;

public interface IUserService 
{
	User registerNewUserAccount(UserDto accountDto);

}
