package com.technicaltest.dto;

import com.technicaltest.model.Categories;
import com.technicaltest.model.Suppliers;

import java.util.List;

public class ProductDTO {
    private Integer productID;


    private String productName;


    private List<Suppliers> supplierID;

    private List<Categories> categoryID;

    Integer quantityPerUnit;
    Integer unitPrice;
    Integer unitInStock;
    Integer unitsOnOrder;
    Integer reorderLevel;
    Boolean discontinued;

    public ProductDTO(Integer productID, String productName, List<Suppliers> supplierID, List<Categories> categoryID, Integer quantityPerUnit, Integer unitPrice, Integer unitInStock, Integer unitsOnOrder, Integer reorderLevel, Boolean discontinued) {
        this.productID = productID;
        this.productName = productName;
        this.supplierID = supplierID;
        this.categoryID = categoryID;
        this.quantityPerUnit = quantityPerUnit;
        this.unitPrice = unitPrice;
        this.unitInStock = unitInStock;
        this.unitsOnOrder = unitsOnOrder;
        this.reorderLevel = reorderLevel;
        this.discontinued = discontinued;
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
