package portbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import portbooking.entities.PortOwner;

public interface PortOwnerRepository extends JpaRepository<PortOwner,Long> {


	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update PortOwner u set u.firstName = :firstName, u.lastName =:lastName, u.email = :email, u.password =:password where u.id = :id")
	void updateUserSetFirstNameAndLastNameAndEmailAndPassword(@Param("id") Long id, @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("email") String email, @Param("password") String password);

}

