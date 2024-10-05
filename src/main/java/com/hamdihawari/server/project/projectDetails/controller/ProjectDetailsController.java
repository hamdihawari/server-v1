package com.hamdihawari.server.project.projectDetails.controller;

import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails;
import com.hamdihawari.server.project.projectDetails.service.ProjectDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project_details")
public class ProjectDetailsController {

    @Autowired
    private ProjectDetailsService projectDetailsService;

    @Autowired
    public ProjectDetailsController(ProjectDetailsService projectDetailsService) {
        this.projectDetailsService = projectDetailsService;
    }

    // Get project details by projectCardId
    @GetMapping("/{projectCardId}")
    public ResponseEntity<ProjectDetails> getProjectDetailsByProjectCardId(@PathVariable Long projectCardId) {
        ProjectDetails details = projectDetailsService.getProjectDetailsByProjectCardId(projectCardId);
        return details != null ? ResponseEntity.ok(details) : ResponseEntity.notFound().build();
    }

    // Get all project details
    @GetMapping
    public ResponseEntity<List<ProjectDetails>> getAllProjectDetails() {
        List<ProjectDetails> detailsList = projectDetailsService.getAllProjectDetails();
        return ResponseEntity.ok(detailsList);
    }

    // Create new project details
    @PostMapping
    public ProjectDetails createProjectDetails(@RequestBody ProjectDetails projectDetails) {
        return projectDetailsService.saveProjectDetails(projectDetails);
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
        return updatedDetails != null ? ResponseEntity.ok(updatedDetails) : ResponseEntity.notFound().build();
    }

}
