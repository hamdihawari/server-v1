package com.hamdihawari.server.project.imageGroup.controller;

import com.hamdihawari.server.project.imageGroup.dto.ImageTranslationDTO;
import com.hamdihawari.server.project.imageGroup.service.ImageTranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/image_translation")
public class ImageTranslationController {

    @Autowired
    private ImageTranslationService imageTranslationService;

    @GetMapping
    public List<ImageTranslationDTO> getAllTranslations() {
        return imageTranslationService.getAllTranslations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageTranslationDTO> getTranslationById(@PathVariable Long id) {
        ImageTranslationDTO translationDTO = imageTranslationService.getTranslationById(id);
        return translationDTO != null ? ResponseEntity.ok(translationDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ImageTranslationDTO> createTranslation(@RequestBody ImageTranslationDTO translationDTO) {
        return new ResponseEntity<>(imageTranslationService.createTranslation(translationDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageTranslationDTO> updateTranslation(@PathVariable Long id, @RequestBody ImageTranslationDTO translationDTO) {
        ImageTranslationDTO updatedTranslation = imageTranslationService.updateTranslation(id, translationDTO);
        return updatedTranslation != null ? ResponseEntity.ok(updatedTranslation) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable Long id) {
        imageTranslationService.deleteTranslation(id);
        return ResponseEntity.noContent().build();
    }
}
