package com.ikn.rms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ikn.rms.Exceptions.DepartmentNotFoundException;
import com.ikn.rms.dto.DepartmentDto;
import com.ikn.rms.entity.Department;
import com.ikn.rms.repository.DepartmentRepository;
import com.ikn.rms.service.DepartmentServiceInterface;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentServiceInterface
{
	

	@Autowired
	DepartmentRepository departmentRepository;
	
    @Autowired
	RestTemplate restTemplate;

	@Autowired
	ModelMapper mapper;

	@Transactional
	@Override
	public DepartmentDto saveDepartment(DepartmentDto dto) {
	    log.info("saveDepartment() entered");
	    
	    // Convert DTO to entity using mapper
	    Department entity = new Department();
	    mapper.map(dto, entity);
	    
	    // Save department in database
	    Department savedDepartment = departmentRepository.save(entity);
	    
	    // Convert saved entity back to DTO
	    DepartmentDto savedDepartmentDto = new DepartmentDto();
	    mapper.map(savedDepartment, savedDepartmentDto);
	    
	    log.info("saveDepartment() executed successfully");
	    return savedDepartmentDto;
	
}

	@Override
	public DepartmentDto getDepartmentById(Long departmentId) {
	    log.info("getDepartmentById() entered with departmentId: {}", departmentId);

	    // Fetch the department from the repository
	    Department department = departmentRepository.findById(departmentId)
	            .orElseThrow(() -> new DepartmentNotFoundException("Department not found for Id: " + departmentId));

	    // Convert the Department entity to DepartmentDto
	    DepartmentDto departmentDto = mapper.map(department, DepartmentDto.class);

	    log.info("getDepartmentById() executed successfully for departmentId: {}", departmentId);
	    return departmentDto;
	}

	@Transactional
	@Override
	public DepartmentDto updateDepartment(DepartmentDto dto) {
	    log.info("updateDepartment() entered with departmentDto: {}", dto);
	    System.out.println("return updatedDepartment: " + dto);
	    Department existingDepartment =new  Department();
	    // Fetch the existing department from the repository
	   // Department existingDepartment = departmentRepository.findById(dto.getdepartmentId())
	           // .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + dto.getIdepartmentd()));

	    // Update fields from DTO to the existing entity
	    mapper.map(dto, existingDepartment);

	    // Save the updated department
	    Department savedDepartment = departmentRepository.save(existingDepartment);

	    // Convert the updated entity to DTO
	    DepartmentDto savedDepartmentDto = new DepartmentDto();
	    mapper.map(savedDepartment, savedDepartmentDto);

	    log.info("updateDepartment() executed successfully for departmentId: {}", savedDepartmentDto.getDepartmentId());
	    return savedDepartmentDto;
	}


	@Override
	public void deleteDepartment(Long id) {
	    log.info("deleteDepartment() entered with departmentId: {}", id);

	    // Check if the department is available
	    Department department = departmentRepository.findById(id)
	            .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id: " + id));

	    // Delete the department
	    departmentRepository.delete(department);
	    log.info("deleteDepartment() executed successfully for departmentId: {}", id);
	}

	@Override
	public List<DepartmentDto> getAllDepartments() {
	    log.info("getAllDepartments() entered");
	    List<Department> departments = departmentRepository.findAll();
	    List<DepartmentDto> departmentDtos = new ArrayList<>();

	    // Convert each Department entity to DepartmentDto and add to the list
	    for (Department department : departments) {
	        DepartmentDto dto = mapper.map(department, DepartmentDto.class);
	        departmentDtos.add(dto);
	    }

	    log.info("getAllDepartments() executed successfully with {} departments", departmentDtos.size());
	    return departmentDtos;
	}
}