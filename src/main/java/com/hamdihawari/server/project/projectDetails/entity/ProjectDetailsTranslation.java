package com.hamdihawari.server.project.projectDetails.entity;

import com.hamdihawari.server.project.language.entity.Language;
import jakarta.persistence.*;
import com.hamdihawari.server.project.projectDetails.entity.ProjectDetailsTranslation;

@Entity
@Table(name = "project_details_translation")
public class ProjectDetailsTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_details_id", nullable = false)
    private ProjectDetails projectDetails;


    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @Column(columnDefinition = "TEXT")
    private String subjectDetails;

    @Column(columnDefinition = "TEXT")
    private String cardDescription;

    public ProjectDetailsTranslation() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectDetails getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(ProjectDetails projectDetails) {
        this.projectDetails = projectDetails;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getSubjectDetails() {
        return subjectDetails;
    }

    public void setSubjectDetails(String subjectDetails) {
        this.subjectDetails = subjectDetails;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }
}
