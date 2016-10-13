package com.epam.koval.carrent.bl.service;

import java.util.List;
import com.epam.koval.carrent.db.entity.Car;
import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.db.entity.UserOrder;
import com.epam.koval.carrent.web.bean.UserOrderViewBean;

/**
 * Client service interface.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public interface ClientService {
    /**
     * List of cars.
     * 
     * @return list
     */
    List<Car> getAllCarsNotRented();

    /**
     * List of cars.
     * 
     * @return list
     */
    List<Car> getAllCars();

    /**
     * Get car by id.
     * 
     * @param aId ID
     * @return car
     */
    Car getCarById(Long aId);

    /**
     * Update order.
     * 
     * @param order order
     * @return order
     */
    boolean updateUserOrder(UserOrder order);

    /**
     * Get user by id.
     * 
     * @param aId ID
     * @return user
     */
    User getUserById(Long aId);

    /**
     * Gets order by id.
     * 
     * @param aId id
     * @return order
     */
    UserOrder getUserOrderById(Long aId);

    /**
     * Adds a new order.
     * 
     * @param userOrder order
     * @return order
     */
    UserOrder addUserOrder(UserOrder userOrder);

    /**
     * List of user orders.
     * 
     * @param clientId ID client
     * @return list
     */
    List<UserOrderViewBean> getClientOrders(Long clientId);

    /**
     * List of car.
     * 
     * @param carClass car class
     * @return list
     */
    List<Car> getCarsByClass(String carClass);
}
