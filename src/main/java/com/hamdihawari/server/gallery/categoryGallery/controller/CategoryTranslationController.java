package com.hamdihawari.server.gallery.categoryGallery.controller;

import com.hamdihawari.server.gallery.categoryGallery.dto.CategoryTranslationDTO;
import com.hamdihawari.server.gallery.categoryGallery.service.CategoryTranslationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category-translations")
public class CategoryTranslationController {

    private final CategoryTranslationService categoryTranslationService;

    public CategoryTranslationController(CategoryTranslationService categoryTranslationService) {
        this.categoryTranslationService = categoryTranslationService;
    }

    // Get all translations for a specific language
    @GetMapping("/language/{languageId}")
    public ResponseEntity<List<CategoryTranslationDTO>> getTranslationsByLanguageId(@PathVariable Long languageId) {
        List<CategoryTranslationDTO> translations = categoryTranslationService.getTranslationsByLanguageId(languageId);
        return ResponseEntity.ok(translations);
    }

    // Get a specific category translation by categoryId and languageId
    @GetMapping("/category/{categoryId}/language/{languageId}")
    public ResponseEntity<CategoryTranslationDTO> getTranslationByCategoryIdAndLanguageId(
            @PathVariable Long categoryId,
            @PathVariable Long languageId) {
        CategoryTranslationDTO translation = categoryTranslationService.getTranslationByCategoryIdAndLanguageId(categoryId, languageId);
        return ResponseEntity.ok(translation);
    }

    @GetMapping
    public ResponseEntity<List<CategoryTranslationDTO>> getAllTranslations() {
        List<CategoryTranslationDTO> translations = categoryTranslationService.getAllTranslations();
        return new ResponseEntity<>(translations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryTranslationDTO> getTranslationById(@PathVariable Long id) {
        CategoryTranslationDTO translation = categoryTranslationService.getTranslationById(id);
        return new ResponseEntity<>(translation, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryTranslationDTO> createTranslation(@RequestBody CategoryTranslationDTO translationDTO) {
        CategoryTranslationDTO createdTranslation = categoryTranslationService.createTranslation(translationDTO);
        return new ResponseEntity<>(createdTranslation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryTranslationDTO> updateTranslation(@PathVariable Long id, @RequestBody CategoryTranslationDTO translationDTO) {
        CategoryTranslationDTO updatedTranslation = categoryTranslationService.updateTranslation(id, translationDTO);
        return new ResponseEntity<>(updatedTranslation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable Long id) {
        categoryTranslationService.deleteTranslation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
