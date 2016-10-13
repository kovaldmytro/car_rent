package com.epam.koval.carrent.web.servlet.admin;

import java.io.IOException;
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
 * Servlet implementation class BlockUser.
 */
public class BlockUser extends HttpServlet {
    /** ID. */
    private static final long serialVersionUID = 1L;

    /** Admin service. */
    private AdminService adminService = new AdminServiceImpl();

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(BlockUser.class);

    @Override
    protected final void doGet(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	if (user == null || user.getRole() != Role.admin) {
	    response.sendRedirect("/CarRent/error_page.jsp");

	} else if (user.getRole() == Role.admin) {
	    LOG.debug("BlockUser start.");
	    Long id = Long.parseLong(request.getParameter("userId"));
	    adminService.blockUser(id);
	    response.sendRedirect("users");
	    LOG.debug("BlockUser finish.");
	}
    }

}
