package com.hamdihawari.server.project.imageGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/image_group")
@CrossOrigin(origins = "http://localhost:5173")
public class ImageGroupController {

    private final ImageGroupService imageGroupService;

    @Autowired
    public ImageGroupController(ImageGroupService imageGroupService) {
        this.imageGroupService = imageGroupService;
    }

    @GetMapping
    public ResponseEntity<List<ImageGroup>> getAllImageGroups() {
        return new ResponseEntity<>(imageGroupService.getAllImageGroups(), HttpStatus.OK);
    }

    @GetMapping
    public List<ImageGroup> getImagesByProjectDetailsId(@RequestParam Long project_details_id) {
        return imageGroupService.getImagesByProjectDetailsId(project_details_id);
    }



    @GetMapping("/{id}")
    public ResponseEntity<ImageGroup> getImageGroupById(@PathVariable Long id) {
        Optional<ImageGroup> imageGroup = imageGroupService.getImageGroupById(id);
        return imageGroup.map(group -> new ResponseEntity<>(group, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ImageGroup> createImageGroup(@RequestBody ImageGroup imageGroup) {
        return new ResponseEntity<>(imageGroupService.createOrUpdateImageGroup(imageGroup), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageGroup> updateImageGroup(@PathVariable Long id, @RequestBody ImageGroup imageGroup) {
        Optional<ImageGroup> existingGroup = imageGroupService.getImageGroupById(id);
        if (existingGroup.isPresent()) {
            imageGroup.setId(id);
            return new ResponseEntity<>(imageGroupService.createOrUpdateImageGroup(imageGroup), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageGroup(@PathVariable Long id) {
        Optional<ImageGroup> existingGroup = imageGroupService.getImageGroupById(id);
        if (existingGroup.isPresent()) {
            imageGroupService.deleteImageGroup(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
