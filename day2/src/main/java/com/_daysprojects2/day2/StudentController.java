package com._daysprojects2.day2;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PutExchange;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentRepository respository;
	
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		return respository.save(student);	
	}
	@GetExchange("/students")
	public List<Student> listStudents(){
		return respository.findAll();
			}
	@GetMapping("/students/{id}")
	public Student getStudentsId(@PathVariable Long id)
	{
		 return respository.findById(id)
	     .orElseThrow(() -> new RuntimeException("Student not found with id " + id));   
	}
	@PutMapping("/students/{id}")
	public Student updateStudents(@PathVariable Long id, @RequestBody Student student )
{	
		Student existingStudent = respository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not updated with id " + id));   
			existingStudent.setName(student.getName());
			existingStudent.setEmail(student.getEmail());
	return respository.save(existingStudent);
		}
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
	respository.deleteById(id);
	}
	}