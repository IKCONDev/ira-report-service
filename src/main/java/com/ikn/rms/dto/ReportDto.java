package com.ikn.rms.dto;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reportId;
	private String priority;
	private String reportName;
	private String reportType;
	private String reportDescription;
	private String departmentName;
	private String reportGeneratedForm;
	private String reportFrequency;
	private String bussinessOwner;
	private String itOwner;
	private String qaOwner;
	private String developerName;
	private String bussinessAnalystName;
	private String qualityAssuranceName;
	private String itLead;
	private String qaLead;
	private String reportVersion;
	private LocalDateTime releaseDate;
	private String comments;

}
