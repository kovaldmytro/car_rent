package com.epam.koval.carrent.web.bean.extractor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import com.epam.koval.carrent.db.constants.Constants;
import com.epam.koval.carrent.web.bean.CarBean;

/**
 * Car bean extractor implementation.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public class CarBeanExtractor implements BeanExtractor<CarBean> {

    @Override
    public final CarBean extract(final HttpServletRequest request)
	    throws IOException, ServletException {
	String mark = request.getParameter(Constants.CAR_MARK);
	String model = request.getParameter(Constants.CAR_MODEL);
	String cost = request.getParameter(Constants.CAR_COST);
	String carClass = request.getParameter(Constants.CAR_CLASS);
	String rented = request.getParameter(Constants.CAR_RENTED);
	return new CarBean(mark, model, carClass, cost, rented);
    }
}
