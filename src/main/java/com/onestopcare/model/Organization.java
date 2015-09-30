package com.onestopcare.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/15.
 */
@Entity
@Table(name = "ORGANIZATION")
public class Organization extends PersistenceObject<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 256)
    private String name;

    @Size(max = 1000)
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    private Set<Module> modules = new HashSet<>();

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "ORGANIZATIONS_PATIENTS_LNK",
            joinColumns = @JoinColumn(name = "ORGANIZATION_ID", referencedColumnName = "ID", unique = false),
            inverseJoinColumns = @JoinColumn(name = "PATIENT_ID", referencedColumnName = "ID", unique = false))
    private Set<Patient> patients = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "PRIMARY_ADDRESS_ID", unique = false, nullable = true, updatable = true)
    private Address primaryAddress;

    @OneToOne
    @JoinColumn(name = "SECONDARY_ADDRESS_ID", unique = false, nullable = true, updatable = true)
    private Address secoundaryAddress;

    @OneToMany(mappedBy = "organization")
    private Set<User> users = new HashSet<>();

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

    public Set<User> getUsers() {
        return users;
    }

    public Organization setUsers(Set<User> users) {
        this.users = users;
        return this;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public Organization setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
        return this;
    }

    public Address getSecoundaryAddress() {
        return secoundaryAddress;
    }

    public Organization setSecoundaryAddress(Address secoundaryAddress) {
        this.secoundaryAddress = secoundaryAddress;
        return this;
    }
}
