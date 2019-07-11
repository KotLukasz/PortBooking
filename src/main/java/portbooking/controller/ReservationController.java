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

import javax.validation.Validator;

import java.math.BigDecimal;

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
	public List<Port> findAllPorts() {
		return portRepository.findAll();
	}

	@GetMapping("/showAllPorts/{userId}")
	public String showAllPorts(Model model, @PathVariable Long userId) {
		model.addAttribute("user", userRepository.findOne(userId));
		model.addAttribute("port", new Port());
		model.addAttribute("reservation", new Reservation());
		return "reservation/showAllPorts";
	}

	@GetMapping("/makeReservation/{portId}/{userId}/{reservedDate}")
	public String makeReservation(Model model, @PathVariable Long portId, @PathVariable Long userId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate reservedDate) {
		model.addAttribute("reservation", new Reservation());
		model.addAttribute("port", portRepository.findOne(portId));
		if (spaceToChoose(reservedDate, portId).length <= 0) {
			return "reservation/noAvailableSpace";
		} else {
			model.addAttribute("spaceLeft", spaceToChoose(reservedDate, portId));
		}
		return "reservation/makeReservation";
	}

	@PostMapping("/makeReservation/{portId}/{userId}/{reservedDate}")
	public String makeReservation(@ModelAttribute Reservation reservation, @PathVariable Long portId, @PathVariable Long userId) {
		reservation.setPortReservation(portRepository.findOne(portId));
		reservation.setUserReservation(userRepository.findOne(userId));
		reservation.setFullPrice(BigDecimal.valueOf(reservation.getReservedSpace()).multiply(reservation.getPortReservation().getPrice()));
		reservationRepository.save(reservation);
		return "redirect:/user/accountUser/" + reservation.getUserReservation().getId();
	}

	@GetMapping("/showReservations/{userId}")
	public String showReservationsById(Model model, @PathVariable Long userId) {
		model.addAttribute("reservation", reservationRepository.findReservationByUserId(userId));
		return "reservation/showReservations";
	}


	@GetMapping("/editReservationUser/{reservationId}/{userId}")
	public String editReservationUser(Model model, @PathVariable Long reservationId, @PathVariable Long userId) {
		model.addAttribute("reservation", reservationRepository.findOne(reservationId));
		model.addAttribute("spaceLeft", spaceToChooseEdit(reservationRepository.findOne(reservationId).getReservedDate(), reservationId, reservationRepository.findOne(reservationId).getPortReservation().getId()));
		return "reservation/editReservation";
	}

	@PostMapping("/editReservationUser/{reservationId}/{userId}")
	public String editReservationUser(@ModelAttribute Reservation reservation, @PathVariable Long userId, @PathVariable Long reservationId) {
		reservation.setFullPrice(BigDecimal.valueOf(reservation.getReservedSpace()).multiply(reservationRepository.findOne(reservationId).getPortReservation().getPrice()));
		reservationRepository.updateSetReservedSpaceAndFullPrice(reservationId, reservation.getReservedSpace(), reservation.getFullPrice());
		return "redirect:/user/accountUser/" + userId;
	}

	@GetMapping("/deleteReservationUser/{reservationId}/{userId}")
	public String deleteReservationUser(@PathVariable Long reservationId, @PathVariable Long userId) {
		reservationRepository.delete(reservationId);
		return "redirect:/user/accountUser/" + userId;
	}

	@GetMapping("/deleteReservationPortOwner/{reservationId}/{portId}")
	public String deleteReservationPortOwner(@PathVariable Long reservationId, @PathVariable Long portId) {
		reservationRepository.delete(reservationId);
		return "redirect:/portOwner/accountUser/" + portId;
	}

	public int[] spaceToChooseEdit(LocalDate localDate, Long reservationId, Long portId) {
		int[] spaceArray = new int[portRepository.findOne(portId).getSpace() - reservationRepository.sumReservedSpaceByReservedDate(localDate, portId) + reservationRepository.findOne(reservationId).getReservedSpace()];
		int j = 1;
		for (int i = 0; i < spaceArray.length; i++) {
			spaceArray[i] = j++;
		}
		return spaceArray;
	}

	public int[] spaceToChoose(LocalDate localDate, Long portId) {
		int[] spaceArray = new int[portRepository.findOne(portId).getSpace() - reservationRepository.sumReservedSpaceByReservedDate(localDate, portId)];
		int j = 1;
		for (int i = 0; i < spaceArray.length; i++) {
			spaceArray[i] = j++;
		}
		return spaceArray;
	}

}