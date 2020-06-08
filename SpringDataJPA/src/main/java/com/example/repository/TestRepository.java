package com.example.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.TestModel;

@Repository
public interface TestRepository extends CrudRepository<TestModel, Integer> {

}
