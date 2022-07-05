package com.example.adminsystem;

import javafx.beans.property.SimpleStringProperty;

public class OrdersTable
{
    private SimpleStringProperty orderId;
    private SimpleStringProperty subtotal;
    private SimpleStringProperty total;
    private SimpleStringProperty discount;
    private SimpleStringProperty orderDate;
    public OrdersTable(String orderId,String subtotal,String total,String discount,String orderDate)
    {
        this.orderId = new SimpleStringProperty(orderId);
        this.subtotal = new SimpleStringProperty(subtotal);
        this.total= new SimpleStringProperty(total);
        this.discount= new SimpleStringProperty(discount);
        this.orderDate = new SimpleStringProperty(orderDate);
    }
    public String getOrderId() {
        return orderId.get();
    }

    public SimpleStringProperty orderIdProperty() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId.set(orderId);
    }

    public String getSubtotal() {
        return subtotal.get();
    }

    public SimpleStringProperty subtotalProperty() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal.set(subtotal);
    }

    public String getTotal() {
        return total.get();
    }

    public SimpleStringProperty totalProperty() {
        return total;
    }

    public void setTotal(String total) {
        this.total.set(total);
    }

    public String getDiscount() {
        return discount.get();
    }

    public SimpleStringProperty discountProperty() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount.set(discount);
    }

    public String getOrderDate() {
        return orderDate.get();
    }

    public SimpleStringProperty orderDateProperty() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate.set(orderDate);
    }
}
