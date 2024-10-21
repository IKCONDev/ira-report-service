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

import com.ikn.rms.dto.ReportCategoryDto;
import com.ikn.rms.service.ReportCategoryServicenterface;

import lombok.extern.slf4j.Slf4j;



@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j

public class ReportCategoryController
{

	@Autowired
	private  ReportCategoryServicenterface reportcategoryServiceImpl;

	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/saveReportCategory")
	public ResponseEntity<ReportCategoryDto> generateCategoryReport(@RequestBody ReportCategoryDto reportCategoryDto)
	{
		log.info("generateCategoryReport() entered");
		ReportCategoryDto savedCategoryReport =  reportcategoryServiceImpl.savecategoryReport(reportCategoryDto);
		log.info("generateReport() executed successfully..");
		return new ResponseEntity<>(savedCategoryReport,HttpStatus.CREATED);
	}
	
	
	 @GetMapping("/getCategoryReportById/{id}")
	    public ResponseEntity<ReportCategoryDto> getReportById(@PathVariable("id") Long reportCategoryId) {
	        log.info("getReportCategoryById() entered for categoryId: {}", reportCategoryId);
	        ReportCategoryDto reportCategoryDto = reportcategoryServiceImpl.getReportCategoryById(reportCategoryId);
	        log.info("getReportById() executed successfully for categoryId: {}", reportCategoryId);
	        return new ResponseEntity<>(reportCategoryDto, HttpStatus.OK);
	    }

	    @PutMapping("/updateCategory")
	    public ResponseEntity<ReportCategoryDto> updateCategoryReport(@RequestBody ReportCategoryDto reportCategoryDto) {
	        log.info("updateCategoryReport() entered with reportCategorysDto: {}", reportCategoryDto);
	        // Update the report
	        ReportCategoryDto updatedCategoryDto = reportcategoryServiceImpl.updateCategoryReport(reportCategoryDto);
	        log.info("updateReport() executed successfully for reportId: {}", updatedCategoryDto);
	        return new ResponseEntity<>(updatedCategoryDto, HttpStatus.PARTIAL_CONTENT);
	    }

	    @DeleteMapping("/deleteCategory/{id}")
	    public ResponseEntity<Void> deleteCategoryReport(@PathVariable Long id) {
	        log.info("deleteCategoryReport() entered with CategoryId: {}", id);
	        // Call the service to delete the report by ID
	        reportcategoryServiceImpl.deleteCategoryReport(id);
	        log.info("deleteReport() executed successfully for CategoryId: {}", id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    @GetMapping("/getAllReportCategories")
	    public ResponseEntity<List<ReportCategoryDto>> getAllCategoryReports() {
	        log.info("getAllCategoryReports() entered");
	        List<ReportCategoryDto> reportCategoryDtos = reportcategoryServiceImpl.getAllCategoryReports();
	        log.info("getAllReports() executed successfully with {} reports", reportCategoryDtos.size());
	        return new ResponseEntity<>(reportCategoryDtos, HttpStatus.OK);
	    }
	}
	

	

	

