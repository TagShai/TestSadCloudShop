package org.mannayakasha.dao.interfaces;

import org.mannayakasha.dao.IDao;
import org.mannayakasha.entity.ShipmentInformation;

import java.util.List;

/**
 * Dao interface for the {@link ShipmentInformation} class.
 *
 * @author Pavel Milovidov
 * Created on 01.03.2018.
 */

public interface IShipmentInformationDao extends IDao<ShipmentInformation> {

    //ShipmentInformation getByOrder(Order order); // String order

    boolean shipmentInformationExists(Integer id);
}
