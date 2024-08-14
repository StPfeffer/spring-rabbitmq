package com.pfeffer.modulith.order.dto;

import java.io.Serializable;

public class OrderDTO implements Serializable {

    private String orderId;
    private Double totalPrice;
    private String customerName;

    public OrderDTO(String orderId, Double totalPrice, String customerName) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.customerName = customerName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", totalPrice=" + totalPrice +
                ", customerName='" + customerName + '\'' +
                '}';
    }

}
