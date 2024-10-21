package com.ikn.rms.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Report 
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
