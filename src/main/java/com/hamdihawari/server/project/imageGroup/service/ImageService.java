package com.hamdihawari.server.project.imageGroup.service;

import com.hamdihawari.server.project.imageGroup.dto.ImageDTO;
import com.hamdihawari.server.project.imageGroup.entity.Image;
import com.hamdihawari.server.project.imageGroup.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<ImageDTO> getAllImages() {
        return imageRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ImageDTO> getImageById(Long id) {
        return imageRepository.findById(id).map(this::convertToDTO);
    }

    public ImageDTO createImage(ImageDTO imageDTO) {
        Image image = new Image();
        image.setImagePath(imageDTO.getImagePath());
        return convertToDTO(imageRepository.save(image));
    }

    public Optional<ImageDTO> updateImage(Long id, ImageDTO imageDTO) {
        return imageRepository.findById(id).map(existingImage -> {
            existingImage.setImagePath(imageDTO.getImagePath());
            return convertToDTO(imageRepository.save(existingImage));
        });
    }

    public boolean deleteImage(Long id) {
        if (imageRepository.existsById(id)) {
            imageRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private ImageDTO convertToDTO(Image image) {
        ImageDTO dto = new ImageDTO();
        dto.setId(image.getId());
        dto.setImagePath(image.getImagePath());
        return dto;
    }
}
