package portbooking.entity;



import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ports")
public class Port {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 2, max = 30)
	private String portName;

	@NotNull
	@Size(min = 2, max = 30)
	private String lake;

	@NotNull
	private int space;

	@NotNull
	private String description;

	private LocalDateTime createdOn;

	@Min(value = 1)
	@Digits(integer=6, fraction=2)
	@NotNull
	private BigDecimal price;

	@NotNull
	@ManyToOne
	private PortOwner portOwner;

	@OneToMany(mappedBy = "portReservation", cascade = CascadeType.REMOVE)
	private List<Reservation> reservation = new ArrayList<>();

	@PrePersist
	public void prePersist() {
		createdOn = LocalDateTime.now();
	}

	public Port() {
	}

	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

	public String getLake() {
		return lake;
	}

	public void setLake(String lake) {
		this.lake = lake;
	}

	public int getSpace() {
		return space;
	}

	public void setSpace(int space) {
		this.space = space;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public PortOwner getPortOwner() {
		return portOwner;
	}

	public void setPortOwner(PortOwner portOwner) {
		this.portOwner = portOwner;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}


	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
