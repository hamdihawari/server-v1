package com.hamdihawari.server.project.projectDetails.controller;

import com.hamdihawari.server.project.language.entity.Language;
import com.hamdihawari.server.project.projectDetails.dto.ProjectDetailsTranslationDTO;
import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails;
import com.hamdihawari.server.project.projectDetails.entity.ProjectDetailsTranslation;
import com.hamdihawari.server.project.projectDetails.service.ProjectDetailsTranslationService;
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

    // Create a new translation using DTO
    @PostMapping
    public ResponseEntity<ProjectDetailsTranslation> createTranslation(@RequestBody ProjectDetailsTranslationDTO translationDTO) {
        ProjectDetailsTranslation translation = new ProjectDetailsTranslation();
        translation.setProjectDetails(new ProjectDetails(translationDTO.getProjectDetailsId())); // Ensure this constructor exists
        translation.setLanguage(new Language(translationDTO.getLanguageId())); // Ensure this constructor exists
        translation.setSubjectDetails(translationDTO.getSubjectDetails());
        translation.setCardDescription(translationDTO.getCardDescription());

        ProjectDetailsTranslation savedTranslation = projectDetailsTranslationService.saveTranslation(translation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTranslation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDetailsTranslation> updateTranslation(
            @PathVariable Long id, @RequestBody ProjectDetailsTranslation translation) {
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
