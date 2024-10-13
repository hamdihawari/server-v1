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

    // Get all translations
    @GetMapping
    public List<ImageTranslationDTO> getAllTranslations() {
        return imageTranslationService.getAllTranslations();
    }

    // Get translation by ID
    @GetMapping("/{id}")
    public ResponseEntity<ImageTranslationDTO> getTranslationById(@PathVariable Long id) {
        return imageTranslationService.getTranslationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get translations by language ID
    @GetMapping("/language_id/{languageId}")
    public ResponseEntity<List<ImageTranslationDTO>> getTranslationsByLanguageId(
            @PathVariable Long languageId) {
        List<ImageTranslationDTO> translations = imageTranslationService.getTranslationsByLanguageId(languageId);

        if (translations.isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404 if no translations found
        }

        return ResponseEntity.ok(translations); // Return 200 with the list of translations
    }

    // Create a new translation
    @PostMapping
    public ResponseEntity<ImageTranslationDTO> createTranslation(@RequestBody ImageTranslationDTO translationDTO) {
        ImageTranslationDTO createdTranslation = imageTranslationService.createTranslation(translationDTO);
        return ResponseEntity.status(201).body(createdTranslation);
    }

    // Update an existing translation
    @PutMapping("/{id}")
    public ResponseEntity<ImageTranslationDTO> updateTranslation(@PathVariable Long id, @RequestBody ImageTranslationDTO translationDTO) {
        return imageTranslationService.updateTranslation(id, translationDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a translation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable Long id) {
        if (imageTranslationService.deleteTranslation(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}


/*
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

    // Get all translations
    @GetMapping
    public List<ImageTranslationDTO> getAllTranslations() {
        return imageTranslationService.getAllTranslations();
    }

    // Get translation by ID
    @GetMapping("/{id}")
    public ResponseEntity<ImageTranslationDTO> getTranslationById(@PathVariable Long id) {
        return imageTranslationService.getTranslationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get translations by language code
    // Get translations by language ID
    @GetMapping("/language_id/{languageId}")
    public ResponseEntity<List<ImageTranslationDTO>> getTranslationsByLanguageId(
            @PathVariable Long languageId) {
        List<ImageTranslationDTO> translations = imageTranslationService.getTranslationsByLanguageId(languageId);

        if (translations.isEmpty()) {
            return ResponseEntity.notFound().build(); // Return 404 if no translations found
        }

        return ResponseEntity.ok(translations); // Return 200 with the list of translations
    }

    // Create a new translation
    @PostMapping
    public ResponseEntity<ImageTranslationDTO> createTranslation(@RequestBody ImageTranslationDTO translationDTO) {
        ImageTranslationDTO createdTranslation = imageTranslationService.createTranslation(translationDTO);
        return ResponseEntity.status(201).body(createdTranslation);
    }

    // Update an existing translation
    @PutMapping("/{id}")
    public ResponseEntity<ImageTranslationDTO> updateTranslation(@PathVariable Long id, @RequestBody ImageTranslationDTO translationDTO) {
        return imageTranslationService.updateTranslation(id, translationDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a translation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable Long id) {
        if (imageTranslationService.deleteTranslation(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
*/
