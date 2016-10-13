package com.epam.koval.carrent.web.servlet.admin;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import com.epam.koval.carrent.bl.constants.Constants;
import com.epam.koval.carrent.bl.service.AdminService;
import com.epam.koval.carrent.bl.service.AdminServiceImpl;
import com.epam.koval.carrent.bl.util.Sha;
import com.epam.koval.carrent.db.entity.Role;
import com.epam.koval.carrent.db.entity.User;
import com.epam.koval.carrent.web.bean.UserBean;
import com.epam.koval.carrent.web.bean.extractor.UserBeanExtractor;

/**
 * Servlet implementation class AddUser.
 */ 

public class AddManager extends HttpServlet {
    /** ID. */
    private static final long serialVersionUID = 740522884991792775L;

    /** Admin service. */
    private AdminService adminservice = new AdminServiceImpl();

    /** UserBeanExtractor. */
    private UserBeanExtractor extractor = new UserBeanExtractor();

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(AddManager.class);

    @Override
    protected final void doPost(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	if (user == null || user.getRole() != Role.admin) {
	    response.sendRedirect("/CarRent/error_page.jsp");

	} else if (user.getRole() == Role.admin) {
	    LOG.debug("AddUser start.");
	    UserBean userBean = extractor.extract(request);
	    String password = request.getParameter("password");
	    String passwordHash = null;
	    try {
		passwordHash = Sha.md5(password);
	    } catch (NoSuchAlgorithmException e) {
		LOG.error(Constants.ERROR_SHA_PASSWORD);
		throw new RuntimeException();
	    }
	    User userAdd = new User(userBean, passwordHash, Role.manager);
	    adminservice.addUser(userAdd);
	    response.sendRedirect("users");
	    LOG.debug("AddUser finish.");
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
	    LOG.trace("DOGET AddManager");
	    RequestDispatcher disp = request
		    .getRequestDispatcher("/admin/add_manager.jsp");
	    disp.forward(request, response);
	}
    }
}
