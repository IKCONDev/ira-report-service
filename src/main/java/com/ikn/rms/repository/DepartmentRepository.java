package com.ikn.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikn.rms.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
