package portbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

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

	@ModelAttribute("date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate date() {
		LocalDate date = LocalDate.now();
		return date;
	}

	@ModelAttribute("filterByLakes")
	public List<String> filterByLakes() {
		List<Port> portList = portRepository.findAll();
		for (Port temp : portList) {
			temp.setLake(temp.getLake().toUpperCase());
		}
		List<String> lakeNames = portList.stream()
				.map(Port::getLake)
				.distinct()
				.collect(Collectors.toList());
		return lakeNames;
	}

	@ModelAttribute("findAllPorts")
	public List<Port>  findAllPorts () {
		return portRepository.findAll();
	}

	@GetMapping("/showAllPorts/{userId}")
	public String showAllPorts(Model model, @PathVariable Long userId) {
		model.addAttribute("user", userRepository.findOne(userId));
		model.addAttribute("port", new Port());
		return "reservation/showAllPorts";
	}

	@PostMapping("/showAllPorts/{userId}")
	public String filterPorts(@ModelAttribute Port port, @PathVariable Long userId, Model model) {
		model.addAttribute("filter", portRepository.findPortByLakeName(port.getLake()));
		model.addAttribute("user", userRepository.findOne(userId));
		model.addAttribute("port", new Port());
		return "reservation/showFilterPortsByLake";
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
			model.addAttribute("spaceLeft", spaceToChoose(portId));
			return "reservation/makeReservation";
		}
		reservation.setPortReservation(portRepository.findOne(portId));
		reservation.setUserReservation(userRepository.findOne(userId));
		reservationRepository.save(reservation);
		portRepository.updatePortSetSpaceLeftToReserve(portId, (portRepository.findOne(portId).getSpaceLeftToReserve() - reservation.getReservedSpace()));
		return "redirect:/user/accountUser/" + userId;
	}

	@GetMapping("/showReservations/{userId}")
	public String showReservationsById(Model model, @PathVariable Long userId) {
		model.addAttribute("reservation", reservationRepository.findReservationByUserId(userId));
		return "reservation/showReservations";
	}

	@GetMapping("/deleteReservation/{reservationId}/{userId}/{portId}")
	public String deleteReservation(@PathVariable Long reservationId, @PathVariable Long userId, @PathVariable Long portId) {
		portRepository.updatePortSetSpaceLeftToReserve(portId, (portRepository.findOne(portId).getSpaceLeftToReserve() + reservationRepository.findOne(reservationId).getReservedSpace()));
		reservationRepository.delete(reservationId);
		return "redirect:/user/accountUser/" + userId;
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