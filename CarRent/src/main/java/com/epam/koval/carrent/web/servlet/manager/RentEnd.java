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
import com.epam.koval.carrent.db.entity.Car;
import com.epam.koval.carrent.db.entity.Role;
import com.epam.koval.carrent.db.entity.Status;
import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.db.entity.UserOrder;

/**
 * Servlet implementation class RentEnd.
 */
public class RentEnd extends HttpServlet {
    /** ID. */
    private static final long serialVersionUID = -6358724664599712104L;

    /** Manager service. */
    private ManagerService manager = new ManagerServiceImpl();

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(RentEnd.class);

    @Override
    protected final void doGet(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	if (user == null || user.getRole() != Role.manager) {
	    response.sendRedirect("/CarRent/error_page.jsp");

	} else if (user.getRole() == Role.manager) {
	    LOG.debug("DOGET start.");
	    Long carId = Long.parseLong(request.getParameter("carId"));
	    Long orderId = Long.parseLong(request.getParameter("orderId"));
	    Car car = manager.getCarById(carId);
	    UserOrder order = manager.getUserOrderById(orderId);

	    order.setStatus(Status.close);
	    car.setRented(false);

	    manager.updateCar(car);
	    manager.updateUserOrder(order);

	    response.sendRedirect("orders");
	}
    }
}
