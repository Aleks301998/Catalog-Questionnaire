package com.example.Catalog.Questionnaire.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
@Table(name = "catalog")
public class CatalogModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String gender;
    private LocalDate birth;
    private String occupation;
    private String customOccupation;

    public CatalogModels(String lastName, String firstName, String middleName, String gender, LocalDate birth, String occupation, String customOccupation) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gender = gender;
        this.birth = birth;
        this.occupation = occupation;
        this.customOccupation = customOccupation;
    }

    public CatalogModels() {
    }
}
