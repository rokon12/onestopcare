package com.onestopcare.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/15.
 */
@Entity
@Table(name = "ORGANIZATION")
public class Organization extends PersistenceObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    private Set<Module> modules = new HashSet<>();

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "ORGANIZATION_PATIENTS",
            joinColumns = @JoinColumn(name = "ORGANIZATION_ID", referencedColumnName = "ID", unique = false),
            inverseJoinColumns = @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID", unique = false))
    private Set<Patient> patients = new HashSet<>();

    //private Set<User> users = new HashSet<>();


    public Long getId() {
        return id;
    }

    public Organization setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Organization setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Organization setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public Organization setModules(Set<Module> modules) {
        this.modules = modules;
        return this;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public Organization setPatients(Set<Patient> patients) {
        this.patients = patients;
        return this;
    }
}
