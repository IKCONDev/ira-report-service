package com.ikn.rms.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportCategoryDto 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long reportcategoryId;
private String reportcategoryName;
private String reportcategoryStatus;

}
