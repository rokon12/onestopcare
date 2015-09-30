package com.onestopcare.model.medicalhistory;

import com.onestopcare.model.Module;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/15.
 */
public class MedicalHistoryModule extends Module {

    private Set<MedicalHistory> medicalHistories = new HashSet<>();
}
