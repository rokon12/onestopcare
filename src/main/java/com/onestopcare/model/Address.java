package com.onestopcare.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * @author Bazlur Rahman Rokon
 * @date 10/1/15.
 */
@Entity
public class Address extends PersistenceObject<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(max = 200)
    private String addressLine1;

    @Size(max = 200)
    private String addressLine2;

    @Size(max = 100)
    private String district;

    @Size(max = 100)
    private String thana;

    @Size(max = 100)
    private String area;

    @Size(max = 100)
    private String postOffice;

    @Size(max = 10)
    private String postCode;

    @Override
    public Long getId() {
        return id;
    }

    public Address setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public Address setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
        return this;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public Address setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public Address setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getThana() {
        return thana;
    }

    public Address setThana(String thana) {
        this.thana = thana;
        return this;
    }

    public String getArea() {
        return area;
    }

    public Address setArea(String area) {
        this.area = area;
        return this;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public Address setPostOffice(String postOffice) {
        this.postOffice = postOffice;
        return this;
    }

    public String getPostCode() {
        return postCode;
    }

    public Address setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }
}
