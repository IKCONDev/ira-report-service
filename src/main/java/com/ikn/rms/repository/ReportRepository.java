package com.ikn.rms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ikn.rms.entity.Report;
@Repository
public interface ReportRepository  extends JpaRepository<Report, Long>{

}
