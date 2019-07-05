package portbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import portbooking.entity.Reservation;


import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@Query("select r from Reservation r where r.userReservation.id = :id")
	List<Reservation> findReservationByUserId(@Param("id") Long id);

}