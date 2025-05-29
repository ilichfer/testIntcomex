package com.technicaltest.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Products")
public class Products {

    public Products() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "productID")
    private Integer productID;

    @Column
    private String productName;


    @ManyToOne
    @JoinColumn(name = "supplierID") // la foránea está aquí
    private Suppliers supplier;

    @ManyToOne
    @JoinColumn( name = "categoryID")
    private Categories category;



    private Integer quantityPerUnit;
    private Integer unitPrice;
    private Integer unitInStock;
    private Integer unitsOnOrder;
    private Integer reorderLevel;
    private Boolean discontinued;

    public Suppliers getSupplier() {
        return supplier;
    }

    public void setSupplier(Suppliers supplier) {
        this.supplier = supplier;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
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

    public Products(Integer productID, String productName, Suppliers supplier, Categories category, Integer quantityPerUnit, Integer unitPrice, Integer unitInStock, Integer unitsOnOrder, Integer reorderLevel, Boolean discontinued) {
        this.productID = productID;
        this.productName = productName;
        this.supplier = supplier;
        this.category = category;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitInStock = unitInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;
    }
}
