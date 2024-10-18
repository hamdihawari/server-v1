package com.hamdihawari.server.gallery.categoryGallery.service;

import com.hamdihawari.server.gallery.categoryGallery.dto.CategoryTranslationDTO;
import com.hamdihawari.server.gallery.categoryGallery.entiry.CategoryTranslation;
import com.hamdihawari.server.gallery.categoryGallery.mapper.CategoryTranslationMapper;
import com.hamdihawari.server.gallery.categoryGallery.repository.CategoryTranslationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryTranslationService {

    private final CategoryTranslationRepository categoryTranslationRepository;
    private final CategoryTranslationMapper categoryTranslationMapper;

    public CategoryTranslationService(CategoryTranslationRepository categoryTranslationRepository,
                                      CategoryTranslationMapper categoryTranslationMapper) {
        this.categoryTranslationRepository = categoryTranslationRepository;
        this.categoryTranslationMapper = categoryTranslationMapper;
    }

    public List<CategoryTranslationDTO> getAllTranslations() {
        return categoryTranslationRepository.findAll().stream()
                .map(categoryTranslationMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Fetch by categoryId and languageId
    public CategoryTranslationDTO getTranslationByCategoryIdAndLanguageId(Long categoryId, Long languageId) {
        CategoryTranslation translation = categoryTranslationRepository.findByCategoryIdAndLanguageId(categoryId, languageId)
                .orElseThrow(() -> new RuntimeException("Category translation not found"));
        return categoryTranslationMapper.toDTO(translation);
    }

    // Fetch all translations by languageId
    public List<CategoryTranslationDTO> getTranslationsByLanguageId(Long languageId) {
        return categoryTranslationRepository.findByLanguageId(languageId).stream()
                .map(categoryTranslationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CategoryTranslationDTO getTranslationById(Long id) {
        CategoryTranslation translation = categoryTranslationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Translation not found"));
        return categoryTranslationMapper.toDTO(translation);
    }

    public CategoryTranslationDTO createTranslation(CategoryTranslationDTO translationDTO) {
        CategoryTranslation translation = categoryTranslationMapper.toEntity(translationDTO);
        CategoryTranslation savedTranslation = categoryTranslationRepository.save(translation);
        return categoryTranslationMapper.toDTO(savedTranslation);
    }

    public CategoryTranslationDTO updateTranslation(Long id, CategoryTranslationDTO translationDTO) {
        CategoryTranslation translation = categoryTranslationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Translation not found"));
        translation.setName(translationDTO.getName());
        translation.setHeaderText(translationDTO.getHeaderText());

        CategoryTranslation updatedTranslation = categoryTranslationRepository.save(translation);
        return categoryTranslationMapper.toDTO(updatedTranslation);
    }

    public void deleteTranslation(Long id) {
        categoryTranslationRepository.deleteById(id);
    }
}
