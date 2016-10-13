package com.epam.koval.carrent.db.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.epam.koval.carrent.web.bean.CarBean;

/**
 * Car entity.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class Car extends Entity implements Serializable {
    /** ID car. */
    private static final long serialVersionUID = 8745088460246467076L;

    /** Car mark. */
    private String mark;

    /** Car model. */
    private String model;

    /** Car class. */
    private CarClass carClass;

    /** Rent cost. */
    private BigDecimal cost;

    /** true - car rented, false - car isn`t rented. */
    private boolean rented;

    /**
     * Constructor.
     */
    public Car() {

    }

    /**
     * Constructor.
     * 
     * @param car car
     */
    public Car(CarBean car) {
	this.mark = car.getMark();
	this.model = car.getModel();
	this.cost = new BigDecimal(car.getCost());
	this.carClass = CarClass.valueOf(car.getCarClass().toLowerCase());
	this.rented = Boolean.parseBoolean(car.getRented());
    }

    /**
     * Constructor.
     * 
     * @param mark mark
     * @param model model
     * @param cost cost
     * @param rented rented
     * @param aCarBean car bean
     */
    public Car(String mark, String model, BigDecimal cost, boolean rented,
	    CarBean aCarBean) {
	this.mark = mark;
	this.model = model;
	setCarClass(aCarBean.getCarClass());
	this.cost = cost;
	this.rented = rented;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Car [mark=");
	builder.append(mark);
	builder.append(", model=");
	builder.append(model);
	builder.append(", carClass=");
	builder.append(carClass);
	builder.append(", cost=");
	builder.append(cost);
	builder.append(", rented=");
	builder.append(rented);
	builder.append("]");
	return builder.toString();
    }

    /**
     * Gets the value of {@linkplain Car#rented}.
     * 
     * @return value of {@linkplain Car#rented}
     */
    public final boolean isRented() {
	return rented;
    }

    /**
     * Sets {@linkplain Car#rented} with new value.
     * 
     * @param rented new value for {@linkplain Car#rented}
     */
    public final void setRented(boolean rented) {
	this.rented = rented;
    }

    /**
     * Gets the value of {@linkplain Car#mark}.
     * 
     * @return value of {@linkplain Car#mark}
     */
    public String getMark() {
	return mark;
    }

    /**
     * Sets {@linkplain Car#mark} with new value.
     * 
     * @param aMark new value for {@linkplain Car#mark}
     */
    public void setMark(final String aMark) {
	this.mark = aMark;
    }

    /**
     * Gets the value of {@linkplain Car#model}.
     * 
     * @return value of {@linkplain Car#model}
     */
    public String getModel() {
	return model;
    }

    /**
     * Sets {@linkplain Car#model} with new value.
     * 
     * @param aModel new value for {@linkplain Car#model}
     */
    public void setModel(final String aModel) {
	this.model = aModel;
    }

    /**
     * Gets the value of {@linkplain Car#carClass}.
     * 
     * @return value of {@linkplain Car#carClass}
     */
    public CarClass getCarClass() {
	return carClass;
    }

    /**
     * Gets the value of {@linkplain Car#carClass}.
     * 
     * @return value of {@linkplain Car#carClass}
     */
    public String getCarClassName() {
	return carClass.name();
    }

    /**
     * Sets {@linkplain Car#carClass} with new value.
     * 
     * @param aCarClass new value for {@linkplain Car#carClass}
     */
    public void setCarClass(final String aCarClass) {
	this.carClass = CarClass.valueOf(aCarClass.toLowerCase());
    }

    /**
     * Sets {@linkplain Car#carClass} with new value.
     * 
     * @param aCarClass new value for {@linkplain Car#carClass}
     */
    public void setCarClass(final CarClass aCarClass) {
	this.carClass = aCarClass;
    }

    /**
     * Gets the value of {@linkplain Car#cost}.
     * 
     * @return value of {@linkplain Car#cost}
     */
    public BigDecimal getCost() {
	return cost;
    }

    /**
     * Sets {@linkplain Car#cost} with new value.
     * 
     * @param aCost new value for {@linkplain Car#cost}
     */
    public void setCost(final BigDecimal aCost) {
	this.cost = aCost;
    }

}
