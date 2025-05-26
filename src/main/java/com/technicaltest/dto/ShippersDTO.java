package com.technicaltest.dto;


public class ShippersDTO {


    private Integer shippersID;


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
