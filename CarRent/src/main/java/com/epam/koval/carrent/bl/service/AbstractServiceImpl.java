package com.epam.koval.carrent.bl.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.epam.koval.carrent.db.dao.CarDao;
import com.epam.koval.carrent.db.dao.DaoFactory;
import com.epam.koval.carrent.db.dao.FactoryType;
import com.epam.koval.carrent.db.dao.UserOrderDao;
import com.epam.koval.carrent.db.entity.Car;
import com.epam.koval.carrent.db.entity.Status;
import com.epam.koval.carrent.db.entity.UserOrder;

/**
 * Abstract service implementation.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class AbstractServiceImpl implements AbstractService {

    /** Car DAO. */
    private CarDao carDao = null;

    /** User order DAO. */
    private UserOrderDao userOrderDao = null;

    /**
     * Constructor.
     */
    public AbstractServiceImpl() {
	this.carDao = DaoFactory.getDaoFactory(FactoryType.MYSQL).getCarDao();
	this.userOrderDao = DaoFactory.getDaoFactory(FactoryType.MYSQL)
		.getUserOrderDao();
    }

    @Override
    public void updateDBStartDate() {
	List<UserOrder> listOrders = userOrderDao.getAllUserOrder();
	Car car = null;
	UserOrder order = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date today = null;
	try {
	    today = sdf.parse(sdf.format(new Date()));
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	for (UserOrder list : listOrders) {

	    if (today.equals(list.getRentStart())
		    & list.getStatus() == Status.paid) {
		car = carDao.getCarById(list.getCarId());
		car.setRented(true);
		carDao.updateCar(car);
	    }

	    if (today.equals(list.getRentEnd())) {
		car = carDao.getCarById(list.getCarId());
		order = userOrderDao.getUserOrderById(list.getId());

		car.setRented(false);
		order.setStatus(Status.close);

		carDao.updateCar(car);
		userOrderDao.updateUserOrder(order);
	    }
	}
    }
}
