package com.andersonchagas.gerenciadepessoas.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String street;

    @NotBlank
    @Column(length = 50)
    private String postalCode;

    @NotBlank
    @Column(length = 50)
    private String number;

    @NotBlank
    @Column(length = 50)
    private String city;

    @Column(nullable = false)
    private Boolean isMain;

    @ManyToOne
    @JoinColumn(name = "people_id")
    @JsonIgnore
    private People people;

    public Address() {

    }

    public Address(Long id, String street, String postalCode, String number, String city, Boolean isMain) {
        super();
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.number = number;
        this.city = city;
        this.isMain = isMain;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Boolean getIsMain() {
        return isMain;
    }

    public void setIsMain(Boolean isMain) {
        this.isMain = isMain;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        return Objects.equals(id, other.id);
    }
}