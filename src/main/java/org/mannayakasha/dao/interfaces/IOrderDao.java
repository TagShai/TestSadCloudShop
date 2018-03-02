package org.mannayakasha.dao.interfaces;

import org.mannayakasha.dao.IDao;
import org.mannayakasha.entity.Order;
import org.mannayakasha.entity.OrderItem;

import java.util.List;

/**
 * Dao interface for the {@link Order} class.
 *
 * @author Pavel Milovidov
 * Created on 26.02.2018.
 */

public interface IOrderDao extends IDao<Order> {

    List<Order> getAll();

    Order getCart(String username);

    //List<Order> getAllWithUser(String username); // User user

    List<OrderItem> getOrderItems(Integer orderId);

    boolean orderExists(Integer id);
}
