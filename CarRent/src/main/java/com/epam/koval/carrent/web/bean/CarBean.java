package com.epam.koval.carrent.web.bean;

/**
 * Car bean.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public class CarBean {
    /** Car mark. */
    private String mark;

    /** Car model. */
    private String model;

    /** Car class. */
    private String carClass;

    /** Car cost. */
    private String cost;

    /** Rented. */
    private String rented;

    /**
     * Gets the value of {@linkplain CarBean#rented}.
     * 
     * @return value of {@linkplain CarBean#rented}
     */
    public final String getRented() {
	return rented;
    }

    /**
     * Sets {@linkplain CarBean#rented} with new value.
     * 
     * @param aRented new value for {@linkplain CarBean#rented}
     */
    public final void setRented(final String aRented) {
	this.rented = aRented;
    }

    /**
     * Constructor.
     * 
     * @param aMark mark
     * @param aModel model
     * @param aCarClass car class
     * @param aCost cost
     * @param aRented rented
     */
    public CarBean(final String aMark, final String aModel,
	    final String aCarClass, final String aCost, final String aRented) {
	this.mark = aMark;
	this.model = aModel;
	this.carClass = aCarClass;
	this.cost = aCost;
	this.rented = aRented;
    }

    /**
     * Gets the value of {@linkplain CarBean#carClass}.
     * 
     * @return value of {@linkplain CarBean#carClass}
     */
    public final String getCarClass() {
	return carClass;
    }

    /**
     * Sets {@linkplain CarBean#carClass} with new value.
     * 
     * @param aCarClass new value for {@linkplain CarBean#carClass}
     */
    public final void setCarClass(final String aCarClass) {
	this.carClass = aCarClass;
    }

    /**
     * Gets the value of {@linkplain CarBean#mark}.
     * 
     * @return value of {@linkplain CarBean#mark}
     */
    public final String getMark() {
	return mark;
    }

    /**
     * Sets {@linkplain CarBean#mark} with new value.
     * 
     * @param aMark new value for {@linkplain CarBean#mark}
     */
    public final void setMark(final String aMark) {
	this.mark = aMark;
    }

    /**
     * Gets the value of {@linkplain CarBean#model}.
     * 
     * @return value of {@linkplain CarBean#model}
     */
    public final String getModel() {
	return model;
    }

    /**
     * Sets {@linkplain CarBean#model} with new value.
     * 
     * @param aModel new value for {@linkplain CarBean#model}
     */
    public final void setModel(final String aModel) {
	this.model = aModel;
    }

    /**
     * Gets the value of {@linkplain CarBean#cost}.
     * 
     * @return value of {@linkplain CarBean#cost}
     */
    public final String getCost() {
	return cost;
    }

    /**
     * Sets {@linkplain CarBean#cost} with new value.
     * 
     * @param aCost new value for {@linkplain CarBean#cost}
     */
    public final void setCost(final String aCost) {
	this.cost = aCost;
    }

    @Override
    public final String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("CarBean [mark=");
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
}
