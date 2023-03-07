package com.medicorps.service;

import java.util.List;

import com.medicorps.dto.TestDto;

public interface TestingService {

	List<TestDto> viewAllTest();
	String takeTest(int id);
	TestDto submitTestResult(int id , String result);
	TestDto findByTestId(int id);
	
}
