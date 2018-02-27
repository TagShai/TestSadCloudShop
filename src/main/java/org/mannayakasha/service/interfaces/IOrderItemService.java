package org.mannayakasha.service.interfaces;

import org.mannayakasha.service.IService;
import org.mannayakasha.entity.OrderItem;

import java.util.List;

/**
 * Service interface for the {@link OrderItem} class.
 *
 * @author Pavel Milovidov
 * @version 1.0 26.02.2018.
 */

public interface IOrderItemService extends IService<OrderItem> {
    
    //List<OrderItem> getOrderItems(Integer orderId); This method can be moved from {@link IOrderDao} to this place.
}
