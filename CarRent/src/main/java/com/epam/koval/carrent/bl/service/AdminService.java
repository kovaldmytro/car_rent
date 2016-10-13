package com.epam.koval.carrent.bl.service;

import java.util.List;
import com.epam.koval.carrent.db.entity.Car;
import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.web.bean.UserOrderViewBean;

/**
 * Admin service interface.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public interface AdminService {
    /**
     * Adds a new car.
     *
     * @param car car to add
     * @return true on success, false on failure
     */
    Car addCar(Car car);

    /**
     * Adds a new user.
     * 
     * @param user user
     * @return user
     */
    User addUser(User user);

    /**
     * Updates a car.
     *
     * @param car car to update
     * @return true on success, false - otherwise
     */
    boolean updateCar(Car car);

    /**
     * Deletes user.
     *
     * @param carId car id
     * @return true on success, false on failure
     */
    boolean deleteCar(Long carId);

    /**
     * Block user.
     * 
     * @param userId user
     * @return true on success, false on failure
     */
    boolean blockUser(Long userId);

    /**
     * List of cars.
     * 
     * @return list
     */
    List<Car> getAllCars();

    /**
     * List of users.
     * 
     * @return list
     */
    List<User> getAllUsers();

    /**
     * List of users count.
     * 
     * @return list
     */
    List<UserOrderViewBean> getAllUsersCount();

    /**
     * Get all order.
     * 
     * @return list
     */
    List<UserOrderViewBean> getAllUserOrder();

    /**
     * Returns car.
     *
     * @param carId car id
     * @return car
     */
    Car getCarById(Long carId);
}
