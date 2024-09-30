package com.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.entity.Employee;
import com.main.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//find the data
	public List<Employee> findemp(){
		return employeeRepository.findAll();
		
  }
	
	//find by id
	public Employee findby(int id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
  //add the data
	public int addemp(Employee emp) {
		employeeRepository.save(emp);
		return emp.getId();
	}
	
	//update the data
	public String update(Employee emp,int id) {
		if(! employeeRepository.existsById(id)) {
			return " user not found";
		}
		emp.setId(id);
		employeeRepository.save(emp);
		return Integer.toString(id);
	}
	
	//deleteAll
	public void deleteemp() {
		employeeRepository.deleteAll();
	}
	
	//delete by id
	public int deleteempby(int id) {
		if(!employeeRepository.existsById(id)) {
			return 0;
		}
		employeeRepository.deleteById(id);
		return id;
	}

}
