package com.epam.koval.carrent.db.entity;

import java.io.Serializable;
import java.sql.Date;

import com.epam.koval.carrent.web.bean.UserOrderBean;

/**
 * User order entity.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class UserOrder extends Entity implements Serializable {

    /** ID. */
    private static final long serialVersionUID = -7255875761593415085L;

    /** ID client. */
    private Long clientId;

    /** ID car. */
    private Long carId;

    /** Pasport data user. */
    private String passportData;

    /** Order with driver or not. */
    private boolean withDriver;

    /** Rent start date. */
    private Date rentStart;

    /** Rent end date. */
    private Date rentEnd;

    /** Confirm order. */
    private Status status;

    /**
     * Constructor.
     */
    public UserOrder() {

    }

    /**
     * Constructor.
     * 
     * @param order order
     */
    public UserOrder(UserOrderBean order) {
	this.clientId = Long.parseLong(order.getClientId());
	this.carId = Long.parseLong(order.getCarId());
	this.passportData = order.getPassportData();
	this.withDriver = Boolean.parseBoolean(order.getWithDriver());
	this.rentStart = Date.valueOf(order.getRentStart());
	this.rentEnd = Date.valueOf(order.getRentEnd());
    }

    /**
     * Gets the value of {@linkplain UserOrder#status}.
     * 
     * @return value of {@linkplain UserOrder#status}
     */
    public String getStatusName() {
	return status.name();
    }

    /**
     * Gets the value of {@linkplain UserOrder#status}.
     * 
     * @return value of {@linkplain UserOrder#status}
     */
    public final Status getStatus() {
	return status;
    }

    /**
     * Sets {@linkplain UserOrder#status} with new value.
     * 
     * @param aStatus new value for {@linkplain UserOrder#status}
     */
    public void setStatus(final String aStatus) {
	this.status = Status.valueOf(aStatus.toLowerCase());
    }

    /**
     * Sets {@linkplain UserOrder#status} with new value.
     * 
     * @param status new value for {@linkplain UserOrder#status}
     */
    public final void setStatus(Status status) {
	this.status = status;
    }

    /**
     * Gets the value of {@linkplain UserOrder#clientId}.
     * 
     * @return value of {@linkplain UserOrder#clientId}
     */
    public Long getClientId() {
	return clientId;
    }

    /**
     * Sets {@linkplain UserOrder#clientId} with new value.
     * 
     * @param aClientId new value for {@linkplain UserOrder#clientId}
     */
    public void setClientId(final Long aClientId) {
	this.clientId = aClientId;
    }

    /**
     * Gets the value of {@linkplain UserOrder#carId}.
     * 
     * @return value of {@linkplain UserOrder#carId}
     */
    public Long getCarId() {
	return carId;
    }

    /**
     * Sets {@linkplain UserOrder#carId} with new value.
     * 
     * @param clientCar new value for {@linkplain UserOrder#carId}
     */
    public void setCarId(final Long clientCar) {
	this.carId = clientCar;
    }

    /**
     * Gets the value of {@linkplain UserOrder#passportData}.
     * 
     * @return value of {@linkplain UserOrder#passportData}
     */
    public String getPassportData() {
	return passportData;
    }

    /**
     * Sets {@linkplain UserOrder#passportData} with new value.
     * 
     * @param aPassportData new value for {@linkplain UserOrder#passportData}
     */
    public void setPassportData(final String aPassportData) {
	this.passportData = aPassportData;
    }

    /**
     * Gets the value of {@linkplain UserOrder#withDriver}.
     * 
     * @return value of {@linkplain UserOrder#withDriver}
     */
    public boolean isWithDriver() {
	return withDriver;
    }

    /**
     * Sets {@linkplain UserOrder#withDriver} with new value.
     * 
     * @param aWithDriver new value for {@linkplain UserOrder#withDriver}
     */
    public void setWithDriver(final boolean aWithDriver) {
	this.withDriver = aWithDriver;
    }

    /**
     * Gets the value of {@linkplain UserOrder#rentStart}.
     * 
     * @return value of {@linkplain UserOrder#rentStart}
     */
    public Date getRentStart() {
	return rentStart;
    }

    /**
     * Sets {@linkplain UserOrder#rentStart} with new value.
     * 
     * @param aRentStart new value for {@linkplain UserOrder#rentStart}
     */
    public void setRentStart(final Date aRentStart) {
	this.rentStart = aRentStart;
    }

    /**
     * Gets the value of {@linkplain UserOrder#rentEnd}.
     * 
     * @return value of {@linkplain UserOrder#rentEnd}
     */
    public Date getRentEnd() {
	return rentEnd;
    }

    /**
     * Sets {@linkplain UserOrder#rentEnd} with new value.
     * 
     * @param aRentEnd new value for {@linkplain UserOrder#rentEnd}
     */
    public void setRentEnd(final Date aRentEnd) {
	this.rentEnd = aRentEnd;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("UserOrder [clientId=");
	builder.append(clientId);
	builder.append(", carId=");
	builder.append(carId);
	builder.append(", passportData=");
	builder.append(passportData);
	builder.append(", withDriver=");
	builder.append(withDriver);
	builder.append(", rentStart=");
	builder.append(rentStart);
	builder.append(", rentEnd=");
	builder.append(rentEnd);
	builder.append(", status=");
	builder.append(status);
	builder.append("]");
	return builder.toString();
    }
}
