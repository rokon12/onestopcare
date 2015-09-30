package com.onestopcare.model.diagnosis;

import com.onestopcare.model.Patient;
import com.onestopcare.model.PersistenceObject;

import javax.persistence.*;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/15.
 */
@Entity
public class Diagnosis extends PersistenceObject<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    private Patient patient;

    public Long getId() {
        return id;
    }

    public Diagnosis setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Diagnosis setName(String name) {
        this.name = name;
        return this;
    }

    public Patient getPatient() {
        return patient;
    }

    public Diagnosis setPatient(Patient patient) {
        this.patient = patient;
        return this;
    }
}
