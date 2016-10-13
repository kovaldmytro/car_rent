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
import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.db.entity.UserOrder;
import com.epam.koval.carrent.web.bean.UserOrderViewBean;

/**
 * Client service implementation.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class ClientServiceImpl implements ClientService {

    /** Car DAO. */
    private CarDao carDao = null;

    /** UserOrder DAO. */
    private UserOrderDao userOrderDao = null;

    /** User DAO. */
    private UserDao userDao = null;

    /**
     * Constructor.
     */
    public ClientServiceImpl() {
	this.carDao = DaoFactory.getDaoFactory(FactoryType.MYSQL).getCarDao();
	this.userOrderDao = DaoFactory.getDaoFactory(FactoryType.MYSQL)
		.getUserOrderDao();
	this.userDao = DaoFactory.getDaoFactory(FactoryType.MYSQL).getUserDao();
    }

    @Override
    public List<Car> getAllCars() {
	return carDao.getAllCars();
    }

    @Override
    public List<UserOrderViewBean> getClientOrders(final Long clientId) {
	List<UserOrder> orders = userOrderDao.getAllClientUserOrder(clientId);
	List<UserOrderViewBean> listViewBean = new ArrayList<UserOrderViewBean>();
	User user = null;
	Car car = null;
	for (UserOrder order : orders) {
	    car = carDao.getCarById(order.getCarId());
	    user = userDao.getUserById(order.getClientId());
	    BigDecimal sumRent = SumRent.sum(order.getRentStart(),
		    order.getRentEnd(), car.getCost());
	    listViewBean.add(
		    new UserOrderViewBean(order, car, user, sumRent, null));
	}
	return listViewBean;
    }

    @Override
    public List<Car> getAllCarsNotRented() {
	return carDao.getAllNotRentedCars();
    }

    @Override
    public Car getCarById(final Long aId) {
	return carDao.getCarById(aId);
    }

    @Override
    public UserOrder addUserOrder(final UserOrder userOrder) {
	return userOrderDao.insert(userOrder);
    }

    @Override
    public User getUserById(final Long aId) {
	return userDao.getUserById(aId);
    }

    @Override
    public UserOrder getUserOrderById(final Long aId) {
	return userOrderDao.getUserOrderById(aId);
    }

    @Override
    public boolean updateUserOrder(final UserOrder order) {
	return userOrderDao.updateUserOrder(order);
    }

    @Override
    public List<Car> getCarsByClass(final String carClass) {
	return carDao.getAllCarsByClass(carClass);
    }

}
