package com.example.placement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tital;
    private String description;
    private String elgibility;

    @ManyToOne
    private CompanyEntity company;
}
