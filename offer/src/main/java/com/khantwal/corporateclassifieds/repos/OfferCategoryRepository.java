package com.khantwal.corporateclassifieds.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.khantwal.corporateclassifieds.models.Offer;
import com.khantwal.corporateclassifieds.models.OfferCategory;


@Repository
public interface OfferCategoryRepository extends JpaRepository<OfferCategory, Long> {

	OfferCategory findByCategoryType(String offerCategory);
	
	@Query("select offer from OfferCategory where category_type=:category_type")
	List<Offer> findOfferByCategoryType(@Param("category_type") String category_type);
	
}
