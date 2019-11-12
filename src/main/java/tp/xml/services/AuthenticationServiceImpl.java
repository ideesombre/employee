package tp.xml.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserService userService;
	
	
	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public boolean authenticate(String login, String password) {
		return password.equals(userService.getpassword("michel")); // && password.equals("admin");
	}

}
