package org.mannayakasha.service.impl;

import org.mannayakasha.dao.interfaces.IShipmentInformationDao;
import org.mannayakasha.entity.ShipmentInformation;
import org.mannayakasha.service.interfaces.IShipmentInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link IShipmentInformationService} interface.
 *
 * @author Pavel Milovidov
 * @version 1.0 01.03.2018.
 */

@Service("shipmentInformationService")
public class ShipmentInformationServiceImpl implements IShipmentInformationService {

    @Autowired
    private IShipmentInformationDao shipmentInformationDao;

    @Override
    public ShipmentInformation getById(int id) {
        return shipmentInformationDao.getById(id);
    }

    @Override
    public boolean create(ShipmentInformation shipmentInformation) {
        if (shipmentInformationDao.shipmentInformationExists(shipmentInformation.getId())) {
            return false;
        } else {
            shipmentInformationDao.create(shipmentInformation);
            return true;
        }
    }

    @Override
    public void update(ShipmentInformation shipmentInformation) {
        shipmentInformationDao.update(shipmentInformation);
    }

    @Override
    public void delete(int id) {
        shipmentInformationDao.delete(id);
    }
}