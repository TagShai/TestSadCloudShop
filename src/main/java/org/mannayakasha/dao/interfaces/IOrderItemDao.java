package org.mannayakasha.dao.interfaces;

import org.mannayakasha.dao.IDao;
import org.mannayakasha.entity.OrderItem;

import java.util.List;

/**
 * Dao interface for the {@link OrderItem} class.
 *
 * @author Pavel Milovidov
 * Created on 26.02.2018.
 */

public interface IOrderItemDao extends IDao<OrderItem> {

    //List<OrderItem> getOrderItems(Integer orderId); This method can be moved from {@link IOrderDao} to this place.

    boolean orderItemExists(Integer id);
}
