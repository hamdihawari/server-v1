package com.hamdihawari.server.about;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/about")
@CrossOrigin(origins = "http://localhost:3000")
public class AboutMeController {

    private final AboutMeService aboutMeService;

    @Autowired
    public AboutMeController(AboutMeService aboutMeService) {
        this.aboutMeService = aboutMeService;
    }

    // GET all AboutMe entries
    @GetMapping
    public ResponseEntity<List<AboutMe>> getAllAboutMe() {
        return new ResponseEntity<>(aboutMeService.getAllAboutMe(), HttpStatus.OK);
    }

    // GET AboutMe by ID
    @GetMapping("/{id}")
    public ResponseEntity<AboutMe> getAboutMeById(@PathVariable Long id) {
        Optional<AboutMe> aboutMe = aboutMeService.getAboutMeById(id);
        return aboutMe.map(me -> new ResponseEntity<>(me, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // GET AboutMe by language
    @GetMapping("/language/{language}")
    public ResponseEntity<List<AboutMe>> getAboutMeByLanguage(@PathVariable String language) {
        return new ResponseEntity<>(aboutMeService.getAboutMeByLanguage(language), HttpStatus.OK);
    }

    // POST: Create a new AboutMe entry
    @PostMapping
    public ResponseEntity<AboutMe> createAboutMe(@RequestBody AboutMe aboutMe) {
        return new ResponseEntity<>(aboutMeService.createOrUpdateAboutMe(aboutMe), HttpStatus.CREATED);
    }

    // PUT: Update an existing AboutMe entry by ID
    @PutMapping("/{id}")
    public ResponseEntity<AboutMe> updateAboutMe(@PathVariable Long id, @RequestBody AboutMe aboutMe) {
        Optional<AboutMe> existingAboutMe = aboutMeService.getAboutMeById(id);
        if (existingAboutMe.isPresent()) {
            aboutMe.setId(id);
            return new ResponseEntity<>(aboutMeService.createOrUpdateAboutMe(aboutMe), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // DELETE: Delete an AboutMe entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAboutMe(@PathVariable Long id) {
        Optional<AboutMe> existingAboutMe = aboutMeService.getAboutMeById(id);
        if (existingAboutMe.isPresent()) {
            aboutMeService.deleteAboutMe(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
