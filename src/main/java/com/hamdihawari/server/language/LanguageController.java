package com.hamdihawari.server.language;

import com.hamdihawari.server.project.projectCard.ProjectCard;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @GetMapping
    public List<Language> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable Long id) {
        Language language = languageService.getLanguageById(id);
        return ResponseEntity.ok(language);
    }


    @PostMapping
    public ResponseEntity<Language> createLanguage(@Valid @RequestBody Language language) {
        Language createdLanguage = languageService.createLanguage(language);
        return new ResponseEntity<>(createdLanguage, HttpStatus.CREATED); // HttpStatus.CREATED for resource creation
    }

    @PutMapping("/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable Long id, @Valid @RequestBody Language language) {
        Language updatedLanguage = languageService.updateLanguage(id, language);
        return ResponseEntity.ok(updatedLanguage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Long id) {
        languageService.deleteLanguage(id);
        return ResponseEntity.noContent().build();
    }
}