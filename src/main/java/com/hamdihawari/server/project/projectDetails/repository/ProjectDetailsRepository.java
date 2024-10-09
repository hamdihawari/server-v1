package com.hamdihawari.server.project.projectDetails.repository;

import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails, Long> {
    // Other query methods can be added here
    ProjectDetails findByProjectCardId(Long projectCardId);
}
