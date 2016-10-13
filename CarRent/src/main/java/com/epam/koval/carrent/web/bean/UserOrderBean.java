package com.epam.koval.carrent.web.bean;

import java.io.Serializable;

/**
 * User order bean.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public class UserOrderBean implements Serializable {
    /** ID. */
    private static final long serialVersionUID = 3873399757421309316L;

    /** Id Client. */
    private String clientId;

    /** Id car. */
    private String carId;

    /** Passport data. */
    private String passportData;

    /** With Driver. */
    private String withDriver;

    /** Rent start. */
    private String rentStart;

    /** Rent end. */
    private String rentEnd;

    /**
     * Constructor.
     * 
     * @param aClientId {@linkplain UserOrderBean#clientId}
     * @param aCarId {@linkplain UserOrderBean#carId}
     * @param aPassportData {@linkplain UserOrderBean#passportData}
     * @param aWithDriver {@linkplain UserOrderBean#withDriver}
     * @param aRentStart {@linkplain UserOrderBean#rentStart}
     * @param aRentEnd {@linkplain UserOrderBean#rentEnd}
     */
    public UserOrderBean(final String aClientId, final String aCarId,
	    final String aPassportData, final String aWithDriver,
	    final String aRentStart, final String aRentEnd) {
	this.clientId = aClientId;
	this.carId = aCarId;
	this.passportData = aPassportData;
	this.withDriver = aWithDriver;
	this.rentStart = aRentStart;
	this.rentEnd = aRentEnd;
    }

    /**
     * Gets the value of {@linkplain UserOrderBean#clientId}.
     * 
     * @return value of {@linkplain UserOrderBean#clientId}
     */
    public final String getClientId() {
	return clientId;
    }

    /**
     * Sets {@linkplain UserOrderBean#clientId} with new value.
     * 
     * @param aClientId new value for {@linkplain UserOrderBean#clientId}
     */
    public final void setClientId(final String aClientId) {
	this.clientId = aClientId;
    }

    /**
     * Gets the value of {@linkplain UserOrderBean#carId}.
     * 
     * @return value of {@linkplain UserOrderBean#carId}
     */
    public final String getCarId() {
	return carId;
    }

    /**
     * Sets {@linkplain UserOrderBean#carId} with new value.
     * 
     * @param aCarId new value for {@linkplain UserOrderBean#carId}
     */
    public final void setCarId(final String aCarId) {
	this.carId = aCarId;
    }

    /**
     * Gets the value of {@linkplain UserOrderBean#passportData}.
     * 
     * @return value of {@linkplain UserOrderBean#passportData}
     */
    public final String getPassportData() {
	return passportData;
    }

    /**
     * Sets {@linkplain UserOrderBean#passportData} with new value.
     * 
     * @param aPassportData new value for
     *            {@linkplain UserOrderBean#passportData}
     */
    public final void setPassportData(final String aPassportData) {
	this.passportData = aPassportData;
    }

    /**
     * Gets the value of {@linkplain UserOrderBean#withDriver}.
     * 
     * @return value of {@linkplain UserOrderBean#withDriver}
     */
    public final String getWithDriver() {
	return withDriver;
    }

    /**
     * Sets {@linkplain UserOrderBean#withDriver} with new value.
     * 
     * @param aWithDriver new value for {@linkplain UserOrderBean#withDriver}
     */
    public final void setWithDriver(final String aWithDriver) {
	this.withDriver = aWithDriver;
    }

    /**
     * Gets the value of {@linkplain UserOrderBean#rentStart}.
     * 
     * @return value of {@linkplain UserOrderBean#rentStart}
     */
    public final String getRentStart() {
	return rentStart;
    }

    /**
     * Sets {@linkplain UserOrderBean#rentStart} with new value.
     * 
     * @param aRentStart new value for {@linkplain UserOrderBean#rentStart}
     */
    public final void setRentStart(final String aRentStart) {
	this.rentStart = aRentStart;
    }

    /**
     * Gets the value of {@linkplain UserOrderBean#rentEnd}.
     * 
     * @return value of {@linkplain UserOrderBean#rentEnd}
     */
    public final String getRentEnd() {
	return rentEnd;
    }

    /**
     * Sets {@linkplain UserOrderBean#rentEnd} with new value.
     * 
     * @param aRentEnd new value for {@linkplain UserOrderBean#rentEnd}
     */
    public final void setRentEnd(final String aRentEnd) {
	this.rentEnd = aRentEnd;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("UserOrderBean [clientId=");
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
	builder.append("]");
	return builder.toString();
    }

}
