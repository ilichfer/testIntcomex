package com.technicaltest.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    Integer orderID;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerID")
    private List<Customers> customerID;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeID")
    private List<Employees> employeeID;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shippersID")
    private List<Shippers> shipVia;



    @Column
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;

    private String freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }



    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public List<Customers> getCustomerID() {
        return customerID;
    }

    public void setCustomerID(List<Customers> customerID) {
        this.customerID = customerID;
    }

    public List<Employees> getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(List<Employees> employeeID) {
        this.employeeID = employeeID;
    }

    public List<Shippers> getShipVia() {
        return shipVia;
    }

    public void setShipVia(List<Shippers> shipVia) {
        this.shipVia = shipVia;
    }
}
