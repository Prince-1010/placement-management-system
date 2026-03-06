package com.example.placement.repository;

import com.example.placement.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity,Long> {

}
