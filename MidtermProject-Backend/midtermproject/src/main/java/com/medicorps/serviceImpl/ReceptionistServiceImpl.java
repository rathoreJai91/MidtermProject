package com.medicorps.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicorps.dto.ReceptionistDto;
import com.medicorps.exception.IdNotFoundException;
import com.medicorps.model.Department;
import com.medicorps.model.Receptionist;
import com.medicorps.repository.DepartmentRepository;
import com.medicorps.repository.ReceptionistRepository;
import com.medicorps.service.ReceptionistService;
import com.medicorps.utility.AppConstant;

@Service
public class ReceptionistServiceImpl implements ReceptionistService{

	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	ReceptionistRepository receptionistRepository;
	
	ModelMapper model = new ModelMapper();
	
	@Override
	public ReceptionistDto addByDeptId(int id, ReceptionistDto receptionistDto) {
		Department department = departmentRepository.findById(id).orElseThrow(()->
								new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		Receptionist receptionist = new ModelMapper().map(receptionistDto, Receptionist.class);
		receptionist.setDepartment(department);
		department.setNoOfEmps(department.getNoOfEmps()+1);
		departmentRepository.save(department);
		receptionist.setDateOfJoining(LocalDate.now());
		ReceptionistDto recepDto = new ModelMapper().map(receptionistRepository.save(receptionist), ReceptionistDto.class );
		recepDto.setDeptId(id);
		return recepDto;
	}

	@Override
	public List<ReceptionistDto> viewAll() {
		List<Receptionist> receptionists = receptionistRepository.findAll();
		if(receptionists.isEmpty()) {
			throw new IdNotFoundException("no receptionists available");
		}
		List<ReceptionistDto> receptionistDtos = new ArrayList<>();
		for(Receptionist receptionist : receptionists) {
			ReceptionistDto recepDto = new ModelMapper().map(receptionist , ReceptionistDto.class);
			recepDto.setDeptId(receptionist.getDepartment().getDeptId());
			receptionistDtos.add(recepDto);
		}
		return receptionistDtos;
	}

	@Override
	public List<ReceptionistDto> viewByDeptId(int id) {
		Department department = departmentRepository.findById(id).orElseThrow(()->
								new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		List<Receptionist> receptionists = department.getReceptionists();
		if(receptionists.isEmpty()) {
			throw new IdNotFoundException("no receptionists present");
		}
		List<ReceptionistDto> receptionistDtos = new ArrayList<>();
		for(Receptionist receptionist : receptionists) {
			ReceptionistDto recepDto = new ModelMapper().map(receptionist , ReceptionistDto.class);
			recepDto.setDeptId(id);
			receptionistDtos.add(recepDto);
		}
		return receptionistDtos;
	}

	@Override
	public ReceptionistDto viewbyId(int id) {
		Receptionist receptionist = receptionistRepository.findById(id).orElseThrow(()->
									new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		ReceptionistDto recepDto = new ModelMapper().map(receptionist, ReceptionistDto.class );
		recepDto.setDeptId(receptionist.getDepartment().getDeptId());
		return recepDto;
	}

	@Override
	public ReceptionistDto updateById(int id, ReceptionistDto receptionistDto) {
		Receptionist receptionist = receptionistRepository.findById(id).orElseThrow(()->
									new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		receptionist.setReceptionistName(receptionistDto.getReceptionistName());
		receptionist.setReceptionistEmail(receptionistDto.getReceptionistEmail());
		receptionist.setReceptionistSalary(receptionistDto.getReceptionistSalary());
		receptionist.setReceptionistTimings(receptionistDto.getReceptionistTimings());
		ReceptionistDto recepDto = new ModelMapper().map(receptionistRepository.save(receptionist), ReceptionistDto.class );
		recepDto.setDeptId(receptionist.getDepartment().getDeptId());
		return recepDto;
	}

	@Override
	public ReceptionistDto deleteById(int id) {
		Receptionist receptionist = receptionistRepository.findById(id).orElseThrow(()->
									new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		receptionistRepository.deleteById(id);
		Department department = receptionist.getDepartment();
		department.setNoOfEmps(department.getNoOfEmps()-1);
		ReceptionistDto recepDto = new ModelMapper().map(receptionist, ReceptionistDto.class );
		recepDto.setDeptId(department.getDeptId());
		return recepDto;
	}

	
}
