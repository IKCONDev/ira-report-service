package com.ikn.rms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ikn.rms.dto.DepartmentDto;
import com.ikn.rms.service.DepartmentServiceInterface;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequestMapping("/departments")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DepartmentController 
{
	
	@Autowired
	private  DepartmentServiceInterface departmentServiceImpl;

	@Autowired
	RestTemplate restTemplate;
	
	
	@PostMapping("/saveDepartment")
	public ResponseEntity<DepartmentDto> generateDepartment(@RequestBody DepartmentDto departmentDto)
	{
		log.info("generateDepartment() entered");
		DepartmentDto savedDepartment =  departmentServiceImpl.saveDepartment(departmentDto);
		log.info("generateDepartment() executed successfully..");
		return new ResponseEntity<>(savedDepartment,HttpStatus.CREATED);
	}

	    @GetMapping("/getDepartmentById/{id}")
	    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") Long departmentId) {
	        log.info("getDepartmentById() entered for departmentId: {}", departmentId);
	        DepartmentDto departmentDto = departmentServiceImpl.getDepartmentById(departmentId);
	        log.info("getDepartmentById() executed successfully for departmentId: {}", departmentId);
	        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
	    }

	    @PutMapping("/update")
	    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto) {
	        log.info("updateDepartment() entered with departmentDto: {}", departmentDto);
	        // Update the department
	        DepartmentDto updatedDepartmentDto = departmentServiceImpl.updateDepartment(departmentDto);
	        log.info("updateDepartment() executed successfully for departmentId: {}", updatedDepartmentDto);
	        return new ResponseEntity<>(updatedDepartmentDto, HttpStatus.PARTIAL_CONTENT);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
	        log.info("deleteDepartment() entered with departmentId: {}", id);
	        // Call the service to delete the department by ID
	        departmentServiceImpl.deleteDepartment(id);
	        log.info("deleteDepartment() executed successfully for departmentId: {}", id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    @GetMapping("/getAllDepartments")
	    public ResponseEntity<List<DepartmentDto>> getAllDepartments() {
	        log.info("getAllDepartments() entered");
	        List<DepartmentDto> departmentDtos = departmentServiceImpl.getAllDepartments();
	        log.info("getAllDepartments() executed successfully with {} departments", departmentDtos.size());
	        return new ResponseEntity<>(departmentDtos, HttpStatus.OK);
	    }
	}

	
	
	


