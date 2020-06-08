package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.SubTest;

@Repository
public interface SubTestRepository extends CrudRepository<SubTest, Integer> {
	
//	@Query("select name,id from SubTest where id=testId")
//	public List<SubTest> findByTestId(@Param("testId") int testId);
	public List<SubTest> findByTmId(int Id);

	public SubTest findByName(String Name);
}