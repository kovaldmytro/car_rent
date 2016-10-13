package com.epam.koval.carrent.bl.service;

import java.util.List;

import com.epam.koval.carrent.db.entity.Car;
import com.epam.koval.carrent.db.entity.UserOrder;
import com.epam.koval.carrent.web.bean.UserOrderViewBean;

/**
 * Manager service interface.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public interface ManagerService {

    /**
     * Get all order.
     * 
     * @return list
     */
    List<UserOrderViewBean> getAllUserOrder();

    /**
     * Get user order by id.
     * 
     * @param aId ID
     * @return UserOrder
     */
    UserOrder getUserOrderById(Long aId);

    /**
     * Get car by id.
     * 
     * @param aId ID
     * @return car
     */
    Car getCarById(Long aId);

    /**
     * Updates a car.
     *
     * @param car car to update
     * @return true on success, false - otherwise
     */
    boolean updateCar(Car car);

    /**
     * Updates a user order.
     *
     * @param userOrder order to update
     * @return true on success, false - otherwise
     */
    boolean updateUserOrder(UserOrder userOrder);
}
