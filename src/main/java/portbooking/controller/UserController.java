package portbooking.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import portbooking.entity.User;
import portbooking.repository.UserRepository;

import javax.validation.Valid;
import javax.validation.Validator;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	Validator validator;

	@GetMapping("/add")
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "user/addOrEditUser";
	}

	@PostMapping("/add")
	public String saveUser(@ModelAttribute("user") @Valid  User user, BindingResult result) {
		if (result.hasErrors()) {
			return "user/addOrEditUser";
		}
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
		return "user/addOrEditUser";
	}

	@PostMapping("edit/{id}")
	public String saveEditedUser(@ModelAttribute("user") @Valid User user, BindingResult result, @PathVariable Long id) {
		if (result.hasErrors()) {
			return "user/addOrEditUser";
		}
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
