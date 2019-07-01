package portbooking.controllers;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import portbooking.entities.User;
import portbooking.repository.UserRepository;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/add")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "user/addUser";
	}

	@PostMapping("/add")
	public String saveUser(@ModelAttribute User user) {
		String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPassword);
		userRepository.save(user);
		return "redirect:accountUser/" + user.getId();
	}

	@RequestMapping("/accountUser/{id}")
	public String accountUser(Model model, @PathVariable Long id) {
		model.addAttribute("user", userRepository.findOne(id));
		return "user/accountUser";
	}

	@GetMapping("edit/{id}")
	public String editUser(Model model, @PathVariable Long id) {
		model.addAttribute(userRepository.findOne(id));
		return "user/editUser";
	}

	@PostMapping("edit/{id}")
	public String saveEditedUser(@ModelAttribute User user, @PathVariable Long id) {
		String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPassword);
		userRepository.updateUserSetFirstNameAndLastNameAndEmailAndPassword(id, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
		return "redirect:/user/accountUser/" + id;
	}

	@GetMapping("delete/{id}")
	public String editUser(@PathVariable Long id) {
		userRepository.delete(id);
		return "index";
	}

}
