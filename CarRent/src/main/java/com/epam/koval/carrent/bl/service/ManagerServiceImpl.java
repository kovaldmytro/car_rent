package com.epam.koval.carrent.bl.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.epam.koval.carrent.bl.util.SumRent;
import com.epam.koval.carrent.db.dao.CarDao;
import com.epam.koval.carrent.db.dao.DaoFactory;
import com.epam.koval.carrent.db.dao.FactoryType;
import com.epam.koval.carrent.db.dao.UserDao;
import com.epam.koval.carrent.db.dao.UserOrderDao;
import com.epam.koval.carrent.db.entity.Car;
import com.epam.koval.carrent.db.entity.Status;
import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.db.entity.UserOrder;
import com.epam.koval.carrent.web.bean.UserOrderViewBean;

/**
 * Manager service implementation.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class ManagerServiceImpl implements ManagerService {

    /** UserOrder DAO. */
    private UserOrderDao userOrderDao = null;

    /** Car DAO. */
    private CarDao carDao = null;

    /** User DAO. */
    private UserDao userDao = null;

    /**
     * Constructor.
     */
    public ManagerServiceImpl() {
	userOrderDao = DaoFactory.getDaoFactory(FactoryType.MYSQL)
		.getUserOrderDao();
	carDao = DaoFactory.getDaoFactory(FactoryType.MYSQL).getCarDao();
	userDao = DaoFactory.getDaoFactory(FactoryType.MYSQL).getUserDao();

    }

    @Override
    public List<UserOrderViewBean> getAllUserOrder() {
	List<UserOrder> orders = userOrderDao.getAllUserOrder();
	List<UserOrderViewBean> listViewBean = new ArrayList<UserOrderViewBean>();
	User user = null;
	Car car = null;
	BigDecimal sumRent = null;

	for (UserOrder order : orders) {
	    car = carDao.getCarById(order.getCarId());
	    user = userDao.getUserById(order.getClientId());
	    sumRent = SumRent.sum(order.getRentStart(), order.getRentEnd(),
		    car.getCost());

	    listViewBean.add(
		    new UserOrderViewBean(order, car, user, sumRent, null));
	}

	for (UserOrderViewBean orderOpenRented : listViewBean) {
	    if (orderOpenRented.getUserOrder().getStatus() == Status.open
		    & orderOpenRented.getCar().isRented()) {
		for (UserOrderViewBean orderPaidRented : listViewBean) {
		    if (orderPaidRented.getCar().getId() == orderOpenRented
			    .getCar().getId()
			    & orderPaidRented.getUserOrder()
				    .getStatus() == Status.paid
			    & orderPaidRented.getCar().isRented()) {
			orderOpenRented.setRentCarEnd(
				orderPaidRented.getUserOrder().getRentEnd());
		    }
		}
	    }
	}
	return listViewBean;
    }

    @Override
    public UserOrder getUserOrderById(final Long aId) {
	return userOrderDao.getUserOrderById(aId);
    }

    @Override
    public Car getCarById(final Long aId) {
	return carDao.getCarById(aId);
    }

    @Override
    public boolean updateUserOrder(final UserOrder userOrder) {
	return userOrderDao.updateUserOrder(userOrder);
    }

    @Override
    public boolean updateCar(final Car car) {
	return carDao.updateCar(car);
    }

}
