package com.khantwal.corporateclassifieds.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.khantwal.corporateclassifieds.models.Offer;
import com.khantwal.corporateclassifieds.models.OfferStatus;


@Repository
public interface OfferStatusRepository extends JpaRepository<OfferStatus, Long> {

	@Query("select offer from OfferStatus order by offer_post_date desc")
	List<Offer> sortByPostedDate();
//
//	@Query("select f from OfferStatus as f where employeeId=:employeeId Order By f.likes Desc")
//	List<OfferStatus> findByEmployeeIdWithTopLikes(@Param("employeeId") Long employeeId);

//	List<OfferStatus> findByLikes();

//	@Query("from OfferStatus where offerPostDate=:postedDate")
//	List<OfferStatus> findByOfferPostDate(@Param("postedDate") Date postedDate);
//
//	@Query("Select f from OfferStatus as f order by f.likes")
//	List<OfferStatus> findOfferByTopLikes();
//
//	@Query("select offer from OfferStatus")
//	List<Offer> findOffer();
//
//	


}
