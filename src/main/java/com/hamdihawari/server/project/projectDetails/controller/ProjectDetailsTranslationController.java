package com.hamdihawari.server.project.projectDetails.controller;

import com.hamdihawari.server.project.language.entity.Language;
import com.hamdihawari.server.project.language.repository.LanguageRepository;
import com.hamdihawari.server.project.projectDetails.dto.ProjectDetailsTranslationDTO;
import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails;
import com.hamdihawari.server.project.projectDetails.entity.ProjectDetailsTranslation;
import com.hamdihawari.server.project.projectDetails.service.ProjectDetailsTranslationService;
import com.hamdihawari.server.project.projectDetails.service.ProjectDetailsService; // Import your service
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project_details_translation")
public class ProjectDetailsTranslationController {

    @Autowired
    private ProjectDetailsTranslationService projectDetailsTranslationService;

    @Autowired
    private ProjectDetailsService projectDetailsService;

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping
    public ResponseEntity<List<ProjectDetailsTranslation>> getAllProjectDetailsTranslations() {
        List<ProjectDetailsTranslation> translations = projectDetailsTranslationService.getAllTranslations();
        return ResponseEntity.ok(translations);
    }


    @PostMapping
    public ResponseEntity<ProjectDetailsTranslation> createTranslation(@RequestBody ProjectDetailsTranslationDTO translationDTO) {
        ProjectDetails projectDetails = projectDetailsService.findById(translationDTO.getProjectDetailsId())
                .orElseThrow(() -> new EntityNotFoundException("Project Details not found"));

        Language language = languageRepository.findById(translationDTO.getLanguageId())
                .orElseThrow(() -> new EntityNotFoundException("Language not found"));

        // Create the new translation
        ProjectDetailsTranslation translation = new ProjectDetailsTranslation();
        translation.setProjectDetails(projectDetails);
        translation.setLanguage(language);
        translation.setSubjectDetails(translationDTO.getSubjectDetails());
        translation.setCardDescription(translationDTO.getCardDescription());

        ProjectDetailsTranslation savedTranslation = projectDetailsTranslationService.saveTranslation(translation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTranslation);
    }


    @GetMapping("/project/{projectDetailsId}")
    public List<ProjectDetailsTranslation> getTranslationsByProjectDetailsId(@PathVariable Long projectDetailsId) {
        return projectDetailsTranslationService.getTranslationsByProjectDetailsId(projectDetailsId);
    }

    @GetMapping("/project/{projectDetailsId}/language/{languageCode}")
    public ResponseEntity<ProjectDetailsTranslation> getProjectDetailsTranslationByLanguage(
            @PathVariable Long projectDetailsId, @PathVariable String languageCode) {
        ProjectDetailsTranslation translation = projectDetailsTranslationService
                .getTranslationByProjectDetailsAndLanguage(projectDetailsId, languageCode);
        return translation != null ? ResponseEntity.ok(translation) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDetailsTranslation> updateTranslation(
            @PathVariable Long id, @RequestBody ProjectDetailsTranslation translation) {
        ProjectDetailsTranslation updatedTranslation = projectDetailsTranslationService.updateTranslation(id, translation);
        return updatedTranslation != null ? ResponseEntity.ok(updatedTranslation) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable Long id) {
        projectDetailsTranslationService.deleteTranslation(id);
        return ResponseEntity.noContent().build();
    }
}



// this without dto and working well
/*
package com.hamdihawari.server.project.projectDetails.controller;

import com.hamdihawari.server.project.projectDetails.entity.ProjectDetailsTranslation;
import com.hamdihawari.server.project.projectDetails.service.ProjectDetailsTranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project_details_translation")
public class ProjectDetailsTranslationController {

    @Autowired
    private ProjectDetailsTranslationService projectDetailsTranslationService; // Correctly autowire the service

    // Get all project details translations
    @GetMapping
    public ResponseEntity<List<ProjectDetailsTranslation>> getAllProjectDetailsTranslations() {
        List<ProjectDetailsTranslation> translations = projectDetailsTranslationService.getAllTranslations();
        return ResponseEntity.ok(translations);
    }

    // Get translations by project details ID
    @GetMapping("/project/{projectDetailsId}")
    public List<ProjectDetailsTranslation> getTranslationsByProjectDetailsId(@PathVariable Long projectDetailsId) {
        return projectDetailsTranslationService.getTranslationsByProjectDetailsId(projectDetailsId);
    }

    // Get translation by project details ID and language code
    @GetMapping("/project/{projectDetailsId}/language/{languageCode}")
    public ResponseEntity<ProjectDetailsTranslation> getProjectDetailsTranslationByLanguage(
            @PathVariable Long projectDetailsId, @PathVariable String languageCode) {
        ProjectDetailsTranslation translation = projectDetailsTranslationService
                .getTranslationByProjectDetailsAndLanguage(projectDetailsId, languageCode);
        return translation != null ? ResponseEntity.ok(translation) : ResponseEntity.notFound().build();
    }

    // Create a new translation
    @PostMapping
    public ProjectDetailsTranslation createTranslation(@RequestBody ProjectDetailsTranslation translation) {
        return projectDetailsTranslationService.saveTranslation(translation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDetailsTranslation> updateTranslation(
            @PathVariable Long id, @RequestBody ProjectDetailsTranslation translation) {
        System.out.println("Updating translation with ID: " + id);
        ProjectDetailsTranslation updatedTranslation = projectDetailsTranslationService.updateTranslation(id, translation);
        return updatedTranslation != null ? ResponseEntity.ok(updatedTranslation) : ResponseEntity.notFound().build();
    }

    // Delete a translation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable Long id) {
        projectDetailsTranslationService.deleteTranslation(id);
        return ResponseEntity.noContent().build();
    }
}
*/
