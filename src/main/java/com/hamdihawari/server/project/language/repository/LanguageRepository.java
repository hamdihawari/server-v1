package com.hamdihawari.server.project.language.repository;

import com.hamdihawari.server.project.language.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    Language findByCode(String code);
}
