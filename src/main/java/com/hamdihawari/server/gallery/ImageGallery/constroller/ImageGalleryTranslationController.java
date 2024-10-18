package com.hamdihawari.server.gallery.ImageGallery.constroller;

import com.hamdihawari.server.gallery.ImageGallery.dto.ImageGalleryTranslationDTO;
import com.hamdihawari.server.gallery.ImageGallery.service.ImageGalleryTranslationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image-gallery-translations")
public class ImageGalleryTranslationController {

    private final ImageGalleryTranslationService translationService;

    // Only one constructor to inject the service
    public ImageGalleryTranslationController(ImageGalleryTranslationService translationService) {
        this.translationService = translationService;
    }

    @GetMapping("/language/{languageId}")
    public ResponseEntity<List<ImageGalleryTranslationDTO>> getTranslationsByLanguageId(@PathVariable Long languageId) {
        List<ImageGalleryTranslationDTO> translations = translationService.getTranslationsByLanguageId(languageId);
        return ResponseEntity.ok(translations);
    }

    @GetMapping
    public ResponseEntity<List<ImageGalleryTranslationDTO>> getAllTranslations() {
        List<ImageGalleryTranslationDTO> translations = translationService.getAllTranslations();
        return new ResponseEntity<>(translations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageGalleryTranslationDTO> getTranslationById(@PathVariable Long id) {
        ImageGalleryTranslationDTO translation = translationService.getTranslationById(id);
        return new ResponseEntity<>(translation, HttpStatus.OK);
    }

    // Endpoint to get translation by both imageGalleryId and languageId
    @GetMapping("/image-gallery/{imageGalleryId}/language/{languageId}")
    public ResponseEntity<ImageGalleryTranslationDTO> getTranslationByImageGalleryAndLanguage(
            @PathVariable Long imageGalleryId,
            @PathVariable Long languageId) {
        ImageGalleryTranslationDTO translation = translationService.getTranslationByImageGalleryAndLanguage(imageGalleryId, languageId);
        return new ResponseEntity<>(translation, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ImageGalleryTranslationDTO> createTranslation(@RequestBody ImageGalleryTranslationDTO translationDTO) {
        ImageGalleryTranslationDTO createdTranslation = translationService.createTranslation(translationDTO);
        return new ResponseEntity<>(createdTranslation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageGalleryTranslationDTO> updateTranslation(@PathVariable Long id, @RequestBody ImageGalleryTranslationDTO translationDTO) {
        ImageGalleryTranslationDTO updatedTranslation = translationService.updateTranslation(id, translationDTO);
        return new ResponseEntity<>(updatedTranslation, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable Long id) {
        translationService.deleteTranslation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
