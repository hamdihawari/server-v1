package com.hamdihawari.server.gallery.ImageGallery.service;

import com.hamdihawari.server.gallery.ImageGallery.dto.ImageGalleryTranslationDTO;
import com.hamdihawari.server.gallery.ImageGallery.entity.ImageGalleryTranslation;
import com.hamdihawari.server.gallery.ImageGallery.mapper.ImageGalleryTranslationMapper;
import com.hamdihawari.server.gallery.ImageGallery.repository.ImageGalleryTranslationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageGalleryTranslationService {

    private final ImageGalleryTranslationRepository imageGalleryTranslationRepository;
    private final ImageGalleryTranslationMapper imageGalleryTranslationMapper;

    public ImageGalleryTranslationService(ImageGalleryTranslationRepository imageGalleryTranslationRepository,
                                          ImageGalleryTranslationMapper imageGalleryTranslationMapper) {
        this.imageGalleryTranslationRepository = imageGalleryTranslationRepository;
        this.imageGalleryTranslationMapper = imageGalleryTranslationMapper;
    }

    // Fetch translations by both imageGalleryId and languageId
    public ImageGalleryTranslationDTO getTranslationByImageGalleryAndLanguage(Long imageGalleryId, Long languageId) {
        return imageGalleryTranslationRepository.findByImageGalleryIdAndLanguageId(imageGalleryId, languageId)
                .map(imageGalleryTranslationMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Translation not found for imageGalleryId: " + imageGalleryId + " and languageId: " + languageId));
    }

    public List<ImageGalleryTranslationDTO> getTranslationsByLanguageId(Long languageId) {
        return imageGalleryTranslationRepository.findByLanguageId(languageId).stream()
                .map(imageGalleryTranslationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<ImageGalleryTranslationDTO> getAllTranslations() {
        return imageGalleryTranslationRepository.findAll().stream()
                .map(imageGalleryTranslationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ImageGalleryTranslationDTO getTranslationById(Long id) {
        ImageGalleryTranslation translation = imageGalleryTranslationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Translation not found"));
        return imageGalleryTranslationMapper.toDTO(translation);
    }

    public ImageGalleryTranslationDTO createTranslation(ImageGalleryTranslationDTO translationDTO) {
        ImageGalleryTranslation translation = imageGalleryTranslationMapper.toEntity(translationDTO);
        ImageGalleryTranslation savedTranslation = imageGalleryTranslationRepository.save(translation);
        return imageGalleryTranslationMapper.toDTO(savedTranslation);
    }

    public ImageGalleryTranslationDTO updateTranslation(Long id, ImageGalleryTranslationDTO translationDTO) {
        ImageGalleryTranslation translation = imageGalleryTranslationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Translation not found"));

        // Update fields related to translations
        translation.setTitle(translationDTO.getTitle());
        translation.setLocation(translationDTO.getLocation());
        translation.setOriginalAlt(translationDTO.getOriginalAlt());
        translation.setThumbnailAlt(translationDTO.getThumbnailAlt());

        ImageGalleryTranslation updatedTranslation = imageGalleryTranslationRepository.save(translation);
        return imageGalleryTranslationMapper.toDTO(updatedTranslation);
    }

    public void deleteTranslation(Long id) {
        if (!imageGalleryTranslationRepository.existsById(id)) {
            throw new RuntimeException("Translation not found");
        }
        imageGalleryTranslationRepository.deleteById(id);
    }

}
