package controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.FriendsBetsException;
import models.FbsUser;
import services.UserService;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/pages/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ok");
		FbsUser u = new FbsUser(
				request.getParameter("alias")
				, request.getParameter("email")
				, request.getParameter("password")
				);

		Map<String, List<String>> errors = UserService.VALIDATOR.validate(u);

		try {
			if (!errors.isEmpty())
				throw new FriendsBetsException();
			us.newUser(u);
			response.sendRedirect(request.getContextPath());
		} catch (FriendsBetsException e) {
			request.setAttribute("editedMember", u);
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/WEB-INF/jsp/pages/login.jsp").forward(request, response);
			e.printStackTrace();
			return;
		}
	}

}
