package com.hamdihawari.server.project.projectDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project-details")
@CrossOrigin(origins = "http://localhost:5173")
public class ProjectDetailController {

    private final ProjectDetailService projectDetailService;

    @Autowired
    public ProjectDetailController(ProjectDetailService projectDetailService) {
        this.projectDetailService = projectDetailService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectDetails>> getAllProjectDetails() {
        return new ResponseEntity<>(projectDetailService.getAllProjectDetails(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDetails> getProjectDetailById(@PathVariable Long id) {
        Optional<ProjectDetails> projectDetail = projectDetailService.getProjectDetailById(id);
        return projectDetail.map(detail -> new ResponseEntity<>(detail, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProjectDetails> createProjectDetail(@RequestBody ProjectDetails projectDetail) {
        return new ResponseEntity<>(projectDetailService.createOrUpdateProjectDetail(projectDetail), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDetails> updateProjectDetail(@PathVariable Long id, @RequestBody ProjectDetails projectDetail) {
        Optional<ProjectDetails> existingDetail = projectDetailService.getProjectDetailById(id);
        if (existingDetail.isPresent()) {
            projectDetail.setId(id); // Ensure the setter exists
            return new ResponseEntity<>(projectDetailService.createOrUpdateProjectDetail(projectDetail), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectDetail(@PathVariable Long id) {
        Optional<ProjectDetails> existingDetail = projectDetailService.getProjectDetailById(id);
        if (existingDetail.isPresent()) {
            projectDetailService.deleteProjectDetail(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
