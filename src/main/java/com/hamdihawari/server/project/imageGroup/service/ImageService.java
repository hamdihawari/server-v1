package com.hamdihawari.server.project.imageGroup.service;

import com.hamdihawari.server.project.imageGroup.dto.ImageDTO;
import com.hamdihawari.server.project.imageGroup.entity.Image;
import com.hamdihawari.server.project.imageGroup.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<ImageDTO> getAllImages() {
        return imageRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ImageDTO getImageById(Long id) {
        return imageRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public ImageDTO createImage(ImageDTO imageDTO) {
        Image image = new Image();
        image.setImagePath(imageDTO.getImagePath());
        return convertToDTO(imageRepository.save(image));
    }

    public ImageDTO updateImage(Long id, ImageDTO imageDTO) {
        return imageRepository.findById(id).map(existingImage -> {
            existingImage.setImagePath(imageDTO.getImagePath());
            return convertToDTO(imageRepository.save(existingImage));
        }).orElse(null);
    }

    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    private ImageDTO convertToDTO(Image image) {
        ImageDTO dto = new ImageDTO();
        dto.setId(image.getId());
        dto.setImagePath(image.getImagePath());
        return dto;
    }
}
