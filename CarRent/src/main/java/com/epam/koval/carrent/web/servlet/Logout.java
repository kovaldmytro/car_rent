package com.epam.koval.carrent.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class Logout.
 */
public class Logout extends HttpServlet {

    /** ID. */
    private static final long serialVersionUID = 5118824525034772839L;

    /** Logger. */
    private static final Logger LOG = Logger.getLogger(Logout.class);

    @Override
    protected final void doPost(final HttpServletRequest request,
	    final HttpServletResponse response)
	    throws ServletException, IOException {
	LOG.debug("Command starts");

	HttpSession session = request.getSession(false);
	if (session != null) {
	    session.invalidate();
	    LOG.trace("Session invalidated.");
	}
	response.sendRedirect("login");
	LOG.debug("Command finished");
    }
}
