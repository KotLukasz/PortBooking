package portbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import portbooking.entity.Reservation;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@Query("select r from Reservation r where r.userReservation.id = :id")
	List<Reservation> findReservationByUserId(@Param("id") Long id);

	@Query("select r from Reservation r where r.portReservation.portOwner.id = :id")
	List<Reservation> findReservationByPortOwnerId(@Param("id") Long id);

	@Query("select COALESCE (sum (r.reservedSpace), 0) from Reservation r where r.reservedDate = :reservedDate and r.portReservation.id = :portReservation")
	int sumReservedSpaceByReservedDate(@Param("reservedDate") LocalDate reservedDate, @Param("portReservation") Long portReservation);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update Reservation r set r.reservedSpace = :reservedSpace, r.fullPrice = :fullPrice where r.id = :id")
	void updateSetReservedSpaceAndFullPrice(@Param("id") Long id, @Param("reservedSpace") int reservedSpace, @Param("fullPrice") BigDecimal fullPrice);

}
