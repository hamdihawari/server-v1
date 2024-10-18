package com.hamdihawari.server.gallery.categoryGallery.mapper;

import com.hamdihawari.server.gallery.categoryGallery.dto.CategoryTranslationDTO;
import com.hamdihawari.server.gallery.categoryGallery.entiry.CategoryTranslation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryTranslationMapper {

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "language.id", target = "languageId")
    CategoryTranslationDTO toDTO(CategoryTranslation categoryTranslation);

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "languageId", target = "language.id")
    CategoryTranslation toEntity(CategoryTranslationDTO categoryTranslationDTO);
}
