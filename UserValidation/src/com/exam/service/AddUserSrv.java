package com.exam.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyFormServlet
 */
public class AddUserSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<String> userNames=new ArrayList<String>();
	
    /**
     * Default constructor. 
     */
    public AddUserSrv() {
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		HttpSession session = request.getSession(true);
		String username = request.getParameter("firstname");
		
		List<String> restricteds=(ArrayList<String>)request.getServletContext().getAttribute("restricted");
		request.getServletContext().setAttribute("restricted", restricteds);
		RandomStringGeneration combination =new RandomStringGeneration();


		for (Entry<Boolean, List<String>> entry : combination.generateRandom(username, restricteds,Boolean.TRUE).entrySet()) {
			if (!entry.getKey()) {
				for (Entry<Boolean, List<String>> entry1 : combination.generateRandom(username, userNames,Boolean.FALSE)
						.entrySet()) {
					if (entry1.getKey()) {
						String message = "user name already exist , please choose different combination \n"
								+ entry.getValue();
						request.setAttribute("message", message);
						request.getRequestDispatcher("./addUser.jsp").forward(request, response);
					}else{
						userNames.add(username);
						session.setAttribute("username", userNames);
						String message="user added successfully";
						 request.setAttribute("message", message);
					     request.getRequestDispatcher("./addUser.jsp").forward(request, response);			
						}
				}
			} else {
				String message = "user provided is an restricted user, Please try different combination \n"
						+ entry.getValue();
				request.setAttribute("message", message);
				request.getRequestDispatcher("./addUser.jsp").forward(request, response);
			}
		}
	}
	}


