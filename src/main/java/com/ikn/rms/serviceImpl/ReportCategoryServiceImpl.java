package com.ikn.rms.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ikn.rms.Exceptions.ReportCategoryNotFoundException;
import com.ikn.rms.dto.ReportCategoryDto;
import com.ikn.rms.entity.ReportCategory;
import com.ikn.rms.repository.ReportCategoryRepository;
import com.ikn.rms.repository.ReportRepository;
import com.ikn.rms.service.ReportCategoryServicenterface;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
@Slf4j

@Service
public class ReportCategoryServiceImpl implements ReportCategoryServicenterface
{

	@Autowired
	ReportCategoryRepository reportCategoryRepository;
	
    @Autowired
	RestTemplate restTemplate;

	@Autowired
	ModelMapper mapper;

	
	@Transactional
	@Override
	public com.ikn.rms.dto.ReportCategoryDto savecategoryReport(com.ikn.rms.dto.ReportCategoryDto reportCategoryDto) {
		
		{
	    log.info("saveReportCategory() entered");

	    // Convert Dto to entity using mapper
	    ReportCategory entity = new ReportCategory();
	    mapper.map(reportCategoryDto, entity);

	    // Save report category in the database
	    ReportCategory savedCategory = reportCategoryRepository.save(entity);

	    // Convert saved entity back to DTO
	    ReportCategoryDto savedCategoryDto = new ReportCategoryDto();
	    mapper.map(savedCategory, savedCategoryDto);

	    log.info("saveReportCategory() executed successfully");
	    return savedCategoryDto;
		}
	}

	@Override
	public ReportCategoryDto getReportCategoryById(Long reportCategoryId) {
	    log.info("getReportCategoryById() entered with reportCategoryId: {}", reportCategoryId);

	    // Fetch the report category from the repository
	    ReportCategory category = reportCategoryRepository.findById(reportCategoryId)
	            .orElseThrow(() -> new ReportCategoryNotFoundException("Report category not found for Id: " + reportCategoryId));

	    // Convert the ReportCategory entity to ReportCategoryDto
	    ReportCategoryDto categoryDto = mapper.map(category, ReportCategoryDto.class);

	    log.info("getReportCategoryById() executed successfully for reportCategoryId: {}", reportCategoryId);
	    return categoryDto;
	}

	@Override
	public ReportCategoryDto updateCategoryReport(ReportCategoryDto reportCategoryDto) {
	    log.info("updateCategoryReport() entered with reportCategoryDto: {}", reportCategoryDto);

	    // Fetch the existing report category from the repository
	    ReportCategory existingCategory = reportCategoryRepository.findById(reportCategoryDto.getReportcategoryId())
	            .orElseThrow(() -> new ReportCategoryNotFoundException("Report category not found with id: " + reportCategoryDto.getReportcategoryId()));

	    // Update fields from DTO to the existing entity
	    mapper.map(reportCategoryDto, existingCategory);

	    // Save the updated report category
	    ReportCategory savedCategory = reportCategoryRepository.save(existingCategory);

	    // Convert the updated entity to DTO
	    ReportCategoryDto savedCategoryDto = mapper.map(savedCategory, ReportCategoryDto.class);

	    log.info("updateCategoryReport() executed successfully for categoryId: {}", savedCategoryDto.getReportcategoryId());
	    return savedCategoryDto;
	}

	@Override
	public void deleteCategoryReport(Long id) {
	    log.info("deleteCategoryReport() entered with categoryId: {}", id);

	    // Check if the report category is available
	    ReportCategory category = reportCategoryRepository.findById(id)
	            .orElseThrow(() -> new ReportCategoryNotFoundException("Report category not found with id: " + id));

	    // Delete the report category
	    reportCategoryRepository.delete(category);
	    log.info("deleteCategoryReport() executed successfully for categoryId: {}", id);
	}

	@Override
	public List<ReportCategoryDto> getAllCategoryReports() {
	    log.info("getAllCategoryReports() entered");
	    List<ReportCategory> categories = reportCategoryRepository.findAll();
	    List<ReportCategoryDto> categoryDtos = new ArrayList<>();

	    // Convert each ReportCategory entity to ReportCategoryDto and add to the list
	    for (ReportCategory category : categories) {
	        ReportCategoryDto dto = mapper.map(category, ReportCategoryDto.class);
	        categoryDtos.add(dto);
	    }

	    log.info("getAllCategoryReports() executed successfully with {} categories", categoryDtos.size());
	    return categoryDtos;
	}

	
}