package com.hamdihawari.server.about.AboutMeTranslation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/about_me_translation")
public class AboutMeTranslationController {

    @Autowired
    private AboutMeTranslationService aboutMeTranslationService;

    // Add a new translation
    @PostMapping("/add")
    public ResponseEntity<AboutMeTranslationDTO> addTranslation(@RequestParam Long aboutMeId, @RequestBody AboutMeTranslation translation) {
        AboutMeTranslationDTO savedTranslation = aboutMeTranslationService.addTranslation(aboutMeId, translation);
        return new ResponseEntity<>(savedTranslation, HttpStatus.CREATED);
    }

    // Get all translations
    @GetMapping
    public ResponseEntity<List<AboutMeTranslationDTO>> getAllTranslations() {
        List<AboutMeTranslationDTO> translations = aboutMeTranslationService.getAllTranslations();
        return new ResponseEntity<>(translations, HttpStatus.OK);
    }

    // Get translations by AboutMe ID
    @GetMapping("/by-about/{aboutMeId}")
    public ResponseEntity<List<AboutMeTranslationDTO>> getTranslationsByAboutMe(@PathVariable Long aboutMeId) {
        List<AboutMeTranslationDTO> translations = aboutMeTranslationService.getTranslations(aboutMeId);
        return new ResponseEntity<>(translations, HttpStatus.OK);
    }

    // Update an existing translation
    @PutMapping("/{translationId}")
    public ResponseEntity<AboutMeTranslationDTO> updateTranslation(@PathVariable Long translationId, @RequestBody AboutMeTranslation translation) {
        AboutMeTranslationDTO updatedTranslation = aboutMeTranslationService.updateTranslation(translationId, translation);
        return new ResponseEntity<>(updatedTranslation, HttpStatus.OK);
    }

    // Delete a translation by ID
    @DeleteMapping("/{translationId}")
    public ResponseEntity<Void> deleteTranslation(@PathVariable Long translationId) {
        aboutMeTranslationService.deleteTranslation(translationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
