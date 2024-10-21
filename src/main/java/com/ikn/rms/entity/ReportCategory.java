package com.ikn.rms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportCategory 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long reportcategoryId;
private String reportcategoryName;
private String reportcategoryStatus;

}
