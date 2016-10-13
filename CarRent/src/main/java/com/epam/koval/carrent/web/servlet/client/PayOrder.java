package com.epam.koval.carrent.web.servlet.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.koval.carrent.bl.service.ClientService;
import com.epam.koval.carrent.bl.service.ClientServiceImpl;
import com.epam.koval.carrent.db.entity.Role;
import com.epam.koval.carrent.db.entity.Status;
import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.db.entity.UserOrder;

/**
 * Servlet implementation class PayOrder.
 */
public class PayOrder extends HttpServlet {

    /** ID. */
    private static final long serialVersionUID = -104998689125786199L;

    /** Client service. */
    private ClientService client = new ClientServiceImpl();

    @Override
    protected final void doGet(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	if (user == null || user.getRole() != Role.client) {
	    response.sendRedirect("/CarRent/error_page.jsp");

	} else if (user.getRole() == Role.client) {
	    Long orderId = Long.parseLong(request.getParameter("orderId"));
	    UserOrder order = client.getUserOrderById(orderId);
	    order.setStatus(Status.paid);
	    client.updateUserOrder(order);
	    response.sendRedirect("orders");
	}
    }
}
