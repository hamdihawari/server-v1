package com.hamdihawari.server.project.imageGroup.service;

import com.hamdihawari.server.project.imageGroup.entity.ImageGroup;
import com.hamdihawari.server.project.imageGroup.repository.ImageGroupRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageGroupService {

    @Autowired
    private ImageGroupRepository imageGroupRepository;

    public List<ImageGroup> getAllImageGroups() {
        return imageGroupRepository.findAll();
    }

    public ImageGroup createImageGroup(ImageGroup imageGroup) {
        return imageGroupRepository.save(imageGroup);
    }

    public ImageGroup updateImageGroup(Long id, ImageGroup updatedImageGroup) {
        ImageGroup existingImageGroup = imageGroupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ImageGroup not found with id " + id));

        existingImageGroup.setProjectDetailId(updatedImageGroup.getProjectDetailId());

        return imageGroupRepository.save(existingImageGroup);
    }

    public void deleteImageGroupById(Long id) {
        // Check if the entity exists before trying to delete it
        if (!imageGroupRepository.existsById(id)) {
            throw new EntityNotFoundException("ImageGroup not found with id: " + id);
        }
        imageGroupRepository.deleteById(id); // Delete the entity
    }
}
