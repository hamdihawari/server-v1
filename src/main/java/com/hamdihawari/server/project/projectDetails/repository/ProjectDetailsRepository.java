package com.hamdihawari.server.project.projectDetails.repository;

import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails, Long> {

    ProjectDetails findByProjectCardId(Long projectCardId);

    // New method to retrieve all project details
    List<ProjectDetails> findAll();
}
