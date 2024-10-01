package com.hamdihawari.server.project.projectDetails.service;

import com.hamdihawari.server.project.projectDetails.entity.ProjectDetailsTranslation;
import com.hamdihawari.server.project.projectDetails.repository.ProjectDetailsTranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectDetailsTranslationService {

    @Autowired
    private ProjectDetailsTranslationRepository projectDetailsTranslationRepository;

    public List<ProjectDetailsTranslation> getAllTranslations() {
        return projectDetailsTranslationRepository.findAll();
    }

    public List<ProjectDetailsTranslation> getTranslationsByProjectDetailsId(Long projectDetailsId) {
        return projectDetailsTranslationRepository.findByProjectDetailsId(projectDetailsId);
    }

    public ProjectDetailsTranslation saveTranslation(ProjectDetailsTranslation translation) {
        return projectDetailsTranslationRepository.save(translation);
    }

    public ProjectDetailsTranslation getTranslationByProjectDetailsAndLanguage(Long projectDetailsId, String languageCode) {
        return projectDetailsTranslationRepository.findByProjectDetailsIdAndLanguageName(projectDetailsId, languageCode);
    }

    public void deleteTranslation(Long id) {
        projectDetailsTranslationRepository.deleteById(id);
    }

    // Update
    public ProjectDetailsTranslation updateTranslation(Long id, ProjectDetailsTranslation translation) {
        if (projectDetailsTranslationRepository.existsById(id)) {
            translation.setId(id); // Ensure the ID is set for the update
            return projectDetailsTranslationRepository.save(translation);
        }
        return null; // Return null if the translation with the given ID doesn't exist
    }
}





// this without dto and working well
/*
package com.hamdihawari.server.project.projectDetails.service;

import com.hamdihawari.server.project.projectDetails.entity.ProjectDetailsTranslation;
import com.hamdihawari.server.project.projectDetails.repository.ProjectDetailsTranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectDetailsTranslationService {

    @Autowired
    private ProjectDetailsTranslationRepository projectDetailsTranslationRepository;

    public List<ProjectDetailsTranslation> getAllTranslations() {
        return projectDetailsTranslationRepository.findAll();
    }

    public List<ProjectDetailsTranslation> getTranslationsByProjectDetailsId(Long projectDetailsId) {
        return projectDetailsTranslationRepository.findByProjectDetailsId(projectDetailsId);
    }

    public ProjectDetailsTranslation saveTranslation(ProjectDetailsTranslation translation) {
        return projectDetailsTranslationRepository.save(translation);
    }

    public ProjectDetailsTranslation getTranslationByProjectDetailsAndLanguage(Long projectDetailsId, String languageCode) {
        return projectDetailsTranslationRepository.findByProjectDetailsIdAndLanguageName(projectDetailsId, languageCode);
    }

    public void deleteTranslation(Long id) {
        projectDetailsTranslationRepository.deleteById(id);
    }

    // Update
    public ProjectDetailsTranslation updateTranslation(Long id, ProjectDetailsTranslation translation) {
        if (projectDetailsTranslationRepository.existsById(id)) {
            translation.setId(id); // Ensure the ID is set for the update
            return projectDetailsTranslationRepository.save(translation);
        }
        return null; // Return null if the translation with the given ID doesn't exist
    }

}
*/
