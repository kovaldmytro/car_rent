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
import com.epam.koval.carrent.db.entity.UserOrder;

/**
 * Servlet implementation class AcceptOrder.
 */
public class AcceptOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(AcceptOrder.class);

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
	    RequestDispatcher dispatcher = request
		    .getRequestDispatcher("accept_order.jsp");
	    dispatcher.forward(request, response);
	}
    }

    @Override
    protected final void doPost(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	LOG.debug("DOGET start.");
	HttpSession session = request.getSession();
	UserOrder userOrder = (UserOrder) session.getAttribute("userOrder");
	clientService.addUserOrder(userOrder);
	response.sendRedirect("orders");
    }
}
