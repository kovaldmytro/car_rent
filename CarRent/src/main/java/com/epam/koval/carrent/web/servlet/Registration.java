package com.epam.koval.carrent.web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.epam.koval.carrent.bl.service.UserService;
import com.epam.koval.carrent.bl.service.UserServiceImpl;
import com.epam.koval.carrent.web.bean.UserBean;
import com.epam.koval.carrent.web.bean.extractor.UserBeanExtractor;

/**
 * Servlet implementation class Registration.
 */
public class Registration extends HttpServlet {
    /** ID. */
    private static final long serialVersionUID = 1L;

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(Registration.class);

    /** User service. */
    private UserService userService = new UserServiceImpl();

    /** User login bean extractor. */
    private UserBeanExtractor extractor = new UserBeanExtractor();

    @Override
    protected final void doGet(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	LOG.debug("DOGET starts.");
	RequestDispatcher disp = request
		.getRequestDispatcher("registration.jsp");
	disp.forward(request, response);
    }

    @Override
    protected final void doPost(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	UserBean userBean = extractor.extract(request);
	userService.registration(userBean);
	response.sendRedirect("login");
    }
}
