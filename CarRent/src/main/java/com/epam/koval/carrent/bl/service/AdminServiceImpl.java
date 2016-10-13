package com.epam.koval.carrent.bl.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.epam.koval.carrent.bl.util.SumRent;
import com.epam.koval.carrent.db.dao.CarDao;
import com.epam.koval.carrent.db.dao.DaoFactory;
import com.epam.koval.carrent.db.dao.FactoryType;
import com.epam.koval.carrent.db.dao.UserDao;
import com.epam.koval.carrent.db.dao.UserOrderDao;
import com.epam.koval.carrent.db.entity.Car;
import com.epam.koval.carrent.db.entity.Role;
import com.epam.koval.carrent.db.entity.Status;
import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.db.entity.UserOrder;
import com.epam.koval.carrent.web.bean.UserOrderViewBean;

/**
 * Admin service implementation.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class AdminServiceImpl implements AdminService {

    /** Car DAO. */
    private CarDao carDao = null;

    /** User DAO. */
    private UserDao userDao = null;

    /** User order DAO. */
    private UserOrderDao userOrderDao = null;

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(AdminServiceImpl.class);

    /**
     * Constructor.
     */
    public AdminServiceImpl() {
	this.carDao = DaoFactory.getDaoFactory(FactoryType.MYSQL).getCarDao();
	this.userDao = DaoFactory.getDaoFactory(FactoryType.MYSQL).getUserDao();
	this.userOrderDao = DaoFactory.getDaoFactory(FactoryType.MYSQL)
		.getUserOrderDao();
    }

    @Override
    public User addUser(final User user) {
	return userDao.insertUser(user);
    }

    @Override
    public Car addCar(final Car car) {
	return carDao.insertCar(car);
    }

    @Override
    public boolean updateCar(final Car car) {
	return carDao.updateCar(car);
    }

    @Override
    public boolean deleteCar(final Long carId) {
	return carDao.deleteCar(carId);
    }

    @Override
    public boolean blockUser(final Long userId) {
	LOG.debug("Start with info:" + userId);
	User user = userDao.getUserById(userId);
	if (user.getRole() != Role.admin) {
	    if (user.isBlocked()) {
		user.setBlocked(false);
	    } else {
		user.setBlocked(true);
	    }
	}
	userDao.updateUser(user);
	LOG.debug("Done.");
	LOG.info(user);
	return true;
    }

    @Override
    public List<Car> getAllCars() {
	return carDao.getAllCars();
    }

    @Override
    public List<User> getAllUsers() {
	return userDao.getAllUsers();
    }

    @Override
    public Car getCarById(final Long carId) {
	return carDao.getCarById(carId);
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
    public List<UserOrderViewBean> getAllUsersCount() {
	List<UserOrderViewBean> listUserOrder = getAllUserOrder();
	List<UserOrderViewBean> listUsersCount = new ArrayList<UserOrderViewBean>();

	List<User> listOrders = userDao.getAllUsers();

	for (User users : listOrders) {
	    users = userDao.getUserById(users.getId());
	    Integer count = 0;
	    BigDecimal sum = new BigDecimal(0);

	    for (UserOrderViewBean order : listUserOrder) {
		if (users.getId() == order.getUser().getId()) {
		    sum = order.getRentSum().add(sum);
		    count++;
		}
	    }
	    if (users.getRole() == Role.client) {
		listUsersCount.add(new UserOrderViewBean(users, count, sum));
	    }
	}
	return listUsersCount;
    }
}
