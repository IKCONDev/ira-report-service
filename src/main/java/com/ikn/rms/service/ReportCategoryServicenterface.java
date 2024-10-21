package com.ikn.rms.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.ikn.rms.dto.ReportCategoryDto;

@Service
public interface ReportCategoryServicenterface {

	ReportCategoryDto savecategoryReport(ReportCategoryDto reportCategoryDto);
	ReportCategoryDto getReportCategoryById(Long reportCategoryId);



	ReportCategoryDto updateCategoryReport(ReportCategoryDto reportCategoryDto);

	void deleteCategoryReport(Long id);

	List<ReportCategoryDto> getAllCategoryReports();



	



	
}
