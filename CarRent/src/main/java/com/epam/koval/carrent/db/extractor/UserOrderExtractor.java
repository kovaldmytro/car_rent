package com.epam.koval.carrent.db.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.epam.koval.carrent.db.constants.Constants;
import com.epam.koval.carrent.db.entity.UserOrder;

/**
 * User order extractor.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public class UserOrderExtractor implements Extractor<UserOrder> {

    @Override
    public final UserOrder extract(final ResultSet rs) throws SQLException {
	UserOrder userOrder = new UserOrder();
	userOrder.setId(rs.getLong(Constants.USER_ORDER_ID));
	userOrder.setClientId(rs.getLong(Constants.USER_ORDER_CLIENT_ID));
	userOrder.setCarId(rs.getLong(Constants.USER_ORDER_CAR_ID));
	userOrder.setPassportData(
		rs.getString(Constants.USER_ORDER_PASSPORT_DATA));
	userOrder
		.setWithDriver(rs.getBoolean(Constants.USER_ORDER_WITH_DRIVER));
	userOrder.setRentStart(rs.getDate(Constants.USER_ORDER_RENT_START));
	userOrder.setRentEnd(rs.getDate(Constants.USER_ORDER_RENT_END));
	userOrder.setStatus(rs.getString(Constants.USER_ORDER_STATUS));
	return userOrder;
    }
}
