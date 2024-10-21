package com.ikn.rms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ikn.rms.dto.DepartmentDto;

@Service
public interface DepartmentServiceInterface {

	DepartmentDto saveDepartment(DepartmentDto departmentDto);

	DepartmentDto getDepartmentById(Long departmentId);

	DepartmentDto updateDepartment(DepartmentDto departmentDto);

	void deleteDepartment(Long id);

	List<DepartmentDto> getAllDepartments();

}
