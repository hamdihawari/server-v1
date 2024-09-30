package com.hamdihawari.server.projectCard.entity;

import com.hamdihawari.server.language.entity.Language;
import jakarta.persistence.*;

@Entity
@Table(name = "project_card_translation")
public class ProjectCardTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_card_id", nullable = false)
    private ProjectCard projectCard;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    private String subject;
    private String data;
    private String description;

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectCard getProjectCard() {
        return projectCard;
    }

    public void setProjectCard(ProjectCard projectCard) {
        this.projectCard = projectCard;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
