package com.hamdihawari.server.project.projectCard.service;

import com.hamdihawari.server.project.language.entity.Language;
import com.hamdihawari.server.project.language.repository.LanguageRepository;
import com.hamdihawari.server.project.projectCard.dto.ProjectCardTranslationDTO;
import com.hamdihawari.server.project.projectCard.entity.ProjectCard;
import com.hamdihawari.server.project.projectCard.entity.ProjectCardTranslation;
import com.hamdihawari.server.project.projectCard.repository.ProjectCardRepository;
import com.hamdihawari.server.project.projectCard.repository.ProjectCardTranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectCardTranslationService {

    @Autowired
    private ProjectCardTranslationRepository projectCardTranslationRepository;

    @Autowired
    private ProjectCardRepository projectCardRepository;

    @Autowired
    private LanguageRepository languageRepository;

    public ProjectCardTranslation createProjectCardTranslation(ProjectCardTranslationDTO dto) {
        ProjectCardTranslation translation = new ProjectCardTranslation();

        // Set ProjectCard
        ProjectCard projectCard = projectCardRepository.findById(dto.getProjectCardId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid projectCardId"));
        translation.setProjectCard(projectCard);

        // Set Language
        Language language = languageRepository.findById(dto.getLanguageId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid languageId"));
        translation.setLanguage(language);

        // Set other fields
        translation.setSubject(dto.getSubject());
        translation.setData(dto.getData());
        translation.setDescription(dto.getDescription());

        return projectCardTranslationRepository.save(translation);
    }

    public ProjectCardTranslation save(ProjectCardTranslation translation) {
        return projectCardTranslationRepository.save(translation);
    }

    public List<ProjectCardTranslation> findAll() {
        return projectCardTranslationRepository.findAll();
    }

    public ProjectCardTranslation findById(Long id) {
        return projectCardTranslationRepository.findById(id).orElse(null);
    }

    public void deleteTranslation(Long id) {
        projectCardTranslationRepository.deleteById(id);
    }

}