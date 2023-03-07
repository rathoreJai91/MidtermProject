package com.medicorps.serviceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicorps.dto.AdminDto;
import com.medicorps.dto.DepartmentDto;
import com.medicorps.dto.DoctorDto;
import com.medicorps.dto.ReceptionistDto;
import com.medicorps.dto.StaffDto;
import com.medicorps.dto.TestListDto;
import com.medicorps.exception.IdNotFoundException;
import com.medicorps.exception.NameNotNullException;
import com.medicorps.exception.NoContentAvailableException;
import com.medicorps.model.Admin;
import com.medicorps.model.Department;
import com.medicorps.model.Doctor;
import com.medicorps.model.Receptionist;
import com.medicorps.model.Staff;
import com.medicorps.model.TestList;
import com.medicorps.repository.AdminRepository;
import com.medicorps.repository.DepartmentRepository;
import com.medicorps.repository.DoctorRepository;
import com.medicorps.repository.ReceptionistRepository;
import com.medicorps.repository.StaffRepository;
import com.medicorps.repository.TestListRepository;
import com.medicorps.services.AdminService;
import com.medicorps.utility.AppConstant;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminRepo;
	@Autowired
	DepartmentRepository departmentRepo;
	@Autowired
	DoctorRepository docRepo;
	@Autowired
	ReceptionistRepository recepRepo;
	@Autowired
	StaffRepository staffRepo;
	@Autowired
	TestListRepository testListRepo;
	
	ModelMapper model = new ModelMapper();
	
	//ADMIN
	
	@Override
	public AdminDto addAdmin(AdminDto adminDto) {
		Admin admin = model.map(adminDto,Admin.class);
		return model.map(adminRepo.save(admin), AdminDto.class);
	}

	//DEPARTMENT
	
	@Override
	public DepartmentDto addDept(DepartmentDto departmentDto) {
		if(departmentDto.getDeptName()==null) {
			throw new NameNotNullException(AppConstant.NAME_NULL_MESSAGE);
		}
		Department department = model.map(departmentDto,Department.class);
		department.setNoOfEmps(0);
		return model.map(departmentRepo.save(department), DepartmentDto.class);
	}

	@Override
	public DepartmentDto deleteDeptById(int id) {
		Department dept = departmentRepo.findById(id).orElseThrow(()->
							new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		departmentRepo.deleteById(id);
		return model.map(dept, DepartmentDto.class);
	}

	@Override
	public List<DepartmentDto> viewAllDept() {
		List<Department> departments = departmentRepo.findAll();
		if(departments.isEmpty()) {
			throw new IdNotFoundException(AppConstant.LIST_NULL_MESSAGE); /// change this exception
		}
		List<DepartmentDto> departmentDtos = new ArrayList<>();
		for(Department department : departments) {
			departmentDtos.add(model.map(department, DepartmentDto.class));
		}
		return departmentDtos;
	}

	@Override
	public DepartmentDto viewDeptById(int id) {
		Department department = departmentRepo.findById(id).orElseThrow(()->
								new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		DepartmentDto departmentDto = model.map(department, DepartmentDto.class);
		return departmentDto;
	}

	@Override
	public DepartmentDto updateDept(DepartmentDto departmentDto) {
		Department department = departmentRepo.findById(departmentDto.getDeptId()).orElseThrow(()->
								new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		if(departmentDto.getDeptName()==null) {
			throw new NameNotNullException(AppConstant.NAME_NULL_MESSAGE);
		}
		department.setDeptName(departmentDto.getDeptName());
		department.setNoOfEmps(departmentDto.getNoOfEmps());
		return model.map(departmentRepo.save(department), DepartmentDto.class);
	}

	//DOCTOR
	
	@Override
	public DoctorDto addDocByDeptId(int id, DoctorDto doctorDto) {
		Department department = departmentRepo.findById(id).orElseThrow(()->
								new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		if(doctorDto.getDocName()==null) {
			throw new NameNotNullException(AppConstant.NAME_NULL_MESSAGE);
		}
		Doctor doctor = model.map(doctorDto, Doctor.class);
		doctor.setDateOfJoining(LocalDate.now());
		doctor.setDepartment(department);
		department.setNoOfEmps(department.getNoOfEmps()+1);
		departmentRepo.save(department);
		DoctorDto docDto = model.map(docRepo.save(doctor), DoctorDto.class );
		docDto.setDeptName(department.getDeptName());
		return docDto;
	}

	@Override
	public List<DoctorDto> viewAllDoctor() {
		List<Doctor> doctors = docRepo.findAll();
		if(doctors.isEmpty()) {
			throw new NoContentAvailableException(AppConstant.LIST_NULL_MESSAGE);
		}
		List<DoctorDto> doctorDtos = new ArrayList<>();
		for(Doctor doctor : doctors) {
			DoctorDto doc = model.map(doctor, DoctorDto.class);
			doc.setDeptName(doctor.getDepartment().getDeptName());
			doctorDtos.add(doc);
		}
		return doctorDtos;
	}

	@Override
	public List<DoctorDto> viewDocByDeptId(int id) {
		List<Doctor> doctors = departmentRepo.findById(id).orElseThrow(()->
								new IdNotFoundException(AppConstant.ID_NOT_MESSAGE)).getDoctors();
		if(doctors.isEmpty()) {
		throw new IdNotFoundException("no doctors available");
		}
		List<DoctorDto> doctorDtos = new ArrayList<>();
		for(Doctor doctor : doctors) {
		DoctorDto doc = model.map(doctor, DoctorDto.class);
		doc.setDeptName(doctor.getDepartment().getDeptName());
		doctorDtos.add(doc);
		}
		return doctorDtos;
	}

	@Override
	public DoctorDto viewDocById(int id) {
		Doctor doc = docRepo.findById(id).orElseThrow(()->
					new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		DoctorDto doctorDto = model.map(doc, DoctorDto.class);
		doctorDto.setDeptName(doc.getDepartment().getDeptName());
		return doctorDto;
	}

	@Override
	public DoctorDto updateDocById(DoctorDto doctorDto) {
		Doctor doc = docRepo.findById(doctorDto.getDocId()).orElseThrow(()->
					new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		doc.setDocName(doctorDto.getDocName());
		doc.setDocEmail(doctorDto.getDocEmail());
		doc.setDesignation(doctorDto.getDesignation());
		doc.setSpeciality(doctorDto.getSpeciality());
		doc.setExperience(doctorDto.getExperience());
		doc.setFees(doctorDto.getFees());
		doc.setDocSalary(doctorDto.getDocSalary());
		doc.setTimings(doctorDto.getTimings());
		DoctorDto docDto = model.map(docRepo.save(doc), DoctorDto.class);
		docDto.setDeptName(doc.getDepartment().getDeptName());
		return docDto;
	}

	@Override
	public DoctorDto deleteDocById(int id) {
		Doctor doc = docRepo.findById(id).orElseThrow(()->
					new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		Department department = doc.getDepartment();
		department.setNoOfEmps(department.getNoOfEmps()-1);
		departmentRepo.save(department);
		docRepo.deleteById(id);
		DoctorDto doctorDto = model.map(doc, DoctorDto.class);
		doctorDto.setDeptName(department.getDeptName());
		return doctorDto;
	}

	//RECEPTIONIST
	
	@Override
	public ReceptionistDto addRecepByDeptId(int id, ReceptionistDto receptionistDto) {
		Department department = departmentRepo.findById(id).orElseThrow(()->
				new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		Receptionist receptionist = new ModelMapper().map(receptionistDto, Receptionist.class);
		receptionist.setDepartment(department);
		department.setNoOfEmps(department.getNoOfEmps()+1);
		departmentRepo.save(department);
		receptionist.setDateOfJoining(LocalDate.now());
		ReceptionistDto recepDto = new ModelMapper().map(recepRepo.save(receptionist), ReceptionistDto.class );
		recepDto.setDeptName(department.getDeptName());
		return recepDto;
	}

	@Override
	public List<ReceptionistDto> viewRecepAll() {
		List<Receptionist> receptionists = recepRepo.findAll();
		if(receptionists.isEmpty()) {
			throw new NoContentAvailableException(AppConstant.LIST_NULL_MESSAGE);
		}
		List<ReceptionistDto> receptionistDtos = new ArrayList<>();
		for(Receptionist receptionist : receptionists) {
			ReceptionistDto recepDto = new ModelMapper().map(receptionist , ReceptionistDto.class);
			recepDto.setDeptName(receptionist.getDepartment().getDeptName());
			receptionistDtos.add(recepDto);
		}
		return receptionistDtos;
	}

	@Override
	public List<ReceptionistDto> viewRecepByDeptId(int id) {
		Department department = departmentRepo.findById(id).orElseThrow(()->
								new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		List<Receptionist> receptionists = department.getReceptionists();
		if(receptionists.isEmpty()) {
			throw new NoContentAvailableException(AppConstant.LIST_NULL_MESSAGE);
		}
		List<ReceptionistDto> receptionistDtos = new ArrayList<>();
		for(Receptionist receptionist : receptionists) {
		ReceptionistDto recepDto = new ModelMapper().map(receptionist , ReceptionistDto.class);
		recepDto.setDeptName(department.getDeptName());
		receptionistDtos.add(recepDto);
		}
		return receptionistDtos;
	}

	@Override
	public ReceptionistDto viewRecepById(int id) {
		Receptionist receptionist = recepRepo.findById(id).orElseThrow(()->
									new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		ReceptionistDto recepDto = new ModelMapper().map(receptionist, ReceptionistDto.class );
		recepDto.setDeptName(receptionist.getDepartment().getDeptName());
		return recepDto;
	}

	@Override
	public ReceptionistDto updateRecepById(int id, ReceptionistDto receptionistDto) {
		Receptionist receptionist = recepRepo.findById(id).orElseThrow(()->
									new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		receptionist.setReceptionistName(receptionistDto.getReceptionistName());
		receptionist.setReceptionistEmail(receptionistDto.getReceptionistEmail());
		receptionist.setReceptionistSalary(receptionistDto.getReceptionistSalary());
		receptionist.setReceptionistTimings(receptionistDto.getReceptionistTimings());
		ReceptionistDto recepDto = new ModelMapper().map(recepRepo.save(receptionist), ReceptionistDto.class );
		recepDto.setDeptName(receptionist.getDepartment().getDeptName());
		return recepDto;
	}

	@Override
	public ReceptionistDto deleteRecepById(int id) {
		Receptionist receptionist = recepRepo.findById(id).orElseThrow(()->
									new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		recepRepo.deleteById(id);
		Department department = receptionist.getDepartment();
		department.setNoOfEmps(department.getNoOfEmps()-1);
		departmentRepo.save(department);
		ReceptionistDto recepDto = new ModelMapper().map(receptionist, ReceptionistDto.class );
		recepDto.setDeptName(department.getDeptName());
		return recepDto;
	}

	//STAFF
	
	@Override
	public StaffDto addStaffByDeptId(int id, StaffDto staffDto) {
		Department department = departmentRepo.findById(id).orElseThrow(()->
								new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		Staff staff = new ModelMapper().map(staffDto,Staff.class);
		staff.setDateOfJoining(LocalDate.now());
		staff.setDepartment(department);
		department.setNoOfEmps(department.getNoOfEmps()+1);
		departmentRepo.save(department);
		StaffDto staffD = new ModelMapper().map(staffRepo.save(staff), StaffDto.class);
		staffD.setDeptName(department.getDeptName());
		return staffD;
	}

	@Override
	public List<StaffDto> viewStaffAll() {
		List<Staff> staffs = staffRepo.findAll();
		if(staffs.isEmpty()) {
			throw new IdNotFoundException(null);
		}
		List<StaffDto> staffDtos = new ArrayList<>();
		for(Staff staff : staffs) {
			StaffDto staffD = new ModelMapper().map(staff, StaffDto.class);
			staffD.setDeptName(staff.getDepartment().getDeptName());
			staffDtos.add(staffD);
		}
		return staffDtos;
	}

	@Override
	public List<StaffDto> viewStaffByDeptId(int id) {
		Department department = departmentRepo.findById(id).orElseThrow(()->
								new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		List<Staff> staffs = department.getStaff();
		if(staffs.isEmpty()) {
		throw new IdNotFoundException("No staff available");
		}
		List<StaffDto> staffDtos = new ArrayList<>();
		for(Staff staff : staffs) {
		StaffDto staffD = new ModelMapper().map(staff, StaffDto.class);
		staffD.setDeptName(staff.getDepartment().getDeptName());
		staffDtos.add(staffD);
		}
		return staffDtos;
	}

	@Override
	public StaffDto viewStaffById(int id) {
		Staff staff = staffRepo.findById(id).orElseThrow(()->
						new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		StaffDto staffDto = new ModelMapper().map(staff, StaffDto.class);
		staffDto.setDeptName(staff.getDepartment().getDeptName());
		return staffDto;
	}

	@Override
	public StaffDto updateStaffById(int id, StaffDto staffDto) {
		Staff staff = staffRepo.findById(id).orElseThrow(()->
						new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		staff.setStaffName(staffDto.getStaffName());
		staff.setStaffEmail(staffDto.getStaffEmail());
		staff.setStaffSalary(staffDto.getStaffSalary());
		staff.setStaffTiming(staffDto.getStaffTiming());
		StaffDto staffD = new ModelMapper().map(staff, StaffDto.class);
		staffD.setDeptName(staff.getDepartment().getDeptName());
		return staffD;
	}

	@Override
	public StaffDto deleteStaffById(int id) {
		Staff staff = staffRepo.findById(id).orElseThrow(()->
						new IdNotFoundException(AppConstant.ID_NOT_MESSAGE));
		Department department = staff.getDepartment();
		department.setNoOfEmps(department.getNoOfEmps()-1);
		departmentRepo.save(department);
		staffRepo.deleteById(id);
		StaffDto staffDto = new ModelMapper().map(staff, StaffDto.class);
		staffDto.setDeptName(department.getDeptName());
		return staffDto;
	}

	//TESTLIST
	
	@Override
	public TestListDto addTests(TestListDto testListDto) {
		TestList testList = model.map(testListDto, TestList.class);
		return model.map(testListRepo.save(testList),TestListDto.class);
	}

	@Override
	public List<TestListDto> viewAllTests() {
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
	public TestListDto updateTest(int id , TestListDto testDto) {
		TestList test = testListRepo.findById(id).orElseThrow(()->
						new IdNotFoundException("testNotFound"));
		test = model.map(testDto, TestList.class);
		return model.map(testListRepo.save(test),TestListDto.class);
	}

	@Override
	public TestListDto viewTestById(int id) {
		TestList test = testListRepo.findById(id).orElseThrow(()->
						new IdNotFoundException("Invalid Test Name"));
		return model.map(test, TestListDto.class);
	}

	@Override
	public TestListDto deleteTestById(int id) {
		TestList test = testListRepo.findById(id).orElseThrow(()->
						new IdNotFoundException("Invalid Test Id"));
		testListRepo.deleteById(id);
		return model.map(test, TestListDto.class);
	}

}
