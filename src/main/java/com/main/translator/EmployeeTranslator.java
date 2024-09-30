package com.main.translator;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.dto.EmployeeRequest;
import com.main.dto.EmployeeResponse;
import com.main.entity.Employee;

@Component
public class EmployeeTranslator {
	
	private final ObjectMapper mapper;

	public EmployeeTranslator( ObjectMapper objectMapper) {
		super();
		this.mapper = objectMapper;
	}

	public EmployeeResponse employeeResponse(Employee emp) {
		return mapper.convertValue(emp, EmployeeResponse.class);
	}
	
	
	public List<EmployeeResponse> employeeResponses(List<Employee> emp){
		return emp.stream().map(e-> mapper.convertValue(e, EmployeeResponse.class)).collect(Collectors.toList());
	}
	
	
	public Employee reqEmployee(EmployeeRequest empp) {
		return mapper.convertValue(empp, Employee.class);
		
	}

}
