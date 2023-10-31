package com.yaashall.entity;


import com.yaashall.utils.OrderStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entity class for the order table
 *
 * @Author Yassine CHALH
 */

@Entity(name = "Order")
@Table(name = "order")
public class Order {

    @EmbeddedId
    private OrderId orderId;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "customer_id",
            foreignKey = @ForeignKey(
                    name = "customer_id_fk"
            )
    )
    private Customer customer;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "product_id",
            foreignKey = @ForeignKey(
                    name = "product_id_fk"
            )
    )
    private Product product;

    @Column(
            name = "order_date",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;
    @Column(
            name = "order_status",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private OrderStatus orderStatus;

    @Column(
            name = "total_amount",
            nullable = false,
            columnDefinition = "NUMERIC(10,2)"
    )
    private Double totalAmount;


    public Order(LocalDateTime createdAt,
                 OrderStatus orderStatus,
                 Double totalAmount,
                 Customer customer,
                 Product product) {
        this.createdAt = createdAt;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.customer = customer;
        this.product = product;
    }

    public Order(OrderId orderId,
                 LocalDateTime createdAt,
                 OrderStatus orderStatus,
                 Double totalAmount,
                 Customer customer,
                 Product product) {
        this.orderId = orderId;
        this.createdAt = createdAt;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.customer = customer;
        this.product = product;
    }

    public Order() {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public OrderId getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderId orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && Objects.equals(createdAt, order.createdAt) && orderStatus == order.orderStatus && Objects.equals(totalAmount, order.totalAmount) && Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, createdAt, orderStatus, totalAmount, customer);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + createdAt +
                ", orderStatus=" + orderStatus +
                ", totalAmount=" + totalAmount +
                ", customer=" + customer +
                '}';
    }
}