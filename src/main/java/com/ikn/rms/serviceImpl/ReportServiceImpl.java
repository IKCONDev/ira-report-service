package com.ikn.rms.serviceImpl;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ikn.rms.Exceptions.ReportNotFoundException;
import com.ikn.rms.dto.ReportDto;
import com.ikn.rms.entity.Report;
import com.ikn.rms.repository.ReportRepository;
import com.ikn.rms.service.ReportServiceInterface;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReportServiceImpl implements ReportServiceInterface
{

	@Autowired
	ReportRepository reportRepository;
	
    @Autowired
	RestTemplate restTemplate;

	@Autowired
	ModelMapper mapper;

	@Transactional
	@Override
    public ReportDto saveReport(ReportDto dto) {
        log.info("saveReport() entered");
        
        // Convert Dto to entity using mapper
        Report entity = new Report();
        mapper.map(dto, entity);
        
        // Save report in database
        Report savedReport = reportRepository.save(entity);
        
        // Convert saved entity back to DTO
        ReportDto savedReportDto = new ReportDto();
        mapper.map(savedReport, savedReportDto);
        
        log.info("saveReport() executed successfully");
        return savedReportDto;
    }

	   @Override
	    public ReportDto getReportById(Long reportId) {
	        log.info("getReportById() entered with reportId: {}", reportId);

	        // Fetch the report from the repository
	        Report report = reportRepository.findById(reportId)
	                .orElseThrow(() -> new ReportNotFoundException("Report not found for Id: " + reportId));

	        // Convert the Report entity to ReportDto
	        ReportDto reportDto = mapper.map(report, ReportDto.class);

	        log.info("getReportById() executed successfully for reportId: {}", reportId);
	        return reportDto;
	    }
	
	   @Override
	   public ReportDto updateReport(ReportDto dto) {
	       log.info("updateReport() entered with reportDto: {}", dto);
	       System.out.println("return updatedReport: "+dto);
	       Report existingReport =new  Report();
	       // Fetch the existing report from the repository
	      // Report existingReport = reportRepository.findById(dto.getReportId())
	      //     .orElseThrow(() -> new ReportNotFoundException("Report not found with id: " + dto.getReportId()));
	       
	       // Update fields from DTO to the existing entity
	       mapper.map(dto, existingReport);
	       
	       // Save the updated report
	       Report savedReport = reportRepository.save(existingReport);
	       
	       // Convert the updated entity to DTO
	       ReportDto savedReportDto = new ReportDto();
	       mapper.map(savedReport, savedReportDto);
	       
	       log.info("updateReport() executed successfully for reportId: {}", savedReportDto.getReportId());
	       return savedReportDto;
	   }

	
	   @Override
	   public void deleteReport(Long reportId) {
	       log.info("deleteReport() entered with reportId: {}", reportId);
	       
	       // Check if the report is available
	       Report report = reportRepository.findById(reportId)
	           .orElseThrow(() -> new ReportNotFoundException("Report not found with id: " + reportId));
	       
	       // Delete the report
	       reportRepository.delete(report);
	       log.info("deleteReport() executed successfully for reportId: {}", reportId);
	   }
	   @Override
	   public List<ReportDto> getAllReports() {
	       log.info("getAllReports() entered");
	       List<Report> reports = reportRepository.findAll();
	       List<ReportDto> reportDtos = new ArrayList<>();
	       
	       // Convert each Report entity to ReportDto and add to the list
	       for (Report report : reports) {
	           ReportDto dto = new ReportDto();
	           mapper.map(report, dto);
	           
	           reportDtos.add(dto);
	       }
	       
	       log.info("getAllReports() executed successfully with {} reports", reportDtos.size());
	       return reportDtos;
	   }
}


	