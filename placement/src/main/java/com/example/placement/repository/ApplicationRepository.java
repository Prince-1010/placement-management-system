package com.example.placement.repository;

import com.example.placement.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity,Long> {
    List<ApplicationEntity> findByJobId(Long jobId);
}
