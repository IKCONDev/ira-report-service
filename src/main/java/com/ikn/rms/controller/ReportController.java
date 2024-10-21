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
import com.ikn.rms.dto.ReportDto;
import com.ikn.rms.service.ReportServiceInterface;


import lombok.extern.slf4j.Slf4j;


@RequestMapping("/report")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReportController
{
	@Autowired
	private  ReportServiceInterface reportServiceImpl;

	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("/saveReport")
	public ResponseEntity<ReportDto> generateReport(@RequestBody ReportDto reportDto)
	{
		log.info("generateReport() entered");
		ReportDto savedReport =  reportServiceImpl.saveReport(reportDto);
		log.info("generateReport() executed successfully..");
		return new ResponseEntity<>(savedReport,HttpStatus.CREATED);
	}
	
	
	 @GetMapping("/getReportById/{id}")
	    public ResponseEntity<ReportDto> getReportById(@PathVariable("id") Long reportId) {
	        log.info("getReportById() entered for reportId: {}", reportId);
	        ReportDto reportDto = reportServiceImpl.getReportById(reportId);
	        log.info("getReportById() executed successfully for reportId: {}", reportId);
	        return new ResponseEntity<>(reportDto, HttpStatus.OK);
	    }

	    @PutMapping("/update")
	    public ResponseEntity<ReportDto> updateReport(@RequestBody ReportDto reportDto) {
	        log.info("updateReport() entered with reportDto: {}", reportDto);
	        // Update the report
	        ReportDto updatedReportDto = reportServiceImpl.updateReport(reportDto);
	        log.info("updateReport() executed successfully for reportId: {}", updatedReportDto);
	        return new ResponseEntity<>(updatedReportDto, HttpStatus.PARTIAL_CONTENT);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Boolean> deleteReport(@PathVariable Long id) {
	        log.info("deleteReport() entered with reportId: {}", id);
	        // Call the service to delete the report by ID
	        reportServiceImpl.deleteReport(id);
	        log.info("deleteReport() executed successfully for reportId: {}", id);
	        return new ResponseEntity<>(true,HttpStatus.NO_CONTENT);
	    }

	    @GetMapping("/getAllReports")
	    public ResponseEntity<List<ReportDto>> getAllReports() {
	        log.info("getAllReports() entered");
	        List<ReportDto> reportDtos = reportServiceImpl.getAllReports();
	        log.info("getAllReports() executed successfully with {} reports", reportDtos.size());
	        return new ResponseEntity<>(reportDtos, HttpStatus.OK);
	    }
	}
	

	
	