package com.medicorps.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicorps.dto.TestDto;
import com.medicorps.dto.TestListDto;
import com.medicorps.exception.IdNotFoundException;
import com.medicorps.model.Patient;
import com.medicorps.model.Test;
import com.medicorps.model.TestList;
import com.medicorps.repository.PatientRepository;
import com.medicorps.repository.TestListRepository;
import com.medicorps.repository.TestRepository;
import com.medicorps.service.TestService;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	TestListRepository testListRepo;
	@Autowired
	TestRepository testRepo;
	@Autowired
	PatientRepository patientRepo;
	
	private ModelMapper model = new ModelMapper();
	
	@Override
	public TestListDto add(TestListDto testListDto) {
		TestList testList = model.map(testListDto, TestList.class);
		return model.map(testListRepo.save(testList),TestListDto.class);
	}

	@Override
	public List<TestListDto> viewAll() {
		List<TestList> list = testListRepo.findAll();
		if(list.isEmpty()) {
			throw new IdNotFoundException("No Test Available");
		}
		List<TestListDto> listDtos = new ArrayList<>();
		for(TestList test : list) {
			listDtos.add(model.map(test, TestListDto.class));
		}
		return listDtos;
	}
	
	@Override
	public TestListDto updateTest(TestListDto testDto) {
		TestList test = testListRepo.findById(testDto.getTestListId()).orElseThrow(()->
						new IdNotFoundException("testNotFound"));
		test = model.map(testDto, TestList.class);
		return model.map(testListRepo.save(test),TestListDto.class);
	}

	@Override
	public TestListDto viewbyName(String name) {
		TestList test = testListRepo.findByTestName(name).orElseThrow(()->
						new IdNotFoundException("Invalid Test Name"));
		return model.map(test, TestListDto.class);
	}

	@Override
	public TestListDto deleteById(int id) {
		TestList test = testListRepo.findById(id).orElseThrow(()->
						new IdNotFoundException("Invalid Test Id"));
		testListRepo.deleteById(id);
		return model.map(test, TestListDto.class);
	}

	@Override
	public TestDto sendForTest(TestDto testDto) {
		Test test = new Test();
		TestList testList = testListRepo.findByTestName(testDto.getTestName()).orElseThrow(()->
								new IdNotFoundException("Invalid test Name"));
		Patient patient = patientRepo.findById(testDto.getPatientId()).orElseThrow(()->
								new IdNotFoundException("Invalid Patient id"));
		test.setTestList(testList);
		patient.setStatus("Waiting for test results");
		patientRepo.save(patient);
		test.setPatient(patient);
		test.setStatus("Send to take test");
		testDto = model.map(testRepo.save(test),TestDto.class);
		testDto.setTestName(testList.getTestName());
		testDto.setPatientId(patient.getPatientId());
		testDto.setPatientName(patient.getPatientName());
		return testDto;
	}

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
	public TestDto takeTest(int id) {
		Test test = testRepo.findById(id).orElseThrow(()->
					new IdNotFoundException("Invalid test Id"));
		test.setStatus("Waiting for result");
		test.setTestDateTime(LocalDateTime.now());
		TestDto testDto = model.map(testRepo.save(test), TestDto.class);
		testDto.setTestName(test.getTestList().getTestName());
		testDto.setPatientId(test.getPatient().getPatientId());
		testDto.setPatientName(test.getPatient().getPatientName());
		return testDto;
	}

	@Override
	public TestDto submitResultsById(int id,String result) {
		Test test = testRepo.findById(id).orElseThrow(()->
					new IdNotFoundException("Invalid test Id"));
		test.setStatus("Test Result Generated");
		test.setResultDateTime(LocalDateTime.now());
		test.setResult(result);
		TestDto testDto = model.map(testRepo.save(test),TestDto.class);
		testDto.setTestName(test.getTestList().getTestName());
		testDto.setPatientId(test.getPatient().getPatientId());
		testDto.setPatientName(test.getPatient().getPatientName());
		return testDto;
	}

	@Override
	public List<TestDto> getTestByPatientId(int id) {
		List<Test> tests = patientRepo.findById(id).orElseThrow(()->
							new IdNotFoundException("Invalid Id")).getTests();
		if(tests.isEmpty()) {
			throw new IdNotFoundException("no tests taken");
		}
		List<TestDto> testDtos = new ArrayList<>();
		for(Test test : tests) {
			TestDto dto = model.map(test, TestDto.class);
			dto.setTestName(test.getTestList().getTestName());;
			dto.setPatientId(test.getPatient().getPatientId());
			dto.setPatientName(test.getPatient().getPatientName());;
			testDtos.add(dto);
		}
		return testDtos;
	}
	
	
	
	
	
}
