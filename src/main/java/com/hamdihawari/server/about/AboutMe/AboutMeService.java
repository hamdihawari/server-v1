package com.hamdihawari.server.about.AboutMe;

import com.hamdihawari.server.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AboutMeService {

    @Autowired
    private AboutMeRepository aboutMeRepository;

    public AboutMeDTO getFirstAboutMe() {
        // Fetch the first entry in the AboutMe table (or throw an exception if none exist)
        AboutMe aboutMe = aboutMeRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("No AboutMe record found"));

        return mapToDTO(aboutMe);
    }

    public AboutMeDTO updateAboutMe(Long id, AboutMeDTO aboutMeDTO) {
        AboutMe aboutMe = aboutMeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AboutMe not found"));

        aboutMe.setCreatedAt(aboutMeDTO.getCreatedAt());
        aboutMe.setUpdatedAt(aboutMeDTO.getUpdatedAt());
        aboutMe.setPhoto(aboutMeDTO.getPhoto());  // Handle photo field

        AboutMe updatedAboutMe = aboutMeRepository.save(aboutMe);
        return mapToDTO(updatedAboutMe);
    }

    public AboutMeDTO getAboutMe(Long id) {
        AboutMe aboutMe = aboutMeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AboutMe not found"));
        return mapToDTO(aboutMe);
    }

    private AboutMeDTO mapToDTO(AboutMe aboutMe) {
        AboutMeDTO aboutMeDTO = new AboutMeDTO();
        aboutMeDTO.setId(aboutMe.getId());
        aboutMeDTO.setCreatedAt(aboutMe.getCreatedAt());
        aboutMeDTO.setUpdatedAt(aboutMe.getUpdatedAt());
        aboutMeDTO.setPhoto(aboutMe.getPhoto());  // Map the photo field
        return aboutMeDTO;
    }
}

/* package com.hamdihawari.server.about;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AboutMeService {

    private final AboutMeRepository aboutMeRepository;

    @Autowired
    public AboutMeService(AboutMeRepository aboutMeRepository) {
        this.aboutMeRepository = aboutMeRepository;
    }

    public List<AboutMe> getAllAboutMe() {
        return aboutMeRepository.findAll();
    }

    public Optional<AboutMe> getAboutMeById(Long id) {
        return aboutMeRepository.findById(id);
    }

    public AboutMe createOrUpdateAboutMe(AboutMe aboutMe) {
        return aboutMeRepository.save(aboutMe);
    }

    public void deleteAboutMe(Long id) {
        aboutMeRepository.deleteById(id);
    }

    public List<AboutMe> getAboutMeByLanguage(String language) {
        return aboutMeRepository.findByLanguage(language);
    }
}
*/