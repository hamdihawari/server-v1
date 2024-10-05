package com.hamdihawari.server.contact;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contact")
@Data
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private String submit;

    public Contact(Long id, String language, String firstname, String lastname, String email, String message, String title, String description, String submit) {
        this.id = id;
        this.language = language;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.message = message;
        this.title = title;
        this.description = description;
        this.submit = submit;
    }
}


