package com.epam.koval.carrent.web.bean.extractor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.epam.koval.carrent.db.constants.Constants;
import com.epam.koval.carrent.web.bean.UserLoginBean;

/**
 * User login bean extractor implementation.
 * 
 * @author Koval Dmitry
 * @version 1.0
 */
public class UserLoginBeanExtractor implements BeanExtractor<UserLoginBean> {

    @Override
    public final UserLoginBean extract(final HttpServletRequest request)
	    throws IOException, ServletException {
	String email = request.getParameter(Constants.USER_EMAIL);
	String password = request.getParameter(Constants.USER_PASSWORD);
	return new UserLoginBean(email, password);
    }
}
