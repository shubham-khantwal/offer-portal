package com.khantwal.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.khantwal.employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmailAndPassword(String email, String password);
	
	@Query("select e from Employee e where e.email=:email")
	public Employee getUserByUserName(@Param("email") String email);

	Employee findByEmail(String username);

}
