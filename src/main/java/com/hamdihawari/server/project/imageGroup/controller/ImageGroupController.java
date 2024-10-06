package com.hamdihawari.server.project.imageGroup.controller;

import com.hamdihawari.server.project.imageGroup.dto.ImageGroupDTO;
import com.hamdihawari.server.project.imageGroup.entity.ImageGroup;
import com.hamdihawari.server.project.imageGroup.service.ImageGroupService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/image_group")
public class ImageGroupController {

    @Autowired
    private ImageGroupService imageGroupService;

    // Get all image groups
    @GetMapping
    public List<ImageGroupDTO> getAllImageGroups() {
        List<ImageGroup> imageGroups = imageGroupService.getAllImageGroups();
        return imageGroups.stream()
                .map(imageGroup -> new ImageGroupDTO(imageGroup.getId(), imageGroup.getProjectDetailId()))
                .collect(Collectors.toList());
    }

    // Create a new image group
    @PostMapping
    public ResponseEntity<ImageGroupDTO> createImageGroup(@RequestBody ImageGroupDTO imageGroupDTO) {
        ImageGroup newImageGroup = new ImageGroup();
        newImageGroup.setProjectDetailId(imageGroupDTO.getProjectDetailId());
        ImageGroup savedImageGroup = imageGroupService.createImageGroup(newImageGroup);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ImageGroupDTO(savedImageGroup.getId(), savedImageGroup.getProjectDetailId()));
    }

    // Update an existing image group
    @PutMapping("/{id}")
    public ResponseEntity<ImageGroupDTO> updateImageGroup(@PathVariable Long id, @RequestBody ImageGroupDTO imageGroupDTO) {
        try {
            ImageGroup updatedImageGroup = imageGroupService.updateImageGroup(id, imageGroupDTO);
            return ResponseEntity.ok(new ImageGroupDTO(updatedImageGroup.getId(), updatedImageGroup.getProjectDetailId()));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Delete an image group by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageGroup(@PathVariable Long id) {
        if (imageGroupService.deleteImageGroup(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

/*
package com.hamdihawari.server.project.imageGroup.controller;

import com.hamdihawari.server.project.imageGroup.dto.ImageGroupDTO;
import com.hamdihawari.server.project.imageGroup.entity.ImageGroup;
import com.hamdihawari.server.project.imageGroup.service.ImageGroupService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/image_group")
public class ImageGroupController {

    @Autowired
    private ImageGroupService imageGroupService;

    @GetMapping
    public List<ImageGroupDTO> getAllImageGroups() {
        return imageGroupService.getAllImageGroups().stream()
                .map(imageGroup -> new ImageGroupDTO(imageGroup.getId(), imageGroup.getProjectDetailId()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ImageGroupDTO> createImageGroup(@RequestBody ImageGroupDTO imageGroupDTO) {
        ImageGroup imageGroup = new ImageGroup(imageGroupDTO.getProjectDetailId());
        ImageGroup createdImageGroup = imageGroupService.createImageGroup(imageGroup);
        return ResponseEntity.ok(new ImageGroupDTO(createdImageGroup.getId(), createdImageGroup.getProjectDetailId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageGroup> updateImageGroup(@PathVariable Long id, @RequestBody ImageGroup updatedImageGroup) {
        try {
            // Call the service method to update the ImageGroup
            ImageGroup existingImageGroup = imageGroupService.updateImageGroup(id, updatedImageGroup);
            return ResponseEntity.ok(existingImageGroup); // 200 OK with the updated entity
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found if the entity does not exist
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageGroup(@PathVariable Long id) {
        try {
            imageGroupService.deleteImageGroupById(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}
*/
