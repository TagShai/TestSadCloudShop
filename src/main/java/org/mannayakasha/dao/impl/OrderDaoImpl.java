package org.mannayakasha.dao.impl;

import org.mannayakasha.dao.interfaces.IOrderDao;
import org.mannayakasha.entity.Order;
import org.mannayakasha.entity.OrderItem;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementation of {@link IOrderDao} interface.
 *
 * @author Pavel Milovidov
 * @version 1.0 26.02.2018.
 */

@Repository
@Transactional
public class OrderDaoImpl implements IOrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order getById(int id) {
        String hql = "SELECT order FROM Order as order WHERE order.id = :orderId";

        return (Order) entityManager.createQuery(hql).setParameter("orderId", id).getSingleResult();
    }

    @Override
    public void create(Order order) {
        entityManager.persist(order);
    }

    @Override
    public void update(Order order) {
        Order newOrder = getById(order.getId());
        //newOrder.setUser(order.getUser());
        newOrder.setStatus(order.getStatus());
        newOrder.setTotal(order.getTotal());
        entityManager.flush();
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Order> getAll() {
        String hql = "SELECT order FROM Order as order";
        return (List<Order>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Order getCart(String username) {
        String hql = "SELECT order FROM Order as order WHERE order.user.username = ? AND order.status.id = 1";
        return (Order) entityManager.createQuery(hql).setParameter(1, username).getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<OrderItem> getOrderItems(Integer orderId) {
        String hql = "SELECT orderItems FROM OrderItem as orderItems WHERE orderItems.order.id = :orderId";
        return (List<OrderItem>) entityManager.createQuery(hql).setParameter("orderId", orderId).getResultList();
    }

    /*@Override
    @SuppressWarnings("unchecked")
    public List<Order> getAllWithUser(String username) { // public List<Order> getAllWithUser(User user) {
        String hql = "SELECT order FROM Order as order WHERE order.user.username = ?";
        return (List<Order>) entityManager.createQuery(hql).setParameter(1, username).getResultList();
    }*/

    @Override
    public boolean orderExists(Integer id) {
        String hql = "SELECT order FROM Order as order WHERE order.id = ?";
        int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
        return count > 0;
    }
}
