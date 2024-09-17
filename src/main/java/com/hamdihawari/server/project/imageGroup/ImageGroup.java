package com.hamdihawari.server.project.imageGroup;

import com.hamdihawari.server.project.projectDetails.ProjectDetails;
import jakarta.persistence.*;

@Entity
@Table(name = "image_group")
public class ImageGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_details_id", nullable = false)
    private ProjectDetails projectDetail;

    @Column(name = "image_url", nullable = false)  // Corrected column name
    private String imgUrl;

    @Column
    private String imageSubject;

    public ImageGroup() {}

    public ImageGroup(Long id, ProjectDetails projectDetail, String imgUrl, String imageSubject) {
        this.id = id;
        this.projectDetail = projectDetail;
        this.imgUrl = imgUrl;
        this.imageSubject = imageSubject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectDetails getProjectDetail() {
        return projectDetail;
    }

    public void setProjectDetail(ProjectDetails projectDetail) {
        this.projectDetail = projectDetail;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImageSubject() {
        return imageSubject;
    }

    public void setImageSubject(String imageSubject) {
        this.imageSubject = imageSubject;
    }

    @Override
    public String toString() {
        return "ImageGroup{" +
                "id=" + id +
                ", projectDetail=" + projectDetail +
                ", imgUrl='" + imgUrl + '\'' +
                ", imageSubject='" + imageSubject + '\'' +
                '}';
    }
}
