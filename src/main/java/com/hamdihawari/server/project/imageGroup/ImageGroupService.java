package com.hamdihawari.server.project.imageGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ImageGroupService {

    private final ImageGroupRepository imageGroupRepository;

    @Autowired
    public ImageGroupService(ImageGroupRepository imageGroupRepository) {
        this.imageGroupRepository = imageGroupRepository;
    }

    // Fetch all ImageGroups
    public List<ImageGroup> getAllImageGroups() {
        return imageGroupRepository.findAll();
    }

    // Fetch ImageGroups by ProjectDetailsId
    public List<ImageGroup> getImagesByProjectDetailsId(Long projectDetailsId) {
        return imageGroupRepository.findByProjectDetailsId(projectDetailsId);
    }

    // Fetch a single ImageGroup by ID
    public Optional<ImageGroup> getImageGroupById(Long id) {
        return imageGroupRepository.findById(id);
    }

    // Create or update an ImageGroup (Transactional for consistency)
    @Transactional
    public ImageGroup createOrUpdateImageGroup(ImageGroup imageGroup) {
        return imageGroupRepository.save(imageGroup);
    }

    // Delete ImageGroup by ID
    @Transactional
    public void deleteImageGroup(Long id) {
        if (imageGroupRepository.existsById(id)) {
            imageGroupRepository.deleteById(id);
        } else {
            throw new RuntimeException("ImageGroup not found with id: " + id);
        }
    }
}
