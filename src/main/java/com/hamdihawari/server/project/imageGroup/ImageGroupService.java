package com.hamdihawari.server.project.imageGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageGroupService {

    private final ImageGroupRepository imageGroupRepository;

    @Autowired
    public ImageGroupService(ImageGroupRepository imageGroupRepository) {
        this.imageGroupRepository = imageGroupRepository;
    }

    public List<ImageGroup> getAllImageGroups() {
        return imageGroupRepository.findAll();
    }

    public Optional<ImageGroup> getImageGroupById(Long id) {
        return imageGroupRepository.findById(id);
    }

    public ImageGroup createOrUpdateImageGroup(ImageGroup imageGroup) {
        return imageGroupRepository.save(imageGroup);
    }

    public void deleteImageGroup(Long id) {
        imageGroupRepository.deleteById(id);
    }
}
