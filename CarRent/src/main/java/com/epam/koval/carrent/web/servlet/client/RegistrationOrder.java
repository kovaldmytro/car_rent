package com.epam.koval.carrent.web.servlet.client;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import com.epam.koval.carrent.bl.service.ClientService;
import com.epam.koval.carrent.bl.service.ClientServiceImpl;
import com.epam.koval.carrent.bl.util.SumRent;
import com.epam.koval.carrent.db.entity.Car;
import com.epam.koval.carrent.db.entity.Role;
import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.db.entity.UserOrder;
import com.epam.koval.carrent.web.bean.UserOrderBean;
import com.epam.koval.carrent.web.bean.extractor.UserOrderBeanExtractor;

/**
 * Servlet implementation class RegistrationOrder.
 */
public class RegistrationOrder extends HttpServlet {

    /** ID. */
    private static final long serialVersionUID = -5990682962838850329L;

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(RegistrationOrder.class);

    /** Car id. */
    private Long carId = null;

    /** Client id. */
    private Long clientId = null;

    /** Client service. */
    private ClientService clientService = new ClientServiceImpl();

    /** User order bean extractor. */
    private UserOrderBeanExtractor extractor = new UserOrderBeanExtractor();

    @Override
    protected final void doGet(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession sessions = request.getSession();
	User users = (User) sessions.getAttribute("user");
	if (users == null || users.getRole() != Role.client) {
	    response.sendRedirect("/CarRent/error_page.jsp");

	} else if (users.getRole() == Role.client) {
	    HttpSession session = request.getSession(true);
	    LOG.trace("DOGET start.");
	    carId = Long.parseLong(request.getParameter("car_id"));
	    clientId = Long.parseLong(request.getParameter("client_id"));

	    Car car = clientService.getCarById(carId);
	    User user = clientService.getUserById(clientId);

	    session.setAttribute("car", car);
	    session.setAttribute("client", user);
	    RequestDispatcher disp = request
		    .getRequestDispatcher("registration_order.jsp");
	    disp.forward(request, response);
	}
    }

    @Override
    protected final void doPost(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession sessions = request.getSession();
	User user = (User) sessions.getAttribute("user");
	if (user == null || user.getRole() != Role.client) {
	    response.sendRedirect("/CarRent/error_page.jsp");

	} else if (user.getRole() == Role.client) {
	    LOG.debug("RegistrationOrder start.");
	    HttpSession session = request.getSession();
	    UserOrderBean userOrderBean = extractor.extract(request);
	    UserOrder orderAdd = new UserOrder(userOrderBean);

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date today = null;
	    try {
		today = sdf.parse(sdf.format(new Date()));
	    } catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }

	    java.sql.Date sdate = new java.sql.Date(
		    orderAdd.getRentStart().getTime());
	    java.util.Date startdate = new java.util.Date(sdate.getTime());

	    java.sql.Date edate = new java.sql.Date(
		    orderAdd.getRentEnd().getTime());
	    java.util.Date endDate = new java.util.Date(edate.getTime());

	    if (today.before(startdate) || today.equals(startdate)) {
		if (startdate.before(endDate)) {
		    Car car = (Car) session.getAttribute("car");
		    BigDecimal cost = SumRent.sum(orderAdd.getRentStart(),
			    orderAdd.getRentEnd(), car.getCost());
		    session.setAttribute("userOrder", orderAdd);
		    session.setAttribute("sumRent", cost);
		    response.sendRedirect("accept_order");
		} else {
		    response.sendRedirect("error.jsp");
		}
	    } else {
		response.sendRedirect("error.jsp");
	    }
	    LOG.debug("RegistrationOrder finish.");
	}
    }
}
