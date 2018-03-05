package org.mannayakasha.dao.impl;

import org.mannayakasha.dao.interfaces.IShipmentInformationDao;
import org.mannayakasha.entity.ShipmentInformation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Implementation of {@link IShipmentInformationDao} interface.
 *
 * @author Pavel Milovidov
 * @version 1.0 01.03.2018.
 */

@Repository
@Transactional
public class ShipmentInformationDaoImpl implements IShipmentInformationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ShipmentInformation getById(int id) {
        String hql = "SELECT shipmentInformation FROM ShipmentInformation as shipmentInformation WHERE shipmentInformation.id = :shipmentInformationId";

        return (ShipmentInformation) entityManager.createQuery(hql).setParameter("shipmentInformationId", id).getSingleResult();
    }

    @Override
    public void create(ShipmentInformation shipmentInformation) {
        entityManager.persist(shipmentInformation);
    }

    @Override
    public void update(ShipmentInformation shipmentInformation) {
        entityManager.merge(shipmentInformation);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(getById(id));
    }

    @Override
    public boolean shipmentInformationExists(Integer id) {
        String hql = "SELECT shipmentInformation FROM ShipmentInformation as shipmentInformation WHERE shipmentInformation.id = ?";
        int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
        return count > 0;
    }
}
