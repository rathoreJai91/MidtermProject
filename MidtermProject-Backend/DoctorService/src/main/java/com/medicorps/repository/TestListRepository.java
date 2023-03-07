package com.medicorps.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicorps.model.TestList;

public interface TestListRepository extends JpaRepository<TestList, Integer> {

	public Optional<TestList> findByTestName(String testName);
}
