package portbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import portbooking.entity.Port;
import portbooking.entity.Reservation;
import portbooking.repository.PortRepository;
import portbooking.repository.ReservationRepository;
import portbooking.repository.UserRepository;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private PortRepository portRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	Validator validator;

	@Autowired
	private UserRepository userRepository;

	@ModelAttribute("findAllPorts")
	public List<Port> findAllPorts() {
		return portRepository.findAll();
	}

	@GetMapping("/showAllPorts/{userId}")
	public String showAllPorts(Model model, @PathVariable Long userId) {
		model.addAttribute("user", userRepository.findOne(userId));
		return "reservation/showAllPorts";
	}

	@GetMapping("/makeReservation/{portId}/{userId}")
	public String makeReservation(Model model, @PathVariable Long portId, @PathVariable Long userId) {
		model.addAttribute("reservation", new Reservation());
		model.addAttribute("port", portRepository.findOne(portId));
		model.addAttribute("spaceLeft", spaceToChoose(portId));
		return "reservation/makeReservation";
	}

	@PostMapping("/makeReservation/{portId}/{userId}")
	public String makeReservation(@ModelAttribute @Valid Reservation reservation, BindingResult result, @PathVariable Long portId, @PathVariable Long userId, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("port", portRepository.findOne(portId));
			return "reservation/makeReservation";
		}
		reservation.setPortReservation(portRepository.findOne(portId));
		reservation.setUserReservation(userRepository.findOne(userId));
		reservationRepository.save(reservation);
		portRepository.updatePortSetSpaceLeftToReserve(portId, (portRepository.findOne(portId).getSpaceLeftToReserve() - reservation.getReservedSpace()));
		return "redirect:/user/accountUser/" + userId;
	}

	@GetMapping("/showReservations/{id}")
	public String showReservationsById(Model model, @PathVariable Long id) {
		model.addAttribute("reservation", reservationRepository.findReservationByUserId(id));
		return "reservation/showReservations";
	}

	public int[] spaceToChoose(Long portId) {
		int[] spaceArray = new int[portRepository.findOne(portId).getSpaceLeftToReserve()];
		int j = 1;
		for (int i = 0; i < spaceArray.length; i++) {
			spaceArray[i] = j++;
		}
		return spaceArray;
	}

}