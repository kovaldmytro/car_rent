package com.epam.koval.carrent.web.servlet.admin;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.epam.koval.carrent.bl.service.AdminService;
import com.epam.koval.carrent.bl.service.AdminServiceImpl;

/**
 * Servlet implementation class UserCount.
 */
public class UserCount extends HttpServlet {

    /**  */
    private static final long serialVersionUID = 1L;

    /**  */
    private AdminService adminService = new AdminServiceImpl();

    @Override
    protected final void doGet(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	request.setAttribute("listUsersCount", adminService.getAllUsersCount());
	RequestDispatcher disp = request
		.getRequestDispatcher("/admin/users_count.jsp");
	disp.forward(request, response);
    }
}
