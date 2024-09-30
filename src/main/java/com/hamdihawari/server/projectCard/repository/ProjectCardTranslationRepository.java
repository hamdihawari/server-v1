package com.hamdihawari.server.projectCard.repository;

import com.hamdihawari.server.projectCard.entity.ProjectCardTranslation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ProjectCardTranslationService {
    ProjectCardTranslation createProjectCardTranslation(ProjectCardTranslation projectCardTranslation);
}