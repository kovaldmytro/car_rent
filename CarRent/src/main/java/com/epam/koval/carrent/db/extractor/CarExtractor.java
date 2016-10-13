package com.epam.koval.carrent.db.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.koval.carrent.db.constants.Constants;
import com.epam.koval.carrent.db.entity.Car;

/**
 * Car extractor.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public class CarExtractor implements Extractor<Car> {

    @Override
    public final Car extract(final ResultSet rs) throws SQLException {
	Car car = new Car();
	car.setId(rs.getLong(Constants.CAR_ID));
	car.setMark(rs.getString(Constants.CAR_MARK));
	car.setModel(rs.getString(Constants.CAR_MODEL));
	car.setCarClass(rs.getString(Constants.CAR_CLASS));
	car.setCost(rs.getBigDecimal(Constants.CAR_COST));
	car.setRented(rs.getBoolean(Constants.CAR_RENTED));
	return car;
    }
}
