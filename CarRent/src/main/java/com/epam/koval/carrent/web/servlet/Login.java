package com.epam.koval.carrent.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.koval.carrent.bl.service.UserService;
import com.epam.koval.carrent.bl.service.UserServiceImpl;
import com.epam.koval.carrent.db.entity.Role;
import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.web.bean.UserLoginBean;
import com.epam.koval.carrent.web.bean.extractor.UserLoginBeanExtractor;

/**
 * Servlet implementation class Login.
 */
public class Login extends HttpServlet {
    /** ID. */
    private static final long serialVersionUID = -1194817433319283773L;

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(Login.class);

    /** User service. */
    private UserService userService = new UserServiceImpl();

    /** User login bean extractor. */
    private UserLoginBeanExtractor extractor = new UserLoginBeanExtractor();

    @Override
    protected final void doPost(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	LOG.debug("Action starts.");
	UserLoginBean userLoginBean = extractor.extract(request);
	User user = null;
	user = userService.login(userLoginBean);

	if (user != null) {
	    if (!user.isBlocked()) {
		HttpSession session = request.getSession(true);
		if (user.getRole() == Role.admin) {
		    response.sendRedirect("admin/cars");
		} else if (user.getRole() == Role.client) {
		    response.sendRedirect("client/cars");
		} else if (user.getRole() == Role.manager) {
		    response.sendRedirect("manager/orders");
		}
		session.setAttribute("user", user);
	    } else {
		response.sendRedirect("/CarRent/block_page.jsp");
	    }

	} else {
	    response.sendRedirect("login");
	}
	LOG.debug("Command finished.");
    }

    @Override
    protected final void doGet(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	LOG.trace("DOGET");
	RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
	disp.forward(request, response);
    }
}
