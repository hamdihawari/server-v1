package com.hamdihawari.server.project.imageGroup.controller;

import com.hamdihawari.server.project.imageGroup.dto.ImageGroupDTO;
import com.hamdihawari.server.project.imageGroup.service.ImageGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image_group")
public class ImageGroupController {

    private final ImageGroupService imageGroupService;

    @Autowired
    public ImageGroupController(ImageGroupService imageGroupService) {
        this.imageGroupService = imageGroupService;
    }

    @GetMapping
    public List<ImageGroupDTO> getAllImageGroups() {
        return imageGroupService.getAllImageGroups();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageGroupDTO> getImageGroupById(@PathVariable Long id) {
        return imageGroupService.getImageGroupById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ImageGroupDTO> createImageGroup(@RequestBody ImageGroupDTO imageGroupDTO) {
        return ResponseEntity.status(201).body(imageGroupService.createImageGroup(imageGroupDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageGroupDTO> updateImageGroup(@PathVariable Long id, @RequestBody ImageGroupDTO imageGroupDTO) {
        return imageGroupService.updateImageGroup(id, imageGroupDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageGroup(@PathVariable Long id) {
        if (imageGroupService.deleteImageGroup(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
