package portbooking.entity;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Min(value = 1)
	@NotNull
	private int reservedSpace;

	@ManyToOne
	private User userReservation;

	@ManyToOne
	private Port portReservation;

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
}
