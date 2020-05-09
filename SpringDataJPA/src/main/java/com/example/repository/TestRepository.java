package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.TestModel;

public interface TestRepository extends CrudRepository<TestModel, Integer> {

}
