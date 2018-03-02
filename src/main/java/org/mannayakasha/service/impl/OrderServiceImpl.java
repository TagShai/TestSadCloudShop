package org.mannayakasha.service.impl;

import org.mannayakasha.dao.interfaces.IOrderDao;
import org.mannayakasha.entity.Order;
import org.mannayakasha.entity.OrderItem;
import org.mannayakasha.service.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link IOrderService} interface.
 *
 * @author Pavel Milovidov
 * @version 1.0 26.02.2018.
 */

@Service("orderService")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;

    @Override
    public Order getById(int id) {
        return orderDao.getById(id);
    }

    @Override
    public boolean create(Order order) {
        if (orderDao.orderExists(order.getId())) {
            return false;
        } else {
            orderDao.create(order);
            return true;
        }
    }

    @Override
    public void update(Order order) {
        orderDao.update(order);
    }

    @Override
    public void delete(int id) {
        orderDao.delete(id);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public List<OrderItem> getOrderItems(Integer orderId) {
        return orderDao.getOrderItems(orderId);
    }

    /*@Override
    public List<Order> getAllWithUser(String username) { return orderDao.getAllWithUser(username); }*/
}
