package org.mannayakasha.service.impl;

import org.mannayakasha.dao.interfaces.IOrderItemDao;
import org.mannayakasha.entity.OrderItem;
import org.mannayakasha.service.interfaces.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of {@link IOrderItemService} interface.
 *
 * @author Pavel Milovidov
 * @version 1.0 26.02.2018.
 */

@Service("orderItemService")
public class OrderItemServiceImpl implements IOrderItemService {

    @Autowired
    private IOrderItemDao orderItemDao;

    @Override
    public OrderItem getById(int id) {
        return orderItemDao.getById(id);
    }

    @Override
    public boolean create(OrderItem orderItem) {
        if (orderItemDao.orderItemExists(orderItem.getId())) {
            return false;
        } else {
            orderItemDao.create(orderItem);
            return true;
        }
    }

    @Override
    public void update(OrderItem orderItem) {
        orderItemDao.update(orderItem);
    }

    @Override
    public void delete(int id) {
        orderItemDao.delete(id);
    }
}
