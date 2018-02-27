package org.mannayakasha.entity;

import javax.persistence.*;

/**
 * Simple JavaBean object, that represents entity order items.
 *
 * @author Pavel Milovidov
 * @version 1.0 26.02.2018.
 */

@javax.persistence.Entity
@Table(name = "order_items")
public class OrderItem extends Entity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false, foreignKey = @ForeignKey(name = "ORDER_ITEM_PRODUCT_FK"))
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false, foreignKey = @ForeignKey(name = "ORDER_ITEM_ORDER_FK"))
    private Order order;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    public OrderItem() {}

    public OrderItem(Integer id, Product product, Order order, Integer quantity, Double price) {
        super(id);
        this.product = product;
        this.order = order;
        this.quantity = quantity;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}