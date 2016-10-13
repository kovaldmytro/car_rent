package com.epam.koval.carrent.bl.service;

/**
 * Abstract service interface.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public interface AbstractService {
    /**
     * Update car is rented when the day of the order date.
     */
    void updateDBStartDate();
}
