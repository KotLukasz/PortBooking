package portbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import portbooking.authentication.AuthenticationService;
import portbooking.authentication.ViewMode;
import portbooking.entity.PortOwner;
import portbooking.entity.User;

@Controller
@RequestMapping("/authentication")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@GetMapping("/loginUser")
	public String loginUser(Model model) {
		model.addAttribute("viewMode", new ViewMode());
		return "authentication/login";
	}


	@PostMapping("/loginUser")
	public String loginUser(@ModelAttribute ViewMode viewMode) {
		if (authenticationService.givenEmailExistInUserDatabase(viewMode.getEmail())) {
			User user = authenticationService.authenticateUser(viewMode.getEmail(), viewMode.getPassword());
			if (user != null) {
				return "redirect:/user/accountUser/" + user.getId();
			}
		}
		return "authentication/incorrectLoginOrPassword";
	}


	@GetMapping("/loginPortOwner")
	public String loginPortOwner(Model model) {
		model.addAttribute("viewMode", new ViewMode());
		return "authentication/login";
	}


	@PostMapping("/loginPortOwner")
	public String loginPortOwner(@ModelAttribute ViewMode viewMode) {
		if (authenticationService.givenEmailExistInPortOwnerDatabase(viewMode.getEmail())) {
			PortOwner portOwner = authenticationService.authenticatePortOwner(viewMode.getEmail(), viewMode.getPassword());
			if (portOwner != null) {
				return "redirect:/portOwner/accountPortOwner/" + portOwner.getId();
			}
		}
		return "authentication/incorrectLoginOrPassword";
	}


}
