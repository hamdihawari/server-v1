package com.hamdihawari.server.language;

import com.hamdihawari.server.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    public Language getLanguageById(Long id) {
        return languageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id " + id));
    }

    public Language createLanguage(Language language) {
        return languageRepository.save(language);
    }

    public Language updateLanguage(Long id, Language language) {
        Language existingLanguage = getLanguageById(id);
        existingLanguage.setCode(language.getCode());
        existingLanguage.setName(language.getName());
        return languageRepository.save(existingLanguage);
    }

    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }
}
