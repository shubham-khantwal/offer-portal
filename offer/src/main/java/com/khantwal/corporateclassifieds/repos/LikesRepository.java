package com.khantwal.corporateclassifieds.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.khantwal.corporateclassifieds.models.Engage;
import com.khantwal.corporateclassifieds.models.Likes;
import com.khantwal.corporateclassifieds.models.Offer;



@Repository
public interface LikesRepository extends JpaRepository<Likes,Long> {

	Likes findByEmployeeIdAndOfferId(Long employeeId, Long offerId);
	

}
