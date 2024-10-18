package com.hamdihawari.server.gallery.categoryGallery.mapper;

import com.hamdihawari.server.gallery.categoryGallery.dto.CategoryDTO;
import com.hamdihawari.server.gallery.categoryGallery.entiry.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    // Mapping ZonedDateTime to LocalDateTime and vice versa without @Named
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    CategoryDTO toDTO(Category category);

    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "updatedAt", target = "updatedAt")
    Category toEntity(CategoryDTO categoryDTO);

    // Custom mapping method to convert LocalDateTime to ZonedDateTime
    default ZonedDateTime localDateTimeToZonedDateTime(LocalDateTime localDateTime) {
        return localDateTime != null ? localDateTime.atZone(ZoneId.systemDefault()) : null;
    }

    // Custom mapping method to convert ZonedDateTime to LocalDateTime
    default LocalDateTime zonedDateTimeToLocalDateTime(ZonedDateTime zonedDateTime) {
        return zonedDateTime != null ? zonedDateTime.toLocalDateTime() : null;
    }
}
