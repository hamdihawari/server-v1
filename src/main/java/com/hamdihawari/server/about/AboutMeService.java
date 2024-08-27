package com.hamdihawari.server.about;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AboutMeService {

    private final AboutMeRepository aboutMeRepository;

    @Autowired
    public AboutMeService(AboutMeRepository aboutMeRepository) {
        this.aboutMeRepository = aboutMeRepository;
    }

    public List<AboutMe> getAllAboutMe() {
        return aboutMeRepository.findAll();
    }

    public Optional<AboutMe> getAboutMeById(Long id) {
        return aboutMeRepository.findById(id);
    }

    public AboutMe createOrUpdateAboutMe(AboutMe aboutMe) {
        return aboutMeRepository.save(aboutMe);
    }

    public void deleteAboutMe(Long id) {
        aboutMeRepository.deleteById(id);
    }

    public List<AboutMe> getAboutMeByLanguage(String language) {
        return aboutMeRepository.findByLanguage(language);
    }
}
