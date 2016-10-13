package com.epam.koval.carrent.web.servlet.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import com.epam.koval.carrent.bl.service.ManagerService;
import com.epam.koval.carrent.bl.service.ManagerServiceImpl;
import com.epam.koval.carrent.db.entity.Role;
import com.epam.koval.carrent.db.entity.Status;
import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.db.entity.UserOrder;

/**
 * Servlet implementation class CancelOrder.
 */

public class CancelOrder extends HttpServlet {

    /** ID. */
    private static final long serialVersionUID = -8113712418035210327L;

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(CancelOrder.class);

    /** Manager service. */
    private ManagerService managerService = new ManagerServiceImpl();

    @Override
    protected final void doGet(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	if (user == null || user.getRole() != Role.manager) {
	    response.sendRedirect("/CarRent/error_page.jsp");

	} else if (user.getRole() == Role.manager) {
	    LOG.debug("DOGET CancelOrder start.");
	    Long orderId = Long.parseLong(request.getParameter("orderId"));

	    UserOrder userOrder = managerService.getUserOrderById(orderId);
	    userOrder.setStatus(Status.cancel);

	    managerService.updateUserOrder(userOrder);
	    response.sendRedirect("orders");
	    LOG.debug("DOGET CancelOrder finish.");
	}
    }
}
