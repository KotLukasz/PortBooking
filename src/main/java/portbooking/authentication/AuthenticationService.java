package portbooking.authentication;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portbooking.entities.PortOwner;
import portbooking.entities.User;
import portbooking.repository.PortOwnerRepository;
import portbooking.repository.UserRepository;

@Service
public class AuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PortOwnerRepository portOwnerRepository;

	public boolean givenEmailExistInUserDatabase(String email) {
		User user = userRepository.findByEmail(email);
		if(user != null) {
			return true;
		}
		return false;
	}

	public User authenticateUser (String email, String password) {
		User user = userRepository.findByEmail(email);
		boolean equalPassword = BCrypt.checkpw(password, user.getPassword());
		if (equalPassword) {
			return user;
		}
		return null;
	}

	public boolean givenEmailExistInPortOwnerDatabase(String email) {
		PortOwner portOwner = portOwnerRepository.findByEmail(email);
		if(portOwner != null) {
			return true;
		}
		return false;
	}

	public PortOwner authenticatePortOwner(String email, String password) {
		PortOwner portOwner = portOwnerRepository.findByEmail(email);
		boolean equalPassword = BCrypt.checkpw(password, portOwner.getPassword());
		if (equalPassword) {
			return portOwner;
		}
		return null;
	}

}
