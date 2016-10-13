package com.epam.koval.carrent.db.dao;

import java.util.List;
import com.epam.koval.carrent.db.entity.UserOrder;

/**
 * User order DAO interface.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public interface UserOrderDao {
    /**
     * Insert user order.
     * 
     * @param userOrder user order to insert
     * @return user order
     */
    UserOrder insert(UserOrder userOrder);

    /**
     * Update user order.
     * 
     * @param userOrder user order to update
     * @return true on success, false on failure
     */
    boolean updateUserOrder(UserOrder userOrder);

    /**
     * Delete user order.
     * 
     * @param userOrderId id user order
     * @return true on success, false on failure
     */
    boolean deleteUserOrder(Long userOrderId);

    /**
     * Returns all user order.
     * 
     * @return list of cars
     */
    List<UserOrder> getAllUserOrder();

    /**
     * Returns car by it`s id.
     * 
     * @param userOrderId id user order
     * @return user order
     */
    UserOrder getUserOrderById(Long userOrderId);

    /**
     * Returns all client user order.
     * 
     * @param clientId ID client
     * @return list of order
     */
    List<UserOrder> getAllClientUserOrder(Long clientId);
}
