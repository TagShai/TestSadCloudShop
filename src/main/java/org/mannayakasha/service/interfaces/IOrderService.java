package org.mannayakasha.service.interfaces;

import org.mannayakasha.service.IService;
import org.mannayakasha.entity.Order;
import org.mannayakasha.entity.OrderItem;

import java.util.List;

/**
 * Service interface for the {@link Order} class.
 *
 * @author Pavel Milovidov
 * @version 1.0 26.02.2018.
 */

public interface IOrderService extends IService<Order> {

    List<Order> getAll();

    //List<Order> getAllWithUser(User user); // String username

    List<OrderItem> getOrderItems(Integer orderId);
}
