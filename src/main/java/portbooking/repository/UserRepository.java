package portbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import portbooking.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update User u set u.firstName = :firstName, u.lastName =:lastName, u.email = :email, u.password =:password where u.id = :id")
	void updateUserSetFirstNameAndLastNameAndEmailAndPassword(@Param("id") Long id, @Param("firstName") String firstName, @Param("lastName") String lastName, @Param("email") String email, @Param("password") String password);

	User findByEmail(String email);

	boolean existsByEmail(String email);


}
