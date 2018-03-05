package org.mannayakasha.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Simple JavaBean object, that represents entity shipment information.
 *
 * @author Pavel Milovidov
 * @version 1.0 01.03.2018.
 */

@javax.persistence.Entity
@Table(name = "shipments_information")
public class ShipmentInformation extends Entity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")//, foreignKey = @ForeignKey(name = "SHIPMENT_INFORMATION_ORDER_FK"))
    private Order order;

    @Column(name = "country")
    private String country;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @Column(name = "zip")
    private String zip;

    @Column(name = "shipment_tracking_number")
    private String shipmentTrackingNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "shipment_placed_date")
    private Date shipmentPlacedDate;

    ShipmentInformation() {}

    public ShipmentInformation(Integer id, Order order, String country, String phoneNumber, String addressLine1, String addressLine2, String zip, String shipmentTrackingNumber, Date shipmentPlacedDate) {
        super(id);
        this.order = order;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.zip = zip;
        this.shipmentTrackingNumber = shipmentTrackingNumber;
        this.shipmentPlacedDate = shipmentPlacedDate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getShipmentTrackingNumber() {
        return shipmentTrackingNumber;
    }

    public void setShipmentTrackingNumber(String shipmentTrackingNumber) {
        this.shipmentTrackingNumber = shipmentTrackingNumber;
    }

    public Date getShipmentPlacedDate() {
        return shipmentPlacedDate;
    }

    public void setShipmentPlacedDate(Date shipmentPlacedDate) {
        this.shipmentPlacedDate = shipmentPlacedDate;
    }

    @Override
    public String toString() {
        return "ShipmentInformation{" +
                "order=" + order +
                ", country='" + country + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", zip='" + zip + '\'' +
                ", shipmentTrackingNumber='" + shipmentTrackingNumber + '\'' +
                ", shipmentPlacedDate=" + shipmentPlacedDate +
                '}';
    }
}
