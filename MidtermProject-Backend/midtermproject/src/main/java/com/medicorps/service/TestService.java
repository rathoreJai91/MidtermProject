package com.medicorps.service;

import java.util.List;

import com.medicorps.dto.TestDto;
import com.medicorps.dto.TestListDto;

public interface TestService {

	TestListDto add(TestListDto testListDto);
	List<TestListDto> viewAll();
	TestListDto updateTest(TestListDto testListDto);
	TestListDto viewbyName(String name);
	TestListDto deleteById(int id);
	
	TestDto sendForTest(TestDto testDto);
	List<TestDto> viewAllTest();
	TestDto takeTest(int id);
	TestDto submitResultsById(int id,String result);
	List<TestDto> getTestByPatientId(int id);
	
}
