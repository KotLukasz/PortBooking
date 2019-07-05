package portbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import portbooking.entity.Port;

import java.util.List;

@Repository
public interface PortRepository extends JpaRepository<Port, Long> {

	@Query("select p from Port p where p.portOwner.id = :id")
	List<Port> findPortsByPortOwner_Id(@Param("id") Long id);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update Port p set p.portName = :portName, p.lake =:lake, p.space = :space,p.spaceLeftToReserve = :spaceLeftToReserve ,p.description =:description where p.id = :id")
	void updatePortSetFirstNameAndLastNameAndEmailAndPassword(@Param("id") Long id, @Param("portName") String portName, @Param("lake") String lake, @Param("space") int space, @Param("spaceLeftToReserve") int spaceLeftToReserve, @Param("description") String description);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update Port p set p.spaceLeftToReserve = :spaceLeftToReserve where p.id = :id")
	void updatePortSetSpaceLeftToReserve(@Param("id") Long id,  @Param("spaceLeftToReserve") int spaceLeftToReserve);

}


