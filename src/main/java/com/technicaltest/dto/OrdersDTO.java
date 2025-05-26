package com.technicaltest.dto;

import java.util.Date;
import java.util.List;


public class OrdersDTO {

    private Integer orderID;


    private List<CustomersDTO> customerID;

    private List<EmployeesDTO> employeeID;

    private List<ShippersDTO> shipVia;



    Date orderDate;
    Date requiredDate;
    Date shippedDate;

    String freight;
    String shipName;
    String shipAddress;
    String shipCity;
    String shipRegion;
    String shipPostalCode;
    String shipCountry;

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

    public List<CustomersDTO> getCustomerID() {
        return customerID;
    }

    public void setCustomerID(List<CustomersDTO> customerID) {
        this.customerID = customerID;
    }

    public List<EmployeesDTO> getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(List<EmployeesDTO> employeeID) {
        this.employeeID = employeeID;
    }

    public List<ShippersDTO> getShipVia() {
        return shipVia;
    }

    public void setShipVia(List<ShippersDTO> shipVia) {
        this.shipVia = shipVia;
    }
}
