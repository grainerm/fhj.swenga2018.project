package at.fh.swenga.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import at.fh.swenga.controller.UserDto;
import at.fh.swenga.dao.UserDAO;
import at.fh.swenga.model.Role;
import at.fh.swenga.model.User;

@Service
public class UserService implements IUserService 
{
	@Autowired
    private UserDAO userDao; 
     
    @Transactional
    @Override
    public User registerNewUserAccount(UserDto accountDto) 
    {
        if (nicknameExists(accountDto.getNickname())) 
        {  
            // TODO Excpetion 	
        }
        User user = new User(accountDto.getNickname(), accountDto.getVorname(), accountDto.getNachname(), accountDto.getPasswort(), false, 0, 0, 0, null, 'm');
    	//user.setRole();
    	return user; 
    }
    private boolean nicknameExists(String nickname) {
        User user = userDao.getUser(nickname);
        if (user != null) {
            return true;
        }
        return false;
    }

}
