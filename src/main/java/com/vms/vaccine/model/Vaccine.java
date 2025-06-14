package com.vms.vaccine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Vaccines")
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Vaccine_Id")
    private Long id;

    @Column(name = "Vaccine_Name", nullable = false)
    private String vaccineName;

    @Column(name = "Vaccine_Company", nullable = false)
    private String vaccineCompany;

    @Column(name = "Vaccine_Cost_INR", nullable = false)
    private Double cost;

    @Column(name = "Available_Doses")
    private Integer availableDoses = 0;

    @Column(name = "Disease_Effective_Against")
    private String effectiveAgainst;

    @Builder
    public Vaccine(String vaccineName, String vaccineCompany, Double cost, Integer availableDoses, String effectiveAgainst) {
        this.vaccineName = vaccineName;
        this.vaccineCompany = vaccineCompany;
        this.cost = cost;
        this.availableDoses = availableDoses;
        this.effectiveAgainst = effectiveAgainst;
    }
}
