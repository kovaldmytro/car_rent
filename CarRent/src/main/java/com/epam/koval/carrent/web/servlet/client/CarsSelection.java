package com.epam.koval.carrent.web.servlet.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.koval.carrent.bl.service.ClientService;
import com.epam.koval.carrent.bl.service.ClientServiceImpl;
import com.epam.koval.carrent.db.entity.Car;

/**
 * Servlet implementation class CarsSelect.
 */
public class CarsSelection extends HttpServlet {
    /** ID. */
    private static final long serialVersionUID = -2698211847901550103L;

    /**  */
    private ClientService clientService = new ClientServiceImpl();

    @Override
    protected final void doGet(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	String carClass = request.getParameter("carClass");
	List<Car> car = clientService.getCarsByClass(carClass);

	HttpSession session = request.getSession();
	session.setAttribute("carsSelection", car);
	RequestDispatcher disp = request
		.getRequestDispatcher("/client/cars_selection.jsp");
	disp.forward(request, response);
    }
}
