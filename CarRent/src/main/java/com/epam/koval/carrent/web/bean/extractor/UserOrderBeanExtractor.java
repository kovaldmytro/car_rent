package com.epam.koval.carrent.web.bean.extractor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import com.epam.koval.carrent.db.constants.Constants;
import com.epam.koval.carrent.web.bean.UserOrderBean;

/**
 * User order bean extractor implementation.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class UserOrderBeanExtractor
	implements BeanExtractor<UserOrderBean> {

    @Override
    public UserOrderBean extract(final HttpServletRequest request)
	    throws IOException, ServletException {

	String clientId = request.getParameter(Constants.USER_ORDER_CLIENT_ID);
	String carId = request.getParameter(Constants.USER_ORDER_CAR_ID);
	String passportData = request
		.getParameter(Constants.USER_ORDER_PASSPORT_DATA);
	String withDriver = request
		.getParameter(Constants.USER_ORDER_WITH_DRIVER);
	String rentStart = request
		.getParameter(Constants.USER_ORDER_RENT_START);
	String rentEnd = request.getParameter(Constants.USER_ORDER_RENT_END);

	return new UserOrderBean(clientId, carId, passportData, withDriver,
		rentStart, rentEnd);

    }
}
