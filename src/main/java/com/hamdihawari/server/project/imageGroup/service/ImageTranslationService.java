
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

    // Get translations by language code
    public List<ImageTranslationDTO> getTranslationsByLanguageCode(String languageCode) {
        return imageTranslationRepository.findByLanguageCode(languageCode).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get all translations
    public List<ImageTranslationDTO> getAllTranslations() {
        return imageTranslationRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get translation by ID
    public Optional<ImageTranslationDTO> getTranslationById(Long id) {
        return imageTranslationRepository.findById(id)
                .map(this::convertToDTO);
    }

    // Get translations by language ID
    public List<ImageTranslationDTO> getTranslationsByLanguageId(Long languageId) {
        return imageTranslationRepository.findByLanguageId(languageId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Create a new translation
    public ImageTranslationDTO createTranslation(ImageTranslationDTO translationDTO) {
        Language language = languageRepository.findByCode(translationDTO.getLanguageCode());
        if (language == null) {
            throw new IllegalArgumentException("Invalid language code: " + translationDTO.getLanguageCode());
        }

        ImageTranslation translation = new ImageTranslation();
        translation.setLanguage(language);
        translation.setData(translationDTO.getData());
        translation.setImageSubject(translationDTO.getImageSubject());
        translation.setImageDescription(translationDTO.getImageDescription());

        return convertToDTO(imageTranslationRepository.save(translation));
    }

    // Update an existing translation
    public Optional<ImageTranslationDTO> updateTranslation(Long id, ImageTranslationDTO translationDTO) {
        return imageTranslationRepository.findById(id).map(existingTranslation -> {
            Language language = languageRepository.findByCode(translationDTO.getLanguageCode());
            if (language == null) {
                throw new IllegalArgumentException("Invalid language code: " + translationDTO.getLanguageCode());
            }
            existingTranslation.setLanguage(language);
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

    // Convert Entity to DTO
    private ImageTranslationDTO convertToDTO(ImageTranslation translation) {
        ImageTranslationDTO dto = new ImageTranslationDTO();
        dto.setId(translation.getId());
        dto.setLanguageCode(translation.getLanguage().getCode());
        dto.setData(translation.getData());
        dto.setImageSubject(translation.getImageSubject());
        dto.setImageDescription(translation.getImageDescription());
        return dto;
    }
}

/*
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

    // Get translations by language code
    public List<ImageTranslationDTO> getTranslationsByLanguageCode(String languageCode) {
        return imageTranslationRepository.findByLanguageCode(languageCode).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList()); // Convert to DTOs and return
    }

    // Get all translations
    public List<ImageTranslationDTO> getAllTranslations() {
        return imageTranslationRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get translation by ID
    public Optional<ImageTranslationDTO> getTranslationById(Long id) {
        return imageTranslationRepository.findById(id)
                .map(this::convertToDTO);
    }

    // Get translations by language ID
    public List<ImageTranslationDTO> getTranslationsByLanguageId(Long languageId) {
        return imageTranslationRepository.findByLanguageId(languageId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Create a new translation
    public ImageTranslationDTO createTranslation(ImageTranslationDTO translationDTO) {
        ImageTranslation translation = new ImageTranslation();
        Language language = languageRepository.findByCode(translationDTO.getLanguageCode());

        if (language != null) {
            translation.setLanguage(language);
            translation.setData(translationDTO.getData());
            translation.setImageSubject(translationDTO.getImageSubject());
            translation.setImageDescription(translationDTO.getImageDescription());
            return convertToDTO(imageTranslationRepository.save(translation));
        } else {
            throw new IllegalArgumentException("Invalid language code: " + translationDTO.getLanguageCode());
        }
    }

    // Update an existing translation
    public Optional<ImageTranslationDTO> updateTranslation(Long id, ImageTranslationDTO translationDTO) {
        return imageTranslationRepository.findById(id).map(existingTranslation -> {
            Language language = languageRepository.findByCode(translationDTO.getLanguageCode());
            if (language != null) {
                existingTranslation.setLanguage(language);
                existingTranslation.setData(translationDTO.getData());
                existingTranslation.setImageSubject(translationDTO.getImageSubject());
                existingTranslation.setImageDescription(translationDTO.getImageDescription());
                return convertToDTO(imageTranslationRepository.save(existingTranslation));
            } else {
                throw new IllegalArgumentException("Invalid language code: " + translationDTO.getLanguageCode());
            }
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

    // Convert Entity to DTO
    private ImageTranslationDTO convertToDTO(ImageTranslation translation) {
        ImageTranslationDTO dto = new ImageTranslationDTO();
        dto.setId(translation.getId());
        dto.setLanguageCode(translation.getLanguage().getCode());
        dto.setData(translation.getData());
        dto.setImageSubject(translation.getImageSubject());
        dto.setImageDescription(translation.getImageDescription());
        return dto;
    }
}
*/
