package portbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import portbooking.entities.Port;
import portbooking.entities.User;
import portbooking.repository.PortOwnerRepository;
import portbooking.repository.PortRepository;

@Controller
@RequestMapping("/port")
public class PortController {

	@Autowired
	private PortOwnerRepository portOwnerRepository;

	@Autowired
	private PortRepository portRepository;

	@GetMapping("/addPort/{id}")
	public String addPort(Model model, @PathVariable long id) {
		model.addAttribute("port", new Port());
		model.addAttribute("owner", portOwnerRepository.findOne(id));
		return "port/addPort";
	}

	@PostMapping("/addPort/{id}")
	public String savePort(@ModelAttribute Port port) {
		portRepository.save(port);
		return "redirect:/portOwner/accountPortOwner/" + port.getPortOwner().getId();
	}

	@GetMapping("/showPorts/{id}")
	public String getTweetsStartingWith(Model model, @PathVariable Long id) {
		model.addAttribute("ports", portRepository.findPortsByPortOwner_Id(id));
		return "port/showPorts";
	}

	@GetMapping("/editPort/{id}/{portOwnerId}")
	public String editPort(Model model, @PathVariable Long id, @PathVariable Long portOwnerId) {
		model.addAttribute("port", portRepository.findOne(id));
		model.addAttribute("poertOwner", portOwnerRepository.findOne(portOwnerId));
		return "port/editPort";
	}

	@PostMapping("/editPort/{id}/{portOwnerId}")
	public String saveEditedPort(@ModelAttribute Port port, @PathVariable Long id, @PathVariable Long portOwnerId) {
		portRepository.updateUserSetFirstNameAndLastNameAndEmailAndPassword(id, port.getPortName(), port.getLake(), port.getSpace(), port.getDescription());
		return "redirect:/portOwner/accountPortOwner/" + portOwnerId;
	}

	@GetMapping("/deletePort/{id}/{portOwnerId}")
	public String deletePort(@PathVariable Long id, @PathVariable Long portOwnerId) {
		portRepository.delete(id);
		return "redirect:/portOwner/accountPortOwner/" + portOwnerId;
	}


}
