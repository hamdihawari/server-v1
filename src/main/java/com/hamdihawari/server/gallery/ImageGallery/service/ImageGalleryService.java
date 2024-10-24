package com.hamdihawari.server.gallery.ImageGallery.service;

import com.hamdihawari.server.gallery.ImageGallery.dto.ImageGalleryDTO;
import com.hamdihawari.server.gallery.ImageGallery.entity.ImageGallery;
import com.hamdihawari.server.gallery.ImageGallery.mapper.ImageGalleryMapper;
import com.hamdihawari.server.gallery.ImageGallery.repository.ImageGalleryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageGalleryService {

    private final ImageGalleryRepository imageGalleryRepository;
    private final ImageGalleryMapper imageGalleryMapper;

    public ImageGalleryService(ImageGalleryRepository imageGalleryRepository, ImageGalleryMapper imageGalleryMapper) {
        this.imageGalleryRepository = imageGalleryRepository;
        this.imageGalleryMapper = imageGalleryMapper;
    }

    public List<ImageGalleryDTO> getAllGalleries(){
        return imageGalleryRepository.findAll().stream()
                .map(imageGalleryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ImageGalleryDTO getGalleryById(Long id){
        ImageGallery imageGallery = imageGalleryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gallery not found"));
        return imageGalleryMapper.toDTO(imageGallery);
    }

    public ImageGalleryDTO createGallery(ImageGalleryDTO imageGalleryDTO){
        ImageGallery imageGallery = imageGalleryMapper.toEntity(imageGalleryDTO);
        ImageGallery savedGallery = imageGalleryRepository.save(imageGallery);
        return imageGalleryMapper.toDTO(savedGallery);
    }

    public ImageGalleryDTO updateGallery(Long id, ImageGalleryDTO imageGalleryDTO){
        ImageGallery imageGallery = imageGalleryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gallery not found"));

        // Update fields related to the image gallery, including new fields
        imageGallery.setOriginal(imageGalleryDTO.getOriginal());
        imageGallery.setThumbnail(imageGalleryDTO.getThumbnail());
        imageGallery.setTaken(imageGalleryDTO.getTaken());
        imageGallery.setCameraMake(imageGalleryDTO.getCameraMake());
        imageGallery.setCameraModel(imageGalleryDTO.getCameraModel());
        imageGallery.setLens(imageGalleryDTO.getLens());
        imageGallery.setAperture(imageGalleryDTO.getAperture());
        imageGallery.setLensType(imageGalleryDTO.getLensType());
        imageGallery.setAutofocus(imageGalleryDTO.getAutofocus());
        imageGallery.setShutterSpeed(imageGalleryDTO.getShutterSpeed());
        imageGallery.setFlashUsed(imageGalleryDTO.getFlashUsed());
        imageGallery.setIsoValue(imageGalleryDTO.getIsoValue());
        imageGallery.setUpdatedAt(imageGalleryDTO.getUpdatedAt());

        ImageGallery updatedGallery = imageGalleryRepository.save(imageGallery);
        return imageGalleryMapper.toDTO(updatedGallery);
    }

    public void deleteGallery(Long id) {
        imageGalleryRepository.deleteById(id);
    }

    // Fetch galleries by category name
    public List<ImageGalleryDTO> getImageGalleriesByCategory(String category) {
        List<ImageGallery> galleries = imageGalleryRepository.findByCategoryName(category);
        return galleries.stream().map(imageGalleryMapper::toDTO).collect(Collectors.toList());
    }

    // Fetch galleries by category name and language
    public List<ImageGalleryDTO> getImageGalleriesByCategoryAndLanguage(String categoryName, Long languageId) {
        List<ImageGallery> galleries = imageGalleryRepository.findByCategoryNameAndLanguage(categoryName, languageId);
        return galleries.stream().map(imageGalleryMapper::toDTO).collect(Collectors.toList());
    }
}
