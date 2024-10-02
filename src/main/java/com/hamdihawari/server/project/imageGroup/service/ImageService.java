package com.hamdihawari.server.project.imageGroup.service;

import com.hamdihawari.server.project.imageGroup.entity.Image;
import com.hamdihawari.server.project.imageGroup.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    // Update an existing image
    public Optional<Image> updateImage(Long id, Image imageDetails) {
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            Image image = imageOptional.get();
            image.setImageGroupId(imageDetails.getImageGroupId());
            image.setImagePath(imageDetails.getImagePath());
            return Optional.of(imageRepository.save(image));
        }
        return Optional.empty(); // Image not found
    }

    // Delete an image by ID
    public boolean deleteImage(Long id) {
        if (imageRepository.existsById(id)) {
            imageRepository.deleteById(id);
            return true;
        }
        return false; // Image not found
    }
}
