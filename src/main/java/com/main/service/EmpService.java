package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.dao.EmployeeDao;
import com.main.dto.EmployeeRequest;
import com.main.dto.EmployeeResponse;
import com.main.translator.EmployeeTranslator;

@Service
public class EmpService {
	
	@Autowired
	private EmployeeTranslator empTranslator;
	
	@Autowired
	private EmployeeDao dao;
	
	
	//find 
	public List<EmployeeResponse> getemp(){
		return empTranslator.employeeResponses(dao.findemp());
	}
	
	//find by id
	public EmployeeResponse getempby(int id) {
		return empTranslator.employeeResponse(dao.findby(id));
	}
	
	//add the data
	public int addemployee(EmployeeRequest emp) {
		return dao.addemp(empTranslator.reqEmployee(emp));
	}
	
	//update the data
	public String updateemp(EmployeeRequest emp,int id) {
		return dao.update(empTranslator.reqEmployee(emp), id);
	}
	
	//deleteAll
	public void  deleteemp() {
		dao.deleteemp();
	}
	
	//delete by id
	public int deleteempby(int id) {
		return dao.deleteempby(id);
		
	}

}
