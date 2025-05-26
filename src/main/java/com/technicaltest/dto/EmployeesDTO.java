package com.technicaltest.dto;

import java.util.Date;


public class EmployeesDTO {


    Integer employeeID;


    String laststName;
    String firstName;
    String tille;
    String titeOfCourtesy;
    Date birtDate;
    Date hireDate;
    String address;
    String city;
    String region;
    String postalCode;
    String country;
    String homePhone;
    String extension;
    String photo;
    String notes;
    String reportsTo;

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getLaststName() {
        return laststName;
    }

    public void setLaststName(String laststName) {
        this.laststName = laststName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTille() {
        return tille;
    }

    public void setTille(String tille) {
        this.tille = tille;
    }

    public String getTiteOfCourtesy() {
        return titeOfCourtesy;
    }

    public void setTiteOfCourtesy(String titeOfCourtesy) {
        this.titeOfCourtesy = titeOfCourtesy;
    }

    public Date getBirtDate() {
        return birtDate;
    }

    public void setBirtDate(Date birtDate) {
        this.birtDate = birtDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }
}
