package com.hamdihawari.server.project.imageGroup.controller;

import com.hamdihawari.server.project.imageGroup.dto.ImageGroupDTO;
import com.hamdihawari.server.project.imageGroup.service.ImageGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image_group")
public class ImageGroupController {

    @Autowired
    private ImageGroupService imageGroupService;

    @GetMapping
    public List<ImageGroupDTO> getAllImageGroups() {
        return imageGroupService.getAllImageGroups();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageGroupDTO> getImageGroupById(@PathVariable Long id) {
        ImageGroupDTO imageGroupDTO = imageGroupService.getImageGroupById(id);
        return imageGroupDTO != null ? ResponseEntity.ok(imageGroupDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ImageGroupDTO> createImageGroup(@RequestBody ImageGroupDTO imageGroupDTO) {
        return new ResponseEntity<>(imageGroupService.createImageGroup(imageGroupDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageGroupDTO> updateImageGroup(@PathVariable Long id, @RequestBody ImageGroupDTO imageGroupDTO) {
        ImageGroupDTO updatedImageGroup = imageGroupService.updateImageGroup(id, imageGroupDTO);
        return updatedImageGroup != null ? ResponseEntity.ok(updatedImageGroup) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageGroup(@PathVariable Long id) {
        imageGroupService.deleteImageGroup(id);
        return ResponseEntity.noContent().build();
    }
}


