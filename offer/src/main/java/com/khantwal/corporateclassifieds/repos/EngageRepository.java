package com.khantwal.corporateclassifieds.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.khantwal.corporateclassifieds.models.Engage;
import com.khantwal.corporateclassifieds.models.Offer;



@Repository
public interface EngageRepository extends JpaRepository<Engage,Long> {

	@Query("select offer from Engage as f where f.employeeId=:employeeId")
	List<Offer> findByEmployeeId(Long employeeId);

}
