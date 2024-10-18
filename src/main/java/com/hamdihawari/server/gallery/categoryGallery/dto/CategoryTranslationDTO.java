package com.hamdihawari.server.gallery.categoryGallery.dto;

public class CategoryTranslationDTO {
    private Long id;                   // ID der Übersetzung
    private Long categoryId;           // Verknüpfung zur Kategorie
    private Long languageId;           // Verknüpfung zur Sprache
    private String name;               // Name der Kategorie in der jeweiligen Sprache
    private String headerText;         // Header-Text der Kategorie in der jeweiligen Sprache

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Long languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeaderText() {
        return headerText;
    }

    public void setHeaderText(String headerText) {
        this.headerText = headerText;
    }
}
