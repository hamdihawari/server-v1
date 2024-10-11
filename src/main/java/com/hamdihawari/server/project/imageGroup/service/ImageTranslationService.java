package com.hamdihawari.server.project.imageGroup.service;

import com.hamdihawari.server.project.imageGroup.dto.ImageTranslationDTO;
import com.hamdihawari.server.project.imageGroup.entity.ImageTranslation;
import com.hamdihawari.server.project.imageGroup.repository.ImageTranslationRepository;
import com.hamdihawari.server.project.language.entity.Language;
import com.hamdihawari.server.project.language.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageTranslationService {
    private final ImageTranslationRepository imageTranslationRepository;
    private final LanguageRepository languageRepository;

    @Autowired
    public ImageTranslationService(ImageTranslationRepository imageTranslationRepository,
                                   LanguageRepository languageRepository) {
        this.imageTranslationRepository = imageTranslationRepository;
        this.languageRepository = languageRepository;
    }

    // Get a translation by image ID and language code
    public Optional<ImageTranslationDTO> getTranslationByImageAndLanguageCode(Long imageId, String languageCode) {
        // Use the repository method to find the translation
        ImageTranslation imageTranslation = imageTranslationRepository.findByImageIdAndLanguageCode(imageId, languageCode);
        return Optional.ofNullable(convertToDTO(imageTranslation));
    }

    // Get all translations
    public List<ImageTranslationDTO> getAllTranslations() {
        return imageTranslationRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get translations by imageId and languageCode
    public List<ImageTranslationDTO> getTranslationsByImageAndLanguageCode(Long imageId, String languageCode) {
        List<ImageTranslation> translations = imageTranslationRepository.findByImageId(imageId);
        System.out.println("Translations: " + translations); // Debug output

        return translations.stream()
                .filter(translation -> translation.getLanguage().getCode().equals(languageCode)) // Update to correctly compare language code
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get translation by ID
    public Optional<ImageTranslationDTO> getTranslationById(Long id) {
        return imageTranslationRepository.findById(id).map(this::convertToDTO);
    }

    // Create a new translation
    public ImageTranslationDTO createTranslation(ImageTranslationDTO translationDTO) {
        ImageTranslation translation = new ImageTranslation();

        // Find the Language entity by code
        Language language = findLanguageByCode(translationDTO.getLanguageCode());
        if (language != null) {
            translation.setLanguage(language);
        } else {
            throw new IllegalArgumentException("Invalid language code: " + translationDTO.getLanguageCode());
        }

        translation.setData(translationDTO.getData());
        translation.setImageSubject(translationDTO.getImageSubject());
        translation.setImageDescription(translationDTO.getImageDescription());

        return convertToDTO(imageTranslationRepository.save(translation));
    }

    // Update an existing translation
    public Optional<ImageTranslationDTO> updateTranslation(Long id, ImageTranslationDTO translationDTO) {
        return imageTranslationRepository.findById(id).map(existingTranslation -> {
            Language language = findLanguageByCode(translationDTO.getLanguageCode());
            if (language != null) {
                existingTranslation.setLanguage(language);
            } else {
                throw new IllegalArgumentException("Invalid language code: " + translationDTO.getLanguageCode());
            }

            existingTranslation.setData(translationDTO.getData());
            existingTranslation.setImageSubject(translationDTO.getImageSubject());
            existingTranslation.setImageDescription(translationDTO.getImageDescription());

            return convertToDTO(imageTranslationRepository.save(existingTranslation));
        });
    }

    // Delete a translation
    public boolean deleteTranslation(Long id) {
        if (imageTranslationRepository.existsById(id)) {
            imageTranslationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Convert ImageTranslation to ImageTranslationDTO
    private ImageTranslationDTO convertToDTO(ImageTranslation translation) {
        if (translation == null) {
            return null; // Return null if translation is null
        }

        ImageTranslationDTO dto = new ImageTranslationDTO();
        dto.setId(translation.getId());

        if (translation.getLanguage() != null) {
            dto.setLanguageCode(translation.getLanguage().getCode());
        }

        dto.setData(translation.getData());
        dto.setImageSubject(translation.getImageSubject());
        dto.setImageDescription(translation.getImageDescription());
        return dto;
    }

    // Method to find Language by code
    private Language findLanguageByCode(String code) {
        return languageRepository.findByCode(code);
    }
}
