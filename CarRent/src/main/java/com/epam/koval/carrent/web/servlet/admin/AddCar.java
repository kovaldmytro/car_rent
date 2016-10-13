package com.epam.koval.carrent.web.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.koval.carrent.bl.service.AdminService;
import com.epam.koval.carrent.bl.service.AdminServiceImpl;
import com.epam.koval.carrent.db.entity.Car;
import com.epam.koval.carrent.db.entity.Role;
import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.web.bean.CarBean;
import com.epam.koval.carrent.web.bean.extractor.CarBeanExtractor;

/**
 * Servlet implementation class AddCars.
 */

public class AddCar extends HttpServlet {
    /** ID. */
    private static final long serialVersionUID = 1L;

    /** Admin service. */
    private AdminService adminservice = new AdminServiceImpl();

    /** Car bean extractor. */
    private CarBeanExtractor extractor = new CarBeanExtractor();

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(AddCar.class);

    @Override
    protected final void doPost(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	if (user == null || user.getRole() != Role.admin) {
	    response.sendRedirect("/CarRent/error_page.jsp");

	} else if (user.getRole() == Role.admin) {
	    LOG.debug("AddCars start.");
	    CarBean carBean = extractor.extract(request);
	    Car carAdd = new Car(carBean);
	    adminservice.addCar(carAdd);
	    response.sendRedirect("cars");
	    LOG.debug("AddCars finish.");
	}
    }

    @Override
    protected final void doGet(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	if (user == null || user.getRole() != Role.admin) {
	    response.sendRedirect("/CarRent/error_page.jsp");

	} else if (user.getRole() == Role.admin) {
	    LOG.trace("DOGET AddCar");
	    RequestDispatcher disp = request
		    .getRequestDispatcher("/admin/add_car.jsp");
	    disp.forward(request, response);
	}
    }
}
