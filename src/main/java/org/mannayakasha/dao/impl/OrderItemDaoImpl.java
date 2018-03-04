package org.mannayakasha.dao.impl;

import org.mannayakasha.dao.interfaces.IOrderItemDao;
import org.mannayakasha.entity.OrderItem;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementation of {@link IOrderItemDao} interface.
 *
 * @author Pavel Milovidov
 * @version 1.0 26.02.2018.
 */

@Repository
@Transactional
public class OrderItemDaoImpl implements IOrderItemDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public OrderItem getById(int id) {
        String hql = "SELECT orderItem FROM OrderItem as orderItem WHERE orderItem.id = :orderItemId";

        return (OrderItem) entityManager.createQuery(hql).setParameter("orderItemId", id).getSingleResult();
    }

    @Override
    public void create(OrderItem orderItem) {
        entityManager.persist(orderItem);
    }

    @Override
    public void update(OrderItem orderItem) {
        entityManager.merge(orderItem);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }

    @Override
    public boolean orderItemExists(Integer id) {
        String hql = "SELECT order FROM Order as order WHERE order.id = ?";
        int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
        return count > 0;
    }
}
