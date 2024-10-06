package com.hamdihawari.server.project.imageGroup.controller;

import com.hamdihawari.server.project.imageGroup.dto.ImageGroupTranslationDTO;
import com.hamdihawari.server.project.imageGroup.entity.ImageGroupTranslation;
import com.hamdihawari.server.project.imageGroup.service.ImageGroupTranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/image_group_translation")
public class ImageGroupTranslationController {

    @Autowired
    private ImageGroupTranslationService translationService;

    // Get all translations
    @GetMapping
    public List<ImageGroupTranslationDTO> getAllTranslations() {
        return translationService.getAllTranslations().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Create a new translation
    @PostMapping
    public ResponseEntity<ImageGroupTranslationDTO> createTranslation(@RequestBody ImageGroupTranslationDTO dto) {
        if (dto.getImageResource() == null) {
            return ResponseEntity.badRequest().body(null); // Return error response if imageResource is null
        }

        ImageGroupTranslation newTranslation = translationService.createTranslation(dto);
        return ResponseEntity.ok(mapToDTO(newTranslation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageGroupTranslationDTO> updateTranslation(@PathVariable Long id, @RequestBody ImageGroupTranslationDTO dto) {
        Optional<ImageGroupTranslation> updatedTranslation = translationService.updateTranslation(id, dto);
        return updatedTranslation.map(this::mapToDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Delete a translation by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable Long id) {
        if (translationService.deleteTranslation(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Helper method to map to DTO
    private ImageGroupTranslationDTO mapToDTO(ImageGroupTranslation translation) {
        return new ImageGroupTranslationDTO(
                translation.getId(),
                translation.getImageGroup() != null ? translation.getImageGroup().getId() : null, // No conversion, keep as Long
                translation.getLanguage(),
                translation.getData(),
                translation.getImageSubject(),
                translation.getImageDescription(),
                translation.getImageResource());
    }



}
