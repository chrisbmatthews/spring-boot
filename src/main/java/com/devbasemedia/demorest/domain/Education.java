package com.devbasemedia.demorest.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Education {
    private String institution;
    private Date dateEnrolled;
    private Date dateCompleted;
    private Address address = new Address();

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Date getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(Date dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

    public Date getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Education() {

    }
}
