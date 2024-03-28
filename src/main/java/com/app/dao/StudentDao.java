package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Students;

@Repository
public interface StudentDao extends JpaRepository<Students,Long>{
	
}
