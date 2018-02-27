package org.mannayakasha.entity;

import javax.persistence.*;

/**
 * Simple JavaBean object, that represents entity order statuses.
 *
 * @author Pavel Milovidov
 * @version 1.0 26.02.2018.
 */


@javax.persistence.Entity
@Table(name = "order_statuses")
public class OrderStatus extends Entity {

    @Column(name = "name")
    private String name;

    public OrderStatus() {}

    public OrderStatus(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}