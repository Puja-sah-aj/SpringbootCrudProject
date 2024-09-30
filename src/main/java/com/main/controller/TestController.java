package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.dto.EmployeeRequest;
import com.main.dto.EmployeeResponse;
import com.main.service.EmpService;



@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private EmpService service;
	
	//fetch the data
	@GetMapping("/fetch")
	public ResponseEntity<List<EmployeeResponse>> fetchemp(){
		return ResponseEntity.ok(service.getemp());
	}
	
	//fetch by id
	@GetMapping("/fetch/{id}")
	public ResponseEntity<EmployeeResponse> fetchby( @PathVariable int id){
		
		EmployeeResponse emp = service.getempby(id);
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(emp);
	}
	
	//add the data
	@PostMapping("/add")
	public ResponseEntity<Integer> addemp(@RequestBody EmployeeRequest request){
		return ResponseEntity.ok(service.addemployee(request));
	}
	
	
	//update the data
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateemployee(@RequestBody EmployeeRequest emp, @PathVariable int id ){
		return ResponseEntity.ok(service.updateemp(emp, id));
	}
	
	//delete all
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteallemp(){
		service.deleteemp();
		return ResponseEntity.ok("delete all data");
	}
	
	//delete by id
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<Integer> deletebyid(@PathVariable int id){
		return ResponseEntity.ok(service.deleteempby(id));
	}

}
