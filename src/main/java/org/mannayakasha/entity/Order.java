package org.mannayakasha.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

/**
 * Simple JavaBean object, that represents entity order.
 *
 * @author Pavel Milovidov
 * @version 1.0 26.02.2018.
 */

@javax.persistence.Entity
@Table(name = "orders")
public class Order extends Entity {

    @ManyToOne(cascade = CascadeType.ALL)//(fetch = FetchType.EAGER)//@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private User user;

    @ManyToOne//(fetch = FetchType.EAGER)//@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private OrderStatus status;

    @Column(name = "total")
    private Double total;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<OrderItem> orderItems;

    public Order() {}

    public Order(Integer id, User user, OrderStatus status, Double total, Set<OrderItem> orderItems) {
        super(id);
        this.user = user;
        this.status = status;
        this.total = total;
        this.orderItems = orderItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "user=" + user +
                ", status=" + status +
                ", total=" + total +
                ", orderItems=" + orderItems +
                '}';
    }
}