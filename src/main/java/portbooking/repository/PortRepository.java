package portbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import portbooking.entities.Port;

import java.util.List;

@Repository
public interface PortRepository extends JpaRepository<Port, Long> {

	@Query("select p from Port p where p.portOwner.id = :id")
	List<Port> findPortsByPortOwner_Id(@Param("id") Long id);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update Port p set p.portName = :portName, p.lake =:lake, p.space = :space, p.description =:description where p.id = :id")
	void updateUserSetFirstNameAndLastNameAndEmailAndPassword(@Param("id") Long id, @Param("portName") String portName, @Param("lake") String lake, @Param("space") int space, @Param("description") String description);


}


