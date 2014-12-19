package fr.imie.usercpcsi.presentation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.usercpcsi.presentation.model.Faction;
import fr.imie.usercpcsi.presentation.model.UserData;
import fr.imie.usercpcsi.service.UserServiceInterface;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject @Named("session")
	UserServiceInterface userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		List<UserData> users = (List<UserData>) request.getSession()
//				.getAttribute("users");
		List<UserData> users = userService.getAllUser();
		
		request.setAttribute("filteredUsers", users);
		request.getRequestDispatcher("WEB-INF/user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		List<UserData> users = (List<UserData>) request.getSession()
//				.getAttribute("users");
		List<UserData> users=userService.getAllUser();
		List<UserData> filteredUsers = new ArrayList<UserData>();
		
		String factionParameter = request.getParameter("faction");
		
		Faction faction =null;
		
		if(factionParameter!=null){
			faction = Faction.valueOf(factionParameter);
			//request.setAttribute("factionParameter", factionParameter);
		}
		
		for (UserData userData : users) {
			if(faction==null || userData.getFaction().equals(faction)){
				filteredUsers.add(userData);
			}
		}
		
		request.setAttribute("filteredUsers", filteredUsers);
		
		request.getRequestDispatcher("WEB-INF/user.jsp").forward(request, response);
	}

}
