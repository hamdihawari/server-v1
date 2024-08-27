package com.hamdihawari.server.about;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AboutMeRepository extends JpaRepository<AboutMe, Long> {
    List<AboutMe> findByLanguage(String language);
}
