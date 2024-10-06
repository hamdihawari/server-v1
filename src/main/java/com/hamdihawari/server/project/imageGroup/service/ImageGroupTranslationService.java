package com.hamdihawari.server.project.imageGroup.service;

import com.hamdihawari.server.project.imageGroup.repository.ImageGroupRepository;
import com.hamdihawari.server.project.imageGroup.dto.ImageGroupTranslationDTO;
import com.hamdihawari.server.project.imageGroup.entity.ImageGroup;
import com.hamdihawari.server.project.imageGroup.entity.ImageGroupTranslation;
import com.hamdihawari.server.project.imageGroup.repository.ImageGroupTranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageGroupTranslationService {

    @Autowired
    private ImageGroupTranslationRepository translationRepository;

    @Autowired
    private ImageGroupRepository imageGroupRepository;

    // Get all translations
    public List<ImageGroupTranslation> getAllTranslations() {
        return translationRepository.findAll();
    }

    // Create a new translation
    public ImageGroupTranslation createTranslation(ImageGroupTranslationDTO dto) {
        ImageGroupTranslation translation = new ImageGroupTranslation();
        setTranslationFields(translation, dto);

        // No need for conversion since imageGroupId is now Long
        ImageGroup imageGroup = imageGroupRepository.findById(dto.getImageGroupId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid image group ID"));
        translation.setImageGroup(imageGroup);

        return translationRepository.save(translation);
    }

    public Optional<ImageGroupTranslation> updateTranslation(Long id, ImageGroupTranslationDTO dto) {
        return translationRepository.findById(id).map(existingTranslation -> {
            setTranslationFields(existingTranslation, dto);

            // No need for conversion since imageGroupId is now Long
            ImageGroup imageGroup = imageGroupRepository.findById(dto.getImageGroupId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid image group ID"));
            existingTranslation.setImageGroup(imageGroup);

            return translationRepository.save(existingTranslation);
        });
    }


    // Delete a translation by ID
    public boolean deleteTranslation(Long id) {
        if (translationRepository.existsById(id)) {
            translationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Helper method to set fields in ImageGroupTranslation
    private void setTranslationFields(ImageGroupTranslation translation, ImageGroupTranslationDTO dto) {
        translation.setLanguage(dto.getLanguage());
        translation.setData(dto.getData());
        translation.setImageSubject(dto.getImageSubject());
        translation.setImageDescription(dto.getImageDescription());
        translation.setImageResource(dto.getImageResource());
    }
}
