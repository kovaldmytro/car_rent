package com.epam.koval.carrent.web.bean.extractor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import com.epam.koval.carrent.db.constants.Constants;
import com.epam.koval.carrent.web.bean.UserBean;

/**
 * User bean extractor implementation.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public final class UserBeanExtractor implements BeanExtractor<UserBean> {

    @Override
    public UserBean extract(final HttpServletRequest request)
	    throws IOException, ServletException {
	String email = request.getParameter(Constants.USER_EMAIL);
	String password = request.getParameter(Constants.USER_PASSWORD);
	String name = request.getParameter(Constants.USER_NAME);
	String surname = request.getParameter(Constants.USER_SURNAME);
	return new UserBean(email, password, name, surname);
    }
}
