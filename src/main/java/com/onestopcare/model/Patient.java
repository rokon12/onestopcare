package com.onestopcare.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/15.
 */

@Entity
@Table(name = "PATIENT")
public class Patient extends PersistenceObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;
    private String sex;
    private LocalDate birthDate;

    @Size(max = 32)
    @Column(length = 32)
    private String healthId;

    public Long getId() {
        return id;
    }

    public Patient setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Patient setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Patient setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Patient setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getHealthId() {
        return healthId;
    }

    public Patient setHealthId(String healthId) {
        this.healthId = healthId;
        return this;
    }
}
