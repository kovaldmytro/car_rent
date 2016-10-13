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
 * Servlet implementation class EditCar.
 */
/**
 * @author Koval Dmitry
 * @version 1.0
 */
public class EditCar extends HttpServlet {

    /** ID. */
    private static final long serialVersionUID = 4743364451730975172L;

    /** Admin service. */
    private AdminService adminService = new AdminServiceImpl();

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(EditCar.class);

    /** Car id. */
    private Long carId = null;

    /** Car bean extractor. */
    private CarBeanExtractor extractor = new CarBeanExtractor();

    @Override
    protected final void doPost(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	if (user == null || user.getRole() != Role.admin) {
	    response.sendRedirect("/CarRent/error_page.jsp");

	} else if (user.getRole() == Role.admin) {
	    CarBean car = extractor.extract(request);
	    Car carEdit = new Car(car);
	    carEdit.setId(carId);
	    adminService.updateCar(carEdit);
	    response.sendRedirect("cars");
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
	    LOG.trace("DOGET EditCar start.");
	    carId = Long.parseLong(request.getParameter("carId"));
	    Car car = adminService.getCarById(carId);
	    request.setAttribute("car", car);
	    RequestDispatcher disp = request
		    .getRequestDispatcher("/admin/edit_car.jsp");
	    disp.forward(request, response);
	    LOG.trace("DOGET EditCar finish.");
	}
    }
}
