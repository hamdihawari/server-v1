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

    public Optional<Image> findById(Long id) {
        return imageRepository.findById(id);
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public List<Image> createImages(List<Image> images) {
        return imageRepository.saveAll(images); // This will save all images in one go
    }

    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

    public Optional<Image> updateImage(Long id, Image imageDetails) {
        return imageRepository.findById(id).map(image -> {
            image.setImagePath(imageDetails.getImagePath());
            image.setImageGroup(imageDetails.getImageGroup()); // Assuming you want to update the image group as well
            return imageRepository.save(image);
        });
    }

    public boolean deleteImage(Long id) {
        if (imageRepository.existsById(id)) {
            imageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
