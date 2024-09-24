package com.hamdihawari.server.project.projectDetails;

import com.hamdihawari.server.language.Language;
import com.hamdihawari.server.project.projectCard.ProjectCard;
import jakarta.persistence.*;

@Entity
@Table(name = "project_details")
public class ProjectDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_card_id", nullable = false)
    private ProjectCard projectCard;

    @Column(nullable = true)
    private String subjectDetails;

    @Column(nullable = false, length = 2000)
    private String cardDescription;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    // Constructors
    public ProjectDetails() {
    }

    public ProjectDetails(Long id, ProjectCard projectCard, String subjectDetails, String cardDescription, Language language) {
        this.id = id;
        this.projectCard = projectCard;
        this.subjectDetails = subjectDetails;
        this.cardDescription = cardDescription;
        this.language = language;
    }

    // Getters and Setters
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "ProjectDetails{" +
                "id=" + id +
                ", projectCard=" + projectCard +
                ", subjectDetails='" + subjectDetails + '\'' +
                ", cardDescription='" + cardDescription + '\'' +
                ", language=" + language +
                '}';
    }
}
