package com.onestopcare.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/15.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Module extends PersistenceObject<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "ORGANIZATION_ID")
    private Organization organization;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "MODULES_PATIENTS_LNK",
            joinColumns = @JoinColumn(name = "MODULE_ID", referencedColumnName = "ID", unique = false),
            inverseJoinColumns = @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID", unique = false))
    private Set<Patient> patients = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Module setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Module setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Module setDescription(String description) {
        this.description = description;
        return this;
    }

    public Organization getOrganization() {
        return organization;
    }

    public Module setOrganization(Organization organization) {
        this.organization = organization;
        return this;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public Module setPatients(Set<Patient> patients) {
        this.patients = patients;
        return this;
    }
}

