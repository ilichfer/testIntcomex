package com.technicaltest.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "productID")
    private Integer productID;

    @Column
    private String productName;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierID")
    private List<Suppliers> supplierID;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryID")
    private List<Categories> categoryID;

    private Integer quantityPerUnit;
    private Integer unitPrice;
    private Integer unitInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private Boolean discontinued;

    public List<Suppliers> getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(List<Suppliers> supplierID) {
        this.supplierID = supplierID;
    }

    public List<Categories> getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(List<Categories> categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(Integer quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(Integer unitInStock) {
        this.unitInStock = unitInStock;
    }

    public Integer getUnitsOnOrder() {
        return unitsOnOrder;
    }

    public void setUnitsOnOrder(Integer unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public Boolean getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
    }

}
