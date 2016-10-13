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
 * Servlet implementation class MyOrder.
 */

public class ClientOrders extends HttpServlet {

    /** ID. */
    private static final long serialVersionUID = -4750984031886284450L;

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(ClientOrders.class);

    /** Client service. */
    private ClientService clientService = new ClientServiceImpl();

    @Override
    protected final void doGet(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession sessions = request.getSession();
	User users = (User) sessions.getAttribute("user");
	if (users == null || users.getRole() != Role.client) {
	    response.sendRedirect("/CarRent/error_page.jsp");

	} else if (users.getRole() == Role.client) {
	    LOG.debug("DOGET start.");
	    HttpSession session = request.getSession(true);
	    User user = (User) session.getAttribute("user");

	    session.setAttribute("listorder",
		    clientService.getClientOrders(user.getId()));
	    RequestDispatcher dispatcher = request
		    .getRequestDispatcher("client_orders.jsp");
	    dispatcher.forward(request, response);
	}
    }
}
