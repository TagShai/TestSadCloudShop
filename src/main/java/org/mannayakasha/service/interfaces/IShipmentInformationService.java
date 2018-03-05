package org.mannayakasha.service.interfaces;

import org.mannayakasha.entity.ShipmentInformation;
import org.mannayakasha.service.IService;

import java.util.List;

/**
 * Service interface for the {@link ShipmentInformation} class.
 *
 * @author Pavel Milovidov
 * @version 1.0 01.03.2018.
 */

public interface IShipmentInformationService extends IService<ShipmentInformation> {
    
    //ShipmentInformation getByOrder(Order order); // String order
}
