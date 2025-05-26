package com.technicaltest.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Shippers")
public class Shippers {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer shippersID;


    @Column
    private String companyName;
    private String phone;

    public Integer getShippersID() {
        return shippersID;
    }

    public void setShippersID(Integer shippersID) {
        this.shippersID = shippersID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
