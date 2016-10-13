package com.epam.koval.carrent.web.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import com.epam.koval.carrent.db.entity.Car;
import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.db.entity.UserOrder;

/**
 * User order view bean.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class UserOrderViewBean implements Serializable {
    /**  */
    private static final long serialVersionUID = 5670087653754509354L;

    /** ID order. */
    private Long id;

    /** Ordered car. */
    private Car car;

    /** User who made the order. */
    private User user;

    /** Order. */
    private UserOrder userOrder;

    /** Rent amount. */
    private BigDecimal rentSum;

    /** Rent car end. */
    private Date rentCarEnd;

    /** Car count. */
    private Integer count;

    /** User count. */
    private BigDecimal userProfit;

    /**
     * Constructor.
     */
    public UserOrderViewBean() {
    }

    /**
     * Constructor.
     * 
     * @param order order
     * @param car car
     * @param user user
     * @param rentSum rentsum
     * @param rentCarEnd rent car end
     */
    public UserOrderViewBean(UserOrder order, Car car, User user,
	    BigDecimal rentSum, Date rentCarEnd) {
	this.id = order.getId();
	this.car = car;
	this.user = user;
	this.userOrder = order;
	this.rentSum = rentSum;
	this.rentCarEnd = rentCarEnd;
    }

    /**
     * Constructor.
     * 
     * @param aUser user
     * @param count count
     */
    public UserOrderViewBean(User aUser, Integer count, BigDecimal profit) {
	this.user = aUser;
	this.count = count;
	this.userProfit = profit;
    }

    /**
     * Gets the value of {@linkplain UserOrderViewBean#userProfit}.
     * 
     * @return value of {@linkplain UserOrderViewBean#userProfit}
     */
    public final BigDecimal getUserProfit() {
	return userProfit;
    }

    /**
     * Sets {@linkplain UserOrderViewBean#userProfit} with new value.
     * 
     * @param userProfit new value for {@linkplain UserOrderViewBean#userProfit}
     */
    public final void setUserProfit(BigDecimal userProfit) {
	this.userProfit = userProfit;
    }

    /**
     * Gets the value of {@linkplain UserOrderViewBean#count}.
     * 
     * @return value of {@linkplain UserOrderViewBean#count}
     */
    public final Integer getCount() {
	return count;
    }

    /**
     * Sets {@linkplain UserOrderViewBean#count} with new value.
     * 
     * @param count new value for {@linkplain UserOrderViewBean#count}
     */
    public final void setCount(Integer count) {
	this.count = count;
    }

    /**
     * Gets the value of {@linkplain UserOrderViewBean#rentCarEnd}.
     * 
     * @return value of {@linkplain UserOrderViewBean#rentCarEnd}
     */
    public final Date getRentCarEnd() {
	return rentCarEnd;
    }

    /**
     * Sets {@linkplain UserOrderViewBean#rentCarEnd} with new value.
     * 
     * @param rentCarEnd new value for {@linkplain UserOrderViewBean#rentCarEnd}
     */
    public final void setRentCarEnd(Date rentCarEnd) {
	this.rentCarEnd = rentCarEnd;
    }

    /**
     * Gets the value of {@linkplain UserOrderViewBean#id}.
     * 
     * @return value of {@linkplain UserOrderViewBean#id}
     */
    public final Long getId() {
	return id;
    }

    /**
     * Sets {@linkplain UserOrderViewBean#id} with new value.
     * 
     * @param id new value for {@linkplain UserOrderViewBean#id}
     */
    public final void setId(Long id) {
	this.id = id;
    }

    /**
     * Gets the value of {@linkplain UserOrderViewBean#car}.
     * 
     * @return value of {@linkplain UserOrderViewBean#car}
     */
    public final Car getCar() {
	return car;
    }

    /**
     * Sets {@linkplain UserOrderViewBean#car} with new value.
     * 
     * @param car new value for {@linkplain UserOrderViewBean#car}
     */
    public final void setCar(Car car) {
	this.car = car;
    }

    /**
     * Gets the value of {@linkplain UserOrderViewBean#user}.
     * 
     * @return value of {@linkplain UserOrderViewBean#user}
     */
    public final User getUser() {
	return user;
    }

    /**
     * Sets {@linkplain UserOrderViewBean#user} with new value.
     * 
     * @param user new value for {@linkplain UserOrderViewBean#user}
     */
    public final void setUser(User user) {
	this.user = user;
    }

    /**
     * Gets the value of {@linkplain UserOrderViewBean#userOrder}.
     * 
     * @return value of {@linkplain UserOrderViewBean#userOrder}
     */
    public final UserOrder getUserOrder() {
	return userOrder;
    }

    /**
     * Sets {@linkplain UserOrderViewBean#userOrder} with new value.
     * 
     * @param userOrder new value for {@linkplain UserOrderViewBean#userOrder}
     */
    public final void setUserOrder(UserOrder userOrder) {
	this.userOrder = userOrder;
    }

    /**
     * Gets the value of {@linkplain UserOrderViewBean#rentSum}.
     * 
     * @return value of {@linkplain UserOrderViewBean#rentSum}
     */
    public final BigDecimal getRentSum() {
	return rentSum;
    }

    /**
     * Sets {@linkplain UserOrderViewBean#rentSum} with new value.
     * 
     * @param rentSum new value for {@linkplain UserOrderViewBean#rentSum}
     */
    public final void setRentSum(BigDecimal rentSum) {
	this.rentSum = rentSum;
    }
}
