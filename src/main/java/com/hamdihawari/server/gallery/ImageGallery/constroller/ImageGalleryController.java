package com.hamdihawari.server.gallery.ImageGallery.constroller;

import com.hamdihawari.server.gallery.ImageGallery.dto.ImageGalleryDTO;
import com.hamdihawari.server.gallery.ImageGallery.service.ImageGalleryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image-gallery")
public class ImageGalleryController {

    private final ImageGalleryService imageGalleryService;

    public ImageGalleryController(ImageGalleryService imageGalleryService) {
        this.imageGalleryService = imageGalleryService;
    }

    @GetMapping
    public ResponseEntity<List<ImageGalleryDTO>> getAllGalleries() {
        List<ImageGalleryDTO> galleries = imageGalleryService.getAllGalleries();
        return new ResponseEntity<>(galleries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageGalleryDTO> getGalleryById(@PathVariable Long id) {
        ImageGalleryDTO gallery = imageGalleryService.getGalleryById(id);
        return new ResponseEntity<>(gallery, HttpStatus.OK);
    }

    // Fetch image galleries by category name and language
    @GetMapping("/category/{category}/language/{languageId}")
    public ResponseEntity<List<ImageGalleryDTO>> getImageGalleriesByCategoryAndLanguage(
            @PathVariable String category,
            @PathVariable Long languageId) {
        List<ImageGalleryDTO> galleries = imageGalleryService.getImageGalleriesByCategoryAndLanguage(category, languageId);
        return new ResponseEntity<>(galleries, HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ImageGalleryDTO>> getImageGalleriesByCategory(@PathVariable String category) {
        List<ImageGalleryDTO> galleries = imageGalleryService.getImageGalleriesByCategory(category);
        return new ResponseEntity<>(galleries, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ImageGalleryDTO> createGallery(@RequestBody ImageGalleryDTO imageGalleryDTO) {
        ImageGalleryDTO createdGallery = imageGalleryService.createGallery(imageGalleryDTO);
        return new ResponseEntity<>(createdGallery, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageGalleryDTO> updateGallery(@PathVariable Long id, @RequestBody ImageGalleryDTO imageGalleryDTO) {
        ImageGalleryDTO updatedGallery = imageGalleryService.updateGallery(id, imageGalleryDTO);
        return new ResponseEntity<>(updatedGallery, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGallery(@PathVariable Long id) {
        imageGalleryService.deleteGallery(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
