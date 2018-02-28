package org.mannayakasha.entity;

import javax.persistence.*;

/**
 * Simple JavaBean object, that represents entity order.
 *
 * @author Pavel Milovidov
 * @version 1.0 26.02.2018.
 */

@javax.persistence.Entity
@Table(name = "orders")
public class Order extends Entity {

    @ManyToOne(fetch = FetchType.EAGER)//@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")//, foreignKey = @ForeignKey(name = "ORDER_USER_FK"))
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)//@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")//, foreignKey = @ForeignKey(name = "ORDER_USER_FK"))
    private OrderStatus status;

    @Column(name = "total")
    private Double total;

    public Order() {}

    public Order(Integer id, User user, OrderStatus status, Double total) {
        super(id);
        this.user = user;
        this.status = status;
        this.total = total;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}