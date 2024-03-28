package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.app.model.Students;
import com.app.service.StudentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping
	public List<Students> getAllStudents(){
		return service.getAllStudents();
	}
	
	
	@PostMapping
    public Students createStudent(@RequestBody Students student) {
        return service.createStudent(student);
    }
	
	@PutMapping("/{id}")
    public Students updateStudent(@PathVariable Long id, @RequestBody Students student) {
        return service.updateStudent(id, student);
    }
	
	@DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}
