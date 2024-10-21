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
public class Department
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long departmentId;
private String departmentName;
private String departmentStatus;
}
