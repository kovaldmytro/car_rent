package com.epam.koval.carrent.db.dao;

import java.util.List;
import com.epam.koval.carrent.db.entity.Car;

/**
 * Car DAO interface.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public interface CarDao {
    /**
     * Insert car.
     * 
     * @param car car to insert
     * @return car
     */
    Car insertCar(Car car);

    /**
     * Updates car`s data.
     * 
     * @param car car to update
     * @return true on success, false on failure
     */
    boolean updateCar(Car car);

    /**
     * Delete car.
     * 
     * @param carId id of car to delete
     * @return true on success, false on failure
     */
    boolean deleteCar(Long carId);

    /**
     * Return all cars.
     * 
     * @return list of cars
     */
    List<Car> getAllCars();

    /**
     * Return all not rented cars.
     * 
     * @return list of cars
     */
    List<Car> getAllNotRentedCars();

    /**
     * Returns car by it`s id.
     * 
     * @param carId carId car`s id
     * @return car model
     */
    Car getCarById(Long carId);

    /**
     * Returns all cars by class.
     * 
     * @param aCarClass class
     * @return list
     */
    List<Car> getAllCarsByClass(String aCarClass);
}
