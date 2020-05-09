package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.model.SubTest;

public interface SubTestRepository extends CrudRepository<SubTest, Integer> {
	
//	@Query("select name,id from SubTest where id=testId")
//	public List<SubTest> findByTestId(@Param("testId") int testId);
}