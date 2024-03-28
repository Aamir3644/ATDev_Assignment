package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

import com.app.dao.StudentDao;
import com.app.model.Students;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentDao dao;
	
	public List<Students> getAllStudents(){
		return dao.findAll();
	}
	
	public Students createStudent(Students student) {
        return dao.save(student);
    }
	
	public Students updateStudent(Long id, Students updatedStudent) {
		// findById() method return Optional<Students> instead of Direct Students Object
		// Because entity might not exist in DB so using Optional we can handle this case carefully
		Optional<Students> existingStudentOptional = dao.findById(id);
		
		// When findById() method do not find the Student with specific id it will return a Empty optional
		// isPresent() will return false if it is empty Optional, otherwise true
		if (existingStudentOptional.isPresent()) {
	        Students existingStudent = existingStudentOptional.get(); 
	        // Here i am getting Student Object that is present in Optional to operate on it.
	        
	        if (updatedStudent.getName() != null) {
	            existingStudent.setName(updatedStudent.getName());
	        }
	        if (updatedStudent.getAge() != null) {
	            existingStudent.setAge(updatedStudent.getAge());
	        }
	        
	        return dao.save(existingStudent);
	    } else {
	        throw new RuntimeException("Student not found with id: " + id);
	    }
		
	}
	
	public void deleteStudent(Long id) {
        dao.deleteById(id);
    }
}
