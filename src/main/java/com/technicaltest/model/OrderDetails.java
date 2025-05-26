package com.technicaltest.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Order_Details")
public class OrderDetails {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_detail_Id")
    private Integer orderDetailID; // PK


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderID")
    private List<Orders> orderID;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private List<Products> productID;


    @Column
    private Long unitPrice;
    private Integer quantity;
    private String discount;


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
}
