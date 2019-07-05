package portbooking.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import portbooking.entity.PortOwner;
import portbooking.repository.PortOwnerRepository;

import javax.validation.Valid;
import javax.validation.Validator;


@Controller
@RequestMapping("/portOwner")
public class PortOwnerController {

	@Autowired
	private PortOwnerRepository portOwnerRepository;

	@Autowired
	Validator validator;

	@GetMapping("/add")
	public String addPortOwner(Model model) {
		model.addAttribute("portOwner", new PortOwner());
		return "portOwner/addOrEditPortOwner";
	}

	@PostMapping("/add")
	public String savePortOwner(@ModelAttribute("portOwner") @Valid PortOwner portOwner, BindingResult result) {
		if (result.hasErrors()) {
			return "portOwner/addOrEditPortOwner";
		}
		String hashedPassword = BCrypt.hashpw(portOwner.getPassword(), BCrypt.gensalt());
		portOwner.setPassword(hashedPassword);
		portOwnerRepository.save(portOwner);
		return "redirect:accountPortOwner/" + portOwner.getId();
	}

	@RequestMapping("/accountPortOwner/{id}")
	public String accountPortOwner(Model model, @PathVariable Long id) {
		model.addAttribute("portOwner", portOwnerRepository.findOne(id));
		return "portOwner/accountPortOwner";
	}

	@GetMapping("edit/{id}")
	public String editPortOwner(Model model, @PathVariable Long id) {
		model.addAttribute(portOwnerRepository.findOne(id));
		return "portOwner/addOrEditPortOwner";
	}

	@PostMapping("edit/{id}")
	public String saveEditedPortOwner(@ModelAttribute("portOwner") @Valid PortOwner portOwner, BindingResult result, @PathVariable Long id) {
		if (result.hasErrors()) {
			return "portOwner/addOrEditPortOwner";
		}
		String hashedPassword = BCrypt.hashpw(portOwner.getPassword(), BCrypt.gensalt());
		portOwner.setPassword(hashedPassword);
		portOwnerRepository.updateUserSetFirstNameAndLastNameAndEmailAndPassword(id, portOwner.getFirstName(), portOwner.getLastName(), portOwner.getEmail(), portOwner.getPassword());
		return "redirect:/portOwner/accountPortOwner/" + id;
	}

	@GetMapping("delete/{id}")
	public String editPortOwner(@PathVariable Long id) {
		portOwnerRepository.delete(id);
		return "index";
	}

}
