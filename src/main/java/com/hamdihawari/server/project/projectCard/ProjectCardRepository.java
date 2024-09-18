package com.hamdihawari.server.project.projectCard;

import com.hamdihawari.server.language.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectCardRepository extends JpaRepository<ProjectCard, Long> {
    List<ProjectCard> findByLanguage(Language language);
}

