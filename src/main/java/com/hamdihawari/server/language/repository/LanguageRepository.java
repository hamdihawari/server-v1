package com.hamdihawari.server.language.repository;

import com.hamdihawari.server.language.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
}