package portbooking.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Min(value = 1)
	private int reservedSpace;

	@ManyToOne
	private User userReservation;

	@ManyToOne
	private Port portReservation;

	@Min(value = 1)
	@Digits(integer=6, fraction=2)
	@NotNull
	private BigDecimal fullPrice;


	@FutureOrPresent
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate reservedDate;


	public Reservation() {
	}

	public Long getId() {
		return id;
	}

	public int getReservedSpace() {
		return reservedSpace;
	}

	public void setReservedSpace(int reservedSpace) {
		this.reservedSpace = reservedSpace;
	}

	public User getUserReservation() {
		return userReservation;
	}

	public void setUserReservation(User userReservation) {
		this.userReservation = userReservation;
	}

	public Port getPortReservation() {
		return portReservation;
	}

	public void setPortReservation(Port portReservation) {
		this.portReservation = portReservation;
	}

	public LocalDate getReservedDate() {
		return reservedDate;
	}

	public void setReservedDate(LocalDate reservedDate) {
		this.reservedDate = reservedDate;
	}

	public BigDecimal getFullPrice() {
		return fullPrice;
	}

	public void setFullPrice(BigDecimal fullPrice) {
		this.fullPrice = fullPrice;
	}
}
