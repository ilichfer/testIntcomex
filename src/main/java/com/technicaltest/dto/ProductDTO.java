package com.technicaltest.dto;

import com.technicaltest.model.Categories;
import com.technicaltest.model.Suppliers;

import java.util.List;

public class ProductDTO {

    private Integer productID;

    private String productName;

    private SuppliersDTO supplier;

    private CategoriesDTO category;

    Integer quantityPerUnit;
    Integer unitPrice;
    Integer unitInStock;
    Integer unitsOnOrder;
    Integer reorderLevel;
    Boolean discontinued;

    public ProductDTO() {
    }

    public void setSupplier(SuppliersDTO supplier) {
        this.supplier = supplier;
    }

    public void setCategory(CategoriesDTO category) {
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

    public SuppliersDTO getSupplier() {
        return supplier;
    }

    public CategoriesDTO getCategory() {
        return category;
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
