package com.vms.vaccine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

    @Column(name = "Vaccine_Cost", nullable = false)
    private Double cost;

    @Builder.Default
    @Column(name = "Available_Doses")
    private Integer availableDoses = 0;
}
