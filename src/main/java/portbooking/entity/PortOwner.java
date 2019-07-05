package portbooking.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import portbooking.authentication.UniqueEmailPortOwner;



import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "portOwners")
public class PortOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Size(min = 2, max = 30)
	private String firstName;

	@NotEmpty
	@Size(min = 2, max = 30)
	private String lastName;

	@UniqueEmailPortOwner
	@Email
	@NotEmpty
	private String email;

	@NotEmpty
	private String password;

	private LocalDateTime createdOn;

	@OneToMany(mappedBy = "portOwner", cascade = CascadeType.REMOVE)
	private List<Port> ports = new ArrayList<>();

	@PrePersist
	public void prePersist() {
		createdOn = LocalDateTime.now();
	}


	public PortOwner() {
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}


	public List<Port> getPorts() {
		return ports;
	}

	public void setPorts(List<Port> ports) {
		this.ports = ports;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

}
