package com.exam.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyFormServlet
 */
public class Homepagesrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
/**
     * Default constructor. 
     */
    public Homepagesrv() {
        // TODO Auto-generated constructor stub
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
		/*// TODO Auto-generated method stub
		doGet(request, response);*/
		List<String> userNames = new ArrayList<String>();
		HttpSession session = request.getSession();
		if(session.getAttribute("username")!=null){
			userNames=(ArrayList<String>)session.getAttribute("username");	
		}
		String username = request.getParameter("firstname");
		
		if(userNames!=null){
		if(userNames.contains(username)){
			response.getWriter().append("Welcome to my app :" +username);
		}else{
			response.getWriter().append("user invalid, please create new user");
			
								
			}
		}else{
			response.getWriter().append("please add user by clicking below new user link");
		}
	}	
	}


