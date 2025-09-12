package com._daysprojects2.day2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeRepository repository;
	@PostMapping("/emps")
	public List<Employee> createEmployee(@RequestBody List<Employee> employee) {
		return repository.saveAll(employee);	
	}
	@GetMapping("/emps")
	public List<Employee> getEmployees(@RequestBody List<Employee> employee)
	{
		return repository.findAll();
	}
	@GetMapping("/emps/{id}")
	public Employee getEmployeebyId(@PathVariable Long id){
		return repository.findById(id).orElseThrow(()-> new RuntimeException("epmloyye not found"+ id));	
	}
	@PutMapping("/emps/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee ) {
		Employee ExistingEmployee = repository.findById(id).orElseThrow(()-> new RuntimeException("employee not updated"+ id));
		ExistingEmployee.setName(employee.getName());
		ExistingEmployee.setEmail(employee.getEmail());
		return repository.save(ExistingEmployee);	
	}
	@DeleteMapping("/emps/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		repository.findById(id);
	}
}
