package com.hamdihawari.server.project.imageGroup.service;

import com.hamdihawari.server.project.imageGroup.dto.ImageTranslationDTO;
import com.hamdihawari.server.project.imageGroup.entity.ImageTranslation;

import com.hamdihawari.server.project.imageGroup.repository.ImageTranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class ImageTranslationService {

    @Autowired
    private ImageTranslationRepository imageTranslationRepository;

    public List<ImageTranslationDTO> getAllTranslations() {
        return imageTranslationRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ImageTranslationDTO getTranslationById(Long id) {
        return imageTranslationRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public ImageTranslationDTO createTranslation(ImageTranslationDTO translationDTO) {
        ImageTranslation translation = new ImageTranslation();
        translation.setLanguage(translationDTO.getLanguage());
        translation.setData(translationDTO.getData());
        translation.setImageSubject(translationDTO.getImageSubject());
        translation.setImageDescription(translationDTO.getImageDescription());
        translation.setImageResource(translationDTO.getImageResource());
        return convertToDTO(imageTranslationRepository.save(translation));
    }

    public ImageTranslationDTO updateTranslation(Long id, ImageTranslationDTO translationDTO) {
        return imageTranslationRepository.findById(id).map(existingTranslation -> {
            existingTranslation.setLanguage(translationDTO.getLanguage());
            existingTranslation.setData(translationDTO.getData());
            existingTranslation.setImageSubject(translationDTO.getImageSubject());
            existingTranslation.setImageDescription(translationDTO.getImageDescription());
            existingTranslation.setImageResource(translationDTO.getImageResource());
            return convertToDTO(imageTranslationRepository.save(existingTranslation));
        }).orElse(null);
    }

    public void deleteTranslation(Long id) {
        imageTranslationRepository.deleteById(id);
    }

    private ImageTranslationDTO convertToDTO(ImageTranslation translation) {
        ImageTranslationDTO dto = new ImageTranslationDTO();
        dto.setId(translation.getId());
        dto.setLanguage(translation.getLanguage());
        dto.setData(translation.getData());
        dto.setImageSubject(translation.getImageSubject());
        dto.setImageDescription(translation.getImageDescription());
        dto.setImageResource(translation.getImageResource());
        return dto;
    }
}
