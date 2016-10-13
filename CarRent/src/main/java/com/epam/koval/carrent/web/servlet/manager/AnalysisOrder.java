package com.epam.koval.carrent.web.servlet.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.koval.carrent.bl.service.AbstractService;
import com.epam.koval.carrent.bl.service.AbstractServiceImpl;
import com.epam.koval.carrent.bl.service.ManagerService;
import com.epam.koval.carrent.bl.service.ManagerServiceImpl;
import com.epam.koval.carrent.db.entity.Role;
import com.epam.koval.carrent.db.entity.User;

/**
 * Servlet implementation class AnalysisOrder.
 */
@WebServlet("/AnalysisOrder")
public class AnalysisOrder extends HttpServlet {
    /** ID. */
    private static final long serialVersionUID = 5759142137045537553L;

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(AnalysisOrder.class);

    /** Manager service. */
    private ManagerService managerService = new ManagerServiceImpl();

    /**  */
    private AbstractService abstractService = new AbstractServiceImpl();

    @Override
    protected final void doGet(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	if (user == null || user.getRole() != Role.manager) {
	    response.sendRedirect("/CarRent/error_page.jsp");

	} else if (user.getRole() == Role.manager) {
	    LOG.debug("DOGET AnalysisOrder");
	    abstractService.updateDBStartDate();

	    request.setAttribute("listorders",
		    managerService.getAllUserOrder());
	    RequestDispatcher disp = request
		    .getRequestDispatcher("/manager/list_orders.jsp");
	    disp.forward(request, response);
	}
    }
}
