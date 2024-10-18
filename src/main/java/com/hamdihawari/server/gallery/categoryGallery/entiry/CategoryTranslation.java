package com.hamdihawari.server.gallery.categoryGallery.entiry;

import com.hamdihawari.server.project.language.entity.Language;
import jakarta.persistence.*;

@Entity
@Table(name = "category_translation", uniqueConstraints = {@UniqueConstraint(columnNames = {"category_id", "language_id"})})
public class CategoryTranslation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_category_translation_category"))
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", foreignKey = @ForeignKey(name = "fk_category_translation_language"))
    private Language language;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "header_text", length = 255)
    private String headerText;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
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
