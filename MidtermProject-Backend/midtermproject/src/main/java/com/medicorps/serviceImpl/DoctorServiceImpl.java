package com.medicorps.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicorps.dto.DoctorDto;
import com.medicorps.exception.IdNotFoundException;
import com.medicorps.model.Department;
import com.medicorps.model.Doctor;
import com.medicorps.repository.DepartmentRepository;
import com.medicorps.repository.DoctorRepository;
import com.medicorps.service.DoctorService;
import com.medicorps.utility.AppConstant;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	DoctorRepository doctorRepository; 
	
	ModelMapper model = new ModelMapper();
	
	@Override
	public DoctorDto addByDeptId(int id, DoctorDto doctorDto) {
		Department department = departmentRepository.findById(id).orElseThrow(()->
								new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		Doctor doctor = model.map(doctorDto, Doctor.class);
		doctor.setDateOfJoining(LocalDate.now());
		doctor.setDepartment(department);
		department.setNoOfEmps(department.getNoOfEmps()+1);
		departmentRepository.save(department);
		DoctorDto docDto = model.map(doctorRepository.save(doctor), DoctorDto.class );
		docDto.setDeptId(id);
		return docDto;
	}

	@Override
	public List<DoctorDto> viewAll() {
		List<Doctor> doctors = doctorRepository.findAll();
		if(doctors.isEmpty()) {
			throw new IdNotFoundException("no doctors available");
		}
		List<DoctorDto> doctorDtos = new ArrayList<>();
		for(Doctor doctor : doctors) {
			DoctorDto doc = model.map(doctor, DoctorDto.class);
			doc.setDeptId(doctor.getDepartment().getDeptId());
			doctorDtos.add(doc);
		}
		return doctorDtos;
	}

	@Override
	public List<DoctorDto> viewByDeptId(int id) {
		Department department = departmentRepository.findById(id).orElseThrow(()->
								new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		List<Doctor> doctors = department.getDoctors();
		if(doctors.isEmpty()) {
			throw new IdNotFoundException("no doctors available");
		}
		List<DoctorDto> doctorDtos = new ArrayList<>();
		for(Doctor doctor : doctors) {
			DoctorDto doc = model.map(doctor, DoctorDto.class);
			doc.setDeptId(doctor.getDepartment().getDeptId());
			doctorDtos.add(doc);
		}
		return doctorDtos;
	}

	@Override
	public DoctorDto updateById(int id, DoctorDto doctorDto) {
		Doctor doc = doctorRepository.findById(id).orElseThrow(()->
					new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		doc.setDocName(doctorDto.getDocName());
		doc.setDocEmail(doctorDto.getDocEmail());
		doc.setDesignation(doctorDto.getDesignation());
		doc.setSpeciality(doctorDto.getSpeciality());
		doc.setExperience(doctorDto.getExperience());
		doc.setFees(doctorDto.getFees());
		doc.setDocSalary(doctorDto.getDocSalary());
		doc.setTimings(doctorDto.getTimings());
		DoctorDto docDto = model.map(doctorRepository.save(doc), DoctorDto.class);
		docDto.setDeptId(doc.getDepartment().getDeptId());
		return docDto;
	}

	@Override
	public DoctorDto deleteById(int id) {
		Doctor doc = doctorRepository.findById(id).orElseThrow(()->
					new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		Department department = doc.getDepartment();
		department.setNoOfEmps(department.getNoOfEmps()-1);
		departmentRepository.save(department);
		doctorRepository.deleteById(id);
		DoctorDto doctorDto = model.map(doc, DoctorDto.class);
		doctorDto.setDeptId(department.getDeptId());
		return doctorDto;
	}

	@Override
	public DoctorDto viewById(int id) {
		Doctor doc = doctorRepository.findById(id).orElseThrow(()->
					new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		DoctorDto doctorDto = model.map(doc, DoctorDto.class);
		doctorDto.setDeptId(doc.getDepartment().getDeptId());
		return doctorDto;
	}
}
