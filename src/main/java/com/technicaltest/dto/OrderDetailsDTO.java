package com.technicaltest.dto;

import com.technicaltest.model.Orders;
import com.technicaltest.model.Products;

import java.util.List;


public class OrderDetailsDTO {

    private Integer orderDetailID; // PK
    private List<Orders> orderID;
    private List<Products> productID;
    private Long unitPrice;
    private Integer quantity;
    private String discount;

    public Integer getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(Integer orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public List<Orders> getOrderID() {
        return orderID;
    }

    public void setOrderID(List<Orders> orderID) {
        this.orderID = orderID;
    }

    public List<Products> getProductID() {
        return productID;
    }

    public void setProductID(List<Products> productID) {
        this.productID = productID;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
