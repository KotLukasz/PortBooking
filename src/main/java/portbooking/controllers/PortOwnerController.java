package portbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import portbooking.entities.PortOwner;
import portbooking.repository.PortOwnerRepository;


@Controller
@RequestMapping("/portOwner")
public class PortOwnerController {

	@Autowired
	private PortOwnerRepository portOwnerRepository;

	@GetMapping("/add")
	public String addPortOwner(Model model) {
		model.addAttribute("portOwner", new PortOwner());
		return "portOwner/addPortOwner";
	}

	@PostMapping("/add")
	public String savePortOwner(@ModelAttribute PortOwner portOwner) {
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
		return "portOwner/editPortOwner";
	}

	@PostMapping("edit/{id}")
	public String saveEditedPortOwner(@ModelAttribute PortOwner portOwner, @PathVariable Long id, Model model) {
		portOwnerRepository.updateUserSetFirstNameAndLastNameAndEmailAndPassword(id, portOwner.getFirstName(), portOwner.getLastName(), portOwner.getEmail(), portOwner.getPassword());
		model.addAttribute("id", id);
		return "portOwner/editSuccessPortOwner";
	}

	@GetMapping("delete/{id}")
	public String editPortOwner(@PathVariable Long id) {
		portOwnerRepository.delete(id);
		return "portOwner/deletePortOwner";
	}

}
