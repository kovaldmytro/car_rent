package com.epam.koval.carrent.web.servlet.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.koval.carrent.bl.service.ClientService;
import com.epam.koval.carrent.bl.service.ClientServiceImpl;
import com.epam.koval.carrent.db.entity.Role;
import com.epam.koval.carrent.db.entity.User;

/**
 * Servlet implementation class ListCars.
 */
public class SelectCars extends HttpServlet {

    /** ID. */
    private static final long serialVersionUID = 2736186615572333615L;

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(SelectCars.class);

    /** Client service. */
    private ClientService clientService = new ClientServiceImpl();

    @Override
    protected final void doGet(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	if (user == null || user.getRole() != Role.client) {
	    response.sendRedirect("/CarRent/error_page.jsp");

	} else if (user.getRole() == Role.client) {
	    LOG.debug("DOGET start.");
	    request.setAttribute("listcars", clientService.getAllCars());
	    RequestDispatcher disp = request
		    .getRequestDispatcher("/client/list_cars.jsp");
	    disp.forward(request, response);
	}
    }
}
