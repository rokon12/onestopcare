package com.onestopcare.model.enums;

/**
 * @author Bazlur Rahman Rokon
 * @date 10/1/15.
 */
public enum Gender {

    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
