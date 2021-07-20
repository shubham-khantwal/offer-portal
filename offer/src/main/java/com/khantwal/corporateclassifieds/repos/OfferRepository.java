package com.khantwal.corporateclassifieds.repos;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.khantwal.corporateclassifieds.models.Offer;
import com.khantwal.corporateclassifieds.models.OfferCategory;


@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

	List<Offer> findByEmployeeId(Long employeeId);

	@Modifying
	@Transactional
	@Query("update Offer o set likes = :i where offerId=:offerId")
	void updateLike(@Param("i") int i , @Param("offerId") Long offerId);


	@Query("from Offer order by likes desc")
	List<Offer> sortByLikes();

	List<Offer> findByOfferCategory(OfferCategory ocId);




}
