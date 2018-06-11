package at.fh.swenga.service;


import at.fh.swenga.controller.UserDto;

public interface UserService 
{
	
	void save(UserDto user);

	/*@Autowired
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
    }*/

}
