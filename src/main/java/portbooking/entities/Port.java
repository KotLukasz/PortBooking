package portbooking.entities;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ports")
public class Port {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String portName;

	private String lake;

	private int space;

	private String description;

	private LocalDateTime createdOn;

	@ManyToOne
	private PortOwner portOwner;

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
}
