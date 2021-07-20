package com.khantwal.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.khantwal.employee.model.Employee;
import com.khantwal.employee.repository.EmployeeRepository;
import com.khantwal.employee.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeApplicationTests {
	
	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private EmployeeRepository employeeRepository;

	/*
	 * @Test void viewProfileTest() { long employeeId = 1;
	 * 
	 * Employee employee = new
	 * Employee((long)1,"userName","user@gmail.com","user","password","programmer");
	 * 
	 * when(employeeRepository.findById(employeeId).get()).thenReturn(employee);
	 * 
	 * //System.out.println(employeeService.viewProfile(employeeId));
	 * 
	 * assertEquals("userName",employeeService.viewProfile(employeeId).getName()); }
	 */
	
	@Test
	void findByEmailAndPasswordTest() {
		String employeeEmailId = "userName";
		String password = "password";
		
		Employee employee = new Employee((long)1,"userName","user@gmail.com","user","password","programmer");
		
		when(employeeRepository.findByEmailAndPassword(employeeEmailId,password)).thenReturn(employee);
		
		//System.out.println(employeeService.viewProfile(employeeId));
		
		assertEquals("userName",employeeService.findByEmailAndPassword(employeeEmailId,password).getName());
		
	}

}
