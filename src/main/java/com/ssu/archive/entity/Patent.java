package com.ssu.archive.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@DiscriminatorValue("Patent")
public class Patent extends AbstractPrintedProducts {

    public String country;
    public int registrationNumber;


    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setCountry(String country) {
        country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setRegistrationNumber(int registrationNumber) {
        registrationNumber = registrationNumber;
    }
}
