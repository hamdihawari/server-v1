package com.hamdihawari.server.project.imageGroup.service;

import com.hamdihawari.server.project.imageGroup.dto.ImageDTO;
import com.hamdihawari.server.project.imageGroup.dto.ImageGroupDTO;
import com.hamdihawari.server.project.imageGroup.entity.Image;
import com.hamdihawari.server.project.imageGroup.entity.ImageGroup;
import com.hamdihawari.server.project.imageGroup.repository.ImageGroupRepository;
import com.hamdihawari.server.project.projectDetails.entity.ProjectDetails;
import com.hamdihawari.server.project.projectDetails.repository.ProjectDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageGroupService {

    private final ImageGroupRepository imageGroupRepository;
    private final ProjectDetailsRepository projectDetailsRepository; // Add this

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Autowired
    public ImageGroupService(ImageGroupRepository imageGroupRepository, ProjectDetailsRepository projectDetailsRepository) {
        this.imageGroupRepository = imageGroupRepository;
        this.projectDetailsRepository = projectDetailsRepository;
    }

    public List<ImageGroupDTO> getAllImageGroups() {
        return imageGroupRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ImageGroupDTO> getImageGroupById(Long id) {
        return imageGroupRepository.findById(id).map(this::convertToDTO);
    }

    public ImageGroupDTO createImageGroup(ImageGroupDTO imageGroupDTO) {
        ImageGroup imageGroup = new ImageGroup();

        // Fetch ProjectDetails using the ID
        Optional<ProjectDetails> projectDetailOptional = projectDetailsRepository.findById(imageGroupDTO.getProjectDetailId());

        if (projectDetailOptional.isPresent()) {
            imageGroup.setProjectDetail(projectDetailOptional.get()); // Set the ProjectDetails object
            return convertToDTO(imageGroupRepository.save(imageGroup));
        } else {
            throw new IllegalArgumentException("ProjectDetail with ID " + imageGroupDTO.getProjectDetailId() + " not found.");
        }
    }

    public Optional<ImageGroupDTO> updateImageGroup(Long id, ImageGroupDTO imageGroupDTO) {
        return imageGroupRepository.findById(id)
                .map(existingGroup -> {
                    // Fetch ProjectDetails using the ID
                    Optional<ProjectDetails> projectDetailOptional = projectDetailsRepository.findById(imageGroupDTO.getProjectDetailId());

                    if (projectDetailOptional.isPresent()) {
                        existingGroup.setProjectDetail(projectDetailOptional.get()); // Set the ProjectDetails object
                        return convertToDTO(imageGroupRepository.save(existingGroup));
                    } else {
                        throw new IllegalArgumentException("ProjectDetail with ID " + imageGroupDTO.getProjectDetailId() + " not found.");
                    }
                });
    }

    public boolean deleteImageGroup(Long id) {
        if (imageGroupRepository.existsById(id)) {
            imageGroupRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private ImageGroupDTO convertToDTO(ImageGroup imageGroup) {
        ImageGroupDTO dto = new ImageGroupDTO();
        dto.setId(imageGroup.getId());
        dto.setProjectDetailId(imageGroup.getProjectDetail().getId()); // Get ID from ProjectDetails object
        dto.setCreatedAt(imageGroup.getCreatedAt() != null ? imageGroup.getCreatedAt().format(formatter) : null);
        dto.setUpdatedAt(imageGroup.getUpdatedAt() != null ? imageGroup.getUpdatedAt().format(formatter) : null);
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
