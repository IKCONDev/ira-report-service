package com.ikn.rms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ikn.rms.dto.ReportDto;

@Service
public interface ReportServiceInterface
{

	ReportDto saveReport(ReportDto reportDto);

	ReportDto getReportById(Long reportId);

	ReportDto updateReport(ReportDto reportDto);

	void deleteReport(Long id);

	List<ReportDto> getAllReports();

	
}
