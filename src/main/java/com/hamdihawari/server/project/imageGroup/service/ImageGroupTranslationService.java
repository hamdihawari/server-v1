package com.hamdihawari.server.project.imageGroup.service;

import com.hamdihawari.server.project.imageGroup.entity.ImageGroupTranslation;
import com.hamdihawari.server.project.imageGroup.repository.ImageGroupTranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageGroupTranslationService {

    @Autowired
    private ImageGroupTranslationRepository imageGroupTranslationRepository;

    public List<ImageGroupTranslation> getAllTranslations() {
        return imageGroupTranslationRepository.findAll();
    }

    // Find by ID
    public ImageGroupTranslation findById(Long id) {
        return imageGroupTranslationRepository.findById(id).orElse(null);
    }

    // Update translation
    public ImageGroupTranslation updateTranslation(ImageGroupTranslation translation) {
        return imageGroupTranslationRepository.save(translation); // Save the updated entity
    }

    public ImageGroupTranslation createTranslation(ImageGroupTranslation translation) {
        return imageGroupTranslationRepository.save(translation);
    }

    public List<ImageGroupTranslation> getAllImageGroupTranslations() {
        return imageGroupTranslationRepository.findAll();
    }

    public ImageGroupTranslation saveImageGroupTranslation(ImageGroupTranslation imageGroupTranslation) {
        return imageGroupTranslationRepository.save(imageGroupTranslation);
    }



}
