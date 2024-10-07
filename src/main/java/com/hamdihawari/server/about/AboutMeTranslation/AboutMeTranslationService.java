package com.hamdihawari.server.about.AboutMeTranslation;

import com.hamdihawari.server.about.AboutMe.AboutMe;
import com.hamdihawari.server.about.AboutMe.AboutMeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AboutMeTranslationService {

    @Autowired
    private AboutMeTranslationRepository aboutMeTranslationRepository;

    @Autowired
    private AboutMeRepository aboutMeRepository;

    // Get all translations
    public List<AboutMeTranslationDTO> getAllTranslations() {
        return aboutMeTranslationRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Helper method to convert entity to DTO
    private AboutMeTranslationDTO convertToDTO(AboutMeTranslation translation) {
        AboutMeTranslationDTO dto = new AboutMeTranslationDTO();
        dto.setId(translation.getId());
        dto.setAboutMeId(translation.getAboutMe().getId());
        dto.setTitle(translation.getTitle());
        dto.setDescription(translation.getDescription());
        dto.setSubject(translation.getSubject());
        dto.setLanguage(translation.getLanguage());
        return dto;
    }

    // Add translation to a specific AboutMe
    public AboutMeTranslationDTO addTranslation(Long aboutMeId, AboutMeTranslation translation) {
        AboutMe aboutMe = aboutMeRepository.findById(aboutMeId)
                .orElseThrow(() -> new RuntimeException("AboutMe not found"));
        translation.setAboutMe(aboutMe);
        AboutMeTranslation savedTranslation = aboutMeTranslationRepository.save(translation);
        return convertToDTO(savedTranslation);
    }

    // Get all translations for a specific AboutMe
    public List<AboutMeTranslationDTO> getTranslations(Long aboutMeId) {
        return aboutMeTranslationRepository.findByAboutMeId(aboutMeId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Update an existing translation
    public AboutMeTranslationDTO updateTranslation(Long translationId, AboutMeTranslation updatedTranslation) {
        AboutMeTranslation existingTranslation = aboutMeTranslationRepository.findById(translationId)
                .orElseThrow(() -> new RuntimeException("Translation not found"));

        existingTranslation.setTitle(updatedTranslation.getTitle());
        existingTranslation.setDescription(updatedTranslation.getDescription());
        existingTranslation.setSubject(updatedTranslation.getSubject());
        existingTranslation.setLanguage(updatedTranslation.getLanguage());

        AboutMeTranslation savedTranslation = aboutMeTranslationRepository.save(existingTranslation);
        return convertToDTO(savedTranslation);
    }

    // Delete a translation by its ID
    public void deleteTranslation(Long translationId) {
        AboutMeTranslation translation = aboutMeTranslationRepository.findById(translationId)
                .orElseThrow(() -> new RuntimeException("Translation not found"));
        aboutMeTranslationRepository.delete(translation);
    }
}
