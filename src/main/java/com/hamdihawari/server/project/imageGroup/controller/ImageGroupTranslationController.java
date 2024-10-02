package com.hamdihawari.server.project.imageGroup.controller;

import com.hamdihawari.server.project.imageGroup.dto.ImageGroupTranslationDTO;
import com.hamdihawari.server.project.imageGroup.entity.ImageGroupTranslation;
import com.hamdihawari.server.project.imageGroup.service.ImageGroupTranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/image_group_translation")
public class ImageGroupTranslationController {

    @Autowired
    private ImageGroupTranslationService imageGroupTranslationService;

    // Get all translations
    @GetMapping
    public List<ImageGroupTranslationDTO> getAllTranslations() {
        return imageGroupTranslationService.getAllTranslations().stream()
                .map(translation -> new ImageGroupTranslationDTO(
                        translation.getId(),
                        translation.getImageGroupId(),
                        translation.getLanguage(),
                        translation.getData(),
                        translation.getImageSubject(),
                        translation.getImageDescription(),
                        translation.getImageResource()))
                .collect(Collectors.toList());
    }


    // Create a new translation
    @PostMapping
    public ResponseEntity<ImageGroupTranslationDTO> createTranslation(@RequestBody ImageGroupTranslationDTO translationDTO) {
        System.out.println("Received translation DTO: " + translationDTO); // Log the DTO

        if (translationDTO.getImageResource() == null) {
            return ResponseEntity.badRequest().body(null); // Return error response if imageResource is null
        }

        ImageGroupTranslation translation = new ImageGroupTranslation(
                translationDTO.getImageGroupId(),
                translationDTO.getLanguage(),
                translationDTO.getData(),
                translationDTO.getImageSubject(),
                translationDTO.getImageDescription(),
                translationDTO.getImageResource());

        ImageGroupTranslation createdTranslation = imageGroupTranslationService.createTranslation(translation);
        return ResponseEntity.ok(new ImageGroupTranslationDTO(
                createdTranslation.getId(),
                createdTranslation.getImageGroupId(),
                createdTranslation.getLanguage(),
                createdTranslation.getData(),
                createdTranslation.getImageSubject(),
                createdTranslation.getImageDescription(),
                createdTranslation.getImageResource()));
    }

    //
    // Update an existing translation
    @PutMapping("/{id}")
    public ResponseEntity<ImageGroupTranslationDTO> updateTranslation(
            @PathVariable Long id,
            @RequestBody ImageGroupTranslationDTO translationDTO) {

        // Log the incoming DTO for debugging purposes
        System.out.println("Received translation DTO for update: " + translationDTO);

        // Check if the translation exists before updating
        ImageGroupTranslation existingTranslation = imageGroupTranslationService.findById(id);
        if (existingTranslation == null) {
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }

        // Update the existing translation's fields
        existingTranslation.setImageGroupId(translationDTO.getImageGroupId());
        existingTranslation.setLanguage(translationDTO.getLanguage());
        existingTranslation.setData(translationDTO.getData());
        existingTranslation.setImageSubject(translationDTO.getImageSubject());
        existingTranslation.setImageDescription(translationDTO.getImageDescription());
        existingTranslation.setImageResource(translationDTO.getImageResource());

        // Save the updated translation
        ImageGroupTranslation updatedTranslation = imageGroupTranslationService.updateTranslation(existingTranslation);

        return ResponseEntity.ok(new ImageGroupTranslationDTO(
                updatedTranslation.getId(),
                updatedTranslation.getImageGroupId(),
                updatedTranslation.getLanguage(),
                updatedTranslation.getData(),
                updatedTranslation.getImageSubject(),
                updatedTranslation.getImageDescription(),
                updatedTranslation.getImageResource()));
    }

}
