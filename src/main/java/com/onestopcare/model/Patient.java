package com.onestopcare.model;

import com.onestopcare.model.enums.Gender;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/15.
 */

@Entity
@Table(name = "PATIENT")
public class Patient extends PersistenceObject<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 120)
    private String fullName;
    private Gender gender;
    private LocalDate birthDate;

    @Size(max = 20)
    private String nid; // National Identification No

    @OneToOne
    @JoinColumn(name = "PRIMARY_ADDRESS_ID", unique = false, nullable = true, updatable = true)
    private Address primaryAddress;

    @OneToOne
    @JoinColumn(name = "SECONDARY_ADDRESS_ID", unique = false, nullable = true, updatable = true)
    private Address secoundaryAddress;

    private Boolean dead = false;

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

    public Gender getGender() {
        return gender;
    }

    public Patient setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getNid() {
        return nid;
    }

    public Patient setNid(String nid) {
        this.nid = nid;
        return this;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public Patient setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
        return this;
    }

    public Address getSecoundaryAddress() {
        return secoundaryAddress;
    }

    public Patient setSecoundaryAddress(Address secoundaryAddress) {
        this.secoundaryAddress = secoundaryAddress;
        return this;
    }

    public Boolean getDead() {
        return dead;
    }

    public Patient setDead(Boolean dead) {
        this.dead = dead;
        return this;
    }
}
