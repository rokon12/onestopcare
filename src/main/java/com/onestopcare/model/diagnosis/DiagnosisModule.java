package com.onestopcare.model.diagnosis;

import com.onestopcare.model.Module;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/15.
 */
@Entity
@Table(name = "DIAGNOSIS_MODULE")
public class DiagnosisModule extends Module {
    @OneToMany
    @JoinColumn(name = "DIAGNOSIS_MODULE_ID")
    private Set<Diagnosis> diagnoses = new HashSet<>();

    public Set<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public DiagnosisModule setDiagnoses(Set<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
        return this;
    }
}
