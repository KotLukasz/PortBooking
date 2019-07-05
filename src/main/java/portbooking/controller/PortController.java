package portbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import portbooking.entity.Port;
import portbooking.repository.PortOwnerRepository;
import portbooking.repository.PortRepository;

import javax.validation.Valid;
import javax.validation.Validator;

@Controller
@RequestMapping("/port")
public class PortController {

	@Autowired
	private PortOwnerRepository portOwnerRepository;

	@Autowired
	private PortRepository portRepository;

	@Autowired
	Validator validator;

	@GetMapping("/addPort/{id}")
	public String addPort(Model model, @PathVariable long id) {
		model.addAttribute("port", new Port());
		model.addAttribute("owner", portOwnerRepository.findOne(id));
		return "port/addOrEditPort";
	}

	@PostMapping("/addPort/{id}")
	public String savePort(@ModelAttribute("port") @Valid Port port, BindingResult result, @PathVariable long id, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("owner", portOwnerRepository.findOne(id));
			return "port/addOrEditPort";
		}
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
		model.addAttribute("owner", portOwnerRepository.findOne(portOwnerId));
		return "port/addOrEditPort";
	}

	@PostMapping("/editPort/{id}/{portOwnerId}")
	public String saveEditedPort(@ModelAttribute("port") @Valid Port port, BindingResult result, @PathVariable Long id, @PathVariable Long portOwnerId, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("owner", portOwnerRepository.findOne(portOwnerId));
			return "port/addOrEditPort";
		}
		portRepository.updateUserSetFirstNameAndLastNameAndEmailAndPassword(id, port.getPortName(), port.getLake(), port.getSpace(), port.getDescription());
		return "redirect:/portOwner/accountPortOwner/" + portOwnerId;
	}

	@GetMapping("/deletePort/{id}/{portOwnerId}")
	public String deletePort(@PathVariable Long id, @PathVariable Long portOwnerId) {
		portRepository.delete(id);
		return "redirect:/portOwner/accountPortOwner/" + portOwnerId;
	}

	@ModelAttribute("spaceToChoose")
	public int[] spaceToChoose() {
		int[] spaceArray = new int[100];
		for (int i = 0; i < spaceArray.length;i++) {
			spaceArray[i] = i;
		}
		return spaceArray;
	}

}
