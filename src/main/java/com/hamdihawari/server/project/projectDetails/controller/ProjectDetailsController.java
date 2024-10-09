package com.hamdihawari.server.project.projectDetails.controller;

import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails;
import com.hamdihawari.server.project.projectDetails.service.ProjectDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project_details")
public class ProjectDetailsController {

    private final ProjectDetailsService projectDetailsService;

    @Autowired
    public ProjectDetailsController(ProjectDetailsService projectDetailsService) {
        this.projectDetailsService = projectDetailsService;
    }

    // Get project details by projectCardId
    @GetMapping("/{projectCardId}")
    public ResponseEntity<ProjectDetails> getProjectDetailsByProjectCardId(@PathVariable Long projectCardId) {
        ProjectDetails details = projectDetailsService.getProjectDetailsByProjectCardId(projectCardId);
        return ResponseEntity.of(Optional.ofNullable(details));
    }

    // Get all project details
    @GetMapping
    public ResponseEntity<List<ProjectDetails>> getAllProjectDetails() {
        List<ProjectDetails> detailsList = projectDetailsService.getAllProjectDetails();
        return ResponseEntity.ok(detailsList);
    }

    // Create new project details
    @PostMapping
    public ResponseEntity<ProjectDetails> createProjectDetails(@RequestBody ProjectDetails projectDetails) {
        ProjectDetails createdDetails = projectDetailsService.saveProjectDetails(projectDetails);
        return ResponseEntity.status(201).body(createdDetails); // 201 Created
    }

    // Delete project details by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectDetails(@PathVariable Long id) {
        projectDetailsService.deleteProjectDetails(id);
        return ResponseEntity.noContent().build();
    }

    // Update existing project details by ID
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDetails> updateProjectDetails(
            @PathVariable Long id,
            @RequestBody ProjectDetails projectDetails) {
        ProjectDetails updatedDetails = projectDetailsService.updateProjectDetails(id, projectDetails);
        return ResponseEntity.of(Optional.ofNullable(updatedDetails));
    }
}
