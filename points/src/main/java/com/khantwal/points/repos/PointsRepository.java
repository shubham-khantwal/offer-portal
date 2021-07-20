package com.khantwal.points.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.khantwal.points.models.Points;

@Repository
public interface PointsRepository extends JpaRepository<Points,Long>{

	Points findByEmployeeId(Long employeeId);

}
