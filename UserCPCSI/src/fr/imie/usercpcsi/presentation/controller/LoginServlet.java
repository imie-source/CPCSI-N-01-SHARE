package fr.imie.usercpcsi.presentation.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.usercpcsi.presentation.model.UserData;
import fr.imie.usercpcsi.service.UserServiceInterface;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject @Named("session")
	private UserServiceInterface userService;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * Ce post traite le formulaire de login, vérifie le passw par rapport aux
	 * users en session et stocke ce user en session si passw ok
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("deconnection")!=null) {
			request.getSession().removeAttribute("connectedUser");
			response.sendRedirect("login.html");
		} else {

			// récupération des users en session
//			List<UserData> users = (List<UserData>) request.getSession()
//					.getAttribute("users");
			List<UserData> users = userService.getAllUser();
			// récupération des paramètres de la requête
			String nomParameter = request.getParameter("login");
			String passwParameter = request.getParameter("passw");
			// recherche du user par son nom dans la session
			UserData loginUser = null;
			for (UserData userData : users) {
				if (userData.getNom().compareTo(nomParameter) == 0) {
					loginUser = userData;
				}
			}
			// vérification du passw et renseignement de la session pour stocker
			// l'authentification
			if (loginUser != null
					&& loginUser.getPassw().compareTo(passwParameter) == 0) {
				request.getSession().setAttribute("connectedUser", loginUser);
			} else {
				response.sendRedirect("login.html");
			}
		}

	}

}
