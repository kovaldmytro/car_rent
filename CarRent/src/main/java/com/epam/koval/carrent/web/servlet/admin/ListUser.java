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
import com.epam.koval.carrent.db.entity.Role;
import com.epam.koval.carrent.db.entity.User;

/**
 * Servlet implementation class ListUser.
 */
public class ListUser extends HttpServlet {
    /** ID. */
    private static final long serialVersionUID = -6854435844454599272L;

    /** Admin service. */
    private AdminService adminServiceImpl = new AdminServiceImpl();

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(ListUser.class);

    @Override
    protected final void doGet(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	if (user == null || user.getRole() != Role.admin) {
	    response.sendRedirect("/CarRent/error_page.jsp");

	} else if (user.getRole() == Role.admin) {
	    LOG.debug("AdminUserList start.");
	    request.setAttribute("allusers", adminServiceImpl.getAllUsers());
	    RequestDispatcher disp = request
		    .getRequestDispatcher("/admin/admin_users.jsp");
	    disp.forward(request, response);
	    LOG.debug("AdminUserList finish.");
	}
    }
}
