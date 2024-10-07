package com.hamdihawari.server.project.imageGroup.controller;

import com.hamdihawari.server.project.imageGroup.dto.ImageTranslationDTO;
import com.hamdihawari.server.project.imageGroup.service.ImageTranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image_translation")
public class ImageTranslationController {

    private final ImageTranslationService imageTranslationService;

    @Autowired
    public ImageTranslationController(ImageTranslationService imageTranslationService) {
        this.imageTranslationService = imageTranslationService;
    }

    @GetMapping
    public List<ImageTranslationDTO> getAllTranslations() {
        return imageTranslationService.getAllTranslations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageTranslationDTO> getTranslationById(@PathVariable Long id) {
        return imageTranslationService.getTranslationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ImageTranslationDTO> createTranslation(@RequestBody ImageTranslationDTO translationDTO) {
        return ResponseEntity.status(201).body(imageTranslationService.createTranslation(translationDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageTranslationDTO> updateTranslation(@PathVariable Long id, @RequestBody ImageTranslationDTO translationDTO) {
        return imageTranslationService.updateTranslation(id, translationDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable Long id) {
        if (imageTranslationService.deleteTranslation(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
