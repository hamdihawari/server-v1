package com.hamdihawari.server.project.projectDetails;

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

    @Column
    private String subjectDetails;

    @Column(nullable = false, length = 2000)
    private String cardDescription;

    public ProjectDetails() {
    }

    public ProjectDetails(Long id, ProjectCard projectCard, String subjectDetails, String cardDescription) {
        this.id = id;
        this.projectCard = projectCard;
        this.subjectDetails = subjectDetails;
        this.cardDescription = cardDescription;
    }

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

    @Override
    public String toString() {
        return "ProjectDetails{" +
                "id=" + id +
                ", projectCard=" + projectCard +
                ", subjectDetails='" + subjectDetails + '\'' +
                ", cardDescription='" + cardDescription + '\'' +
                '}';
    }
}
