package com.hamdihawari.server.gallery.ImageGallery.mapper;

import com.hamdihawari.server.gallery.ImageGallery.dto.ImageGalleryTranslationDTO;
import com.hamdihawari.server.gallery.ImageGallery.entity.ImageGalleryTranslation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ImageGalleryTranslationMapper {

    @Mapping(source = "imageGallery.id", target = "imageGalleryId")
    @Mapping(source = "language.id", target = "languageId")
    ImageGalleryTranslationDTO toDTO(ImageGalleryTranslation imageGalleryTranslation);

    @Mapping(source = "imageGalleryId", target = "imageGallery.id")
    @Mapping(source = "languageId", target = "language.id")
    ImageGalleryTranslation toEntity(ImageGalleryTranslationDTO imageGalleryTranslationDTO);
}
