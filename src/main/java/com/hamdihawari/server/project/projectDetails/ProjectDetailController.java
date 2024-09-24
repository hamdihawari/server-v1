package com.hamdihawari.server.project.projectDetails;

import com.hamdihawari.server.language.Language;
import com.hamdihawari.server.project.projectCard.ProjectCard;
import com.hamdihawari.server.language.LanguageRepository;
import com.hamdihawari.server.project.projectCard.ProjectCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project_details")
@CrossOrigin(origins = "http://localhost:5173")
public class ProjectDetailController {

    private final ProjectDetailService projectDetailService;
    private final ProjectCardRepository projectCardRepository;
    private final LanguageRepository languageRepository;

    @Autowired
    public ProjectDetailController(ProjectDetailService projectDetailService,
                                   ProjectCardRepository projectCardRepository,
                                   LanguageRepository languageRepository) {
        this.projectDetailService = projectDetailService;
        this.projectCardRepository = projectCardRepository;
        this.languageRepository = languageRepository;
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
        // Validate and fetch ProjectCard
        ProjectCard projectCard = projectCardRepository.findById(projectDetail.getProjectCard().getId())
                .orElse(null);
        if (projectCard == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Validate and fetch Language
        Language language = languageRepository.findById(projectDetail.getLanguage().getId())
                .orElse(null);
        if (language == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Set the validated ProjectCard and Language
        projectDetail.setProjectCard(projectCard);
        projectDetail.setLanguage(language);

        ProjectDetails savedProjectDetail = projectDetailService.createOrUpdateProjectDetail(projectDetail);
        return new ResponseEntity<>(savedProjectDetail, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDetails> updateProjectDetail(@PathVariable Long id, @RequestBody ProjectDetails projectDetail) {
        Optional<ProjectDetails> existingDetail = projectDetailService.getProjectDetailById(id);
        if (existingDetail.isPresent()) {
            ProjectDetails existingProjectDetail = existingDetail.get();

            // Validate and fetch ProjectCard
            ProjectCard projectCard = projectCardRepository.findById(projectDetail.getProjectCard().getId())
                    .orElse(null);
            if (projectCard == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            // Validate and fetch Language
            Language language = languageRepository.findById(projectDetail.getLanguage().getId())
                    .orElse(null);
            if (language == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            // Update the project detail fields
            existingProjectDetail.setProjectCard(projectCard);
            existingProjectDetail.setLanguage(language);
            existingProjectDetail.setSubjectDetails(projectDetail.getSubjectDetails());
            existingProjectDetail.setCardDescription(projectDetail.getCardDescription());

            ProjectDetails updatedProjectDetail = projectDetailService.createOrUpdateProjectDetail(existingProjectDetail);
            return new ResponseEntity<>(updatedProjectDetail, HttpStatus.OK);
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
