package com.hamdihawari.server.gallery.ImageGallery.mapper;

import com.hamdihawari.server.gallery.ImageGallery.dto.ImageGalleryDTO;
import com.hamdihawari.server.gallery.ImageGallery.entity.ImageGallery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImageGalleryMapper {

    @Mapping(source = "category.id", target = "categoryId")
    ImageGalleryDTO toDTO(ImageGallery imageGallery);

    @Mapping(source = "categoryId", target = "category.id")
    ImageGallery toEntity(ImageGalleryDTO imageGalleryDTO);
}
