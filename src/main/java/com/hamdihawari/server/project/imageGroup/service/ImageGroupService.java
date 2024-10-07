package com.hamdihawari.server.project.imageGroup.service;

import com.hamdihawari.server.project.imageGroup.dto.ImageDTO;
import com.hamdihawari.server.project.imageGroup.dto.ImageGroupDTO;
import com.hamdihawari.server.project.imageGroup.entity.Image;
import com.hamdihawari.server.project.imageGroup.entity.ImageGroup;
import com.hamdihawari.server.project.imageGroup.repository.ImageGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageGroupService {

    @Autowired
    private ImageGroupRepository imageGroupRepository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public List<ImageGroupDTO> getAllImageGroups() {
        return imageGroupRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ImageGroupDTO getImageGroupById(Long id) {
        return imageGroupRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public ImageGroupDTO createImageGroup(ImageGroupDTO imageGroupDTO) {
        ImageGroup imageGroup = new ImageGroup();
        imageGroup.setProjectDetailId(imageGroupDTO.getProjectDetailId());
        return convertToDTO(imageGroupRepository.save(imageGroup));
    }

    public ImageGroupDTO updateImageGroup(Long id, ImageGroupDTO imageGroupDTO) {
        return imageGroupRepository.findById(id).map(existingGroup -> {
            existingGroup.setProjectDetailId(imageGroupDTO.getProjectDetailId());
            return convertToDTO(imageGroupRepository.save(existingGroup));
        }).orElse(null);
    }

    public void deleteImageGroup(Long id) {
        imageGroupRepository.deleteById(id);
    }

    // Convert ImageGroup entity to DTO, including date formatting
    private ImageGroupDTO convertToDTO(ImageGroup imageGroup) {
        ImageGroupDTO dto = new ImageGroupDTO();
        dto.setId(imageGroup.getId());
        dto.setProjectDetailId(imageGroup.getProjectDetailId());

        // Formatting LocalDateTime to String
        dto.setCreatedAt(imageGroup.getCreatedAt() != null ? imageGroup.getCreatedAt().format(formatter) : null);
        dto.setUpdatedAt(imageGroup.getUpdatedAt() != null ? imageGroup.getUpdatedAt().format(formatter) : null);

        // Converting Image entities to DTOs
        dto.setImages(imageGroup.getImages().stream()
                .map(this::convertImageToDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    private ImageDTO convertImageToDTO(Image image) {
        ImageDTO dto = new ImageDTO();
        dto.setId(image.getId());
        dto.setImagePath(image.getImagePath());
        return dto;
    }
}
