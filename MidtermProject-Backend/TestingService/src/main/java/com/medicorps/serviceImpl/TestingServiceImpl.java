package com.medicorps.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicorps.dto.TestDto;
import com.medicorps.exception.IdNotFoundException;
import com.medicorps.model.Test;
import com.medicorps.repository.TestRepository;
import com.medicorps.service.TestingService;

@Service
public class TestingServiceImpl implements TestingService{

	@Autowired
	TestRepository testRepo;
	
	ModelMapper model = new ModelMapper();

	@Override
	public List<TestDto> viewAllTest() {
		List<Test> tests = testRepo.findAll();
		if(tests.isEmpty()) {
			throw new IdNotFoundException("No test Available");
		}
		List<TestDto> testsDto = new ArrayList<>();
		for(Test test : tests) {
			TestDto dto = model.map(test, TestDto.class);
			dto.setTestName(test.getTestList().getTestName());;
			dto.setPatientId(test.getPatient().getPatientId());
			dto.setPatientName(test.getPatient().getPatientName());;
			testsDto.add(dto);
		}
		return testsDto;
	}

	@Override
	public String takeTest(int id) {
		Test test = testRepo.findById(id).orElseThrow(()->
				new IdNotFoundException("Invalid test Id"));
		test.setStatus("Waiting for result");
		test.setTestDateTime(LocalDateTime.now());
		TestDto testDto = model.map(testRepo.save(test), TestDto.class);
		testDto.setTestName(test.getTestList().getTestName());
		testDto.setPatientId(test.getPatient().getPatientId());
		testDto.setPatientName(test.getPatient().getPatientName());
		return "Test taken";
	}

	@Override
	public TestDto submitTestResult(int id, String result) {
		Test test = testRepo.findById(id).orElseThrow(()->
					new IdNotFoundException("Invalid test Id"));
		test.setStatus("Test Result Uploaded");
		test.setResultDateTime(LocalDateTime.now());
		test.setResult(result);
		TestDto testDto = model.map(testRepo.save(test),TestDto.class);
		testDto.setTestName(test.getTestList().getTestName());
		testDto.setPatientId(test.getPatient().getPatientId());
		testDto.setPatientName(test.getPatient().getPatientName());
		return testDto;
	}

	@Override
	public TestDto findByTestId(int id) {
		Test test = testRepo.findById(id).orElseThrow(()->
					new IdNotFoundException("Invalid test Id"));
		TestDto testDto = model.map(test,TestDto.class);
		testDto.setTestName(test.getTestList().getTestName());
		testDto.setPatientId(test.getPatient().getPatientId());
		testDto.setPatientName(test.getPatient().getPatientName());
		return testDto;
	}
	
	
}
