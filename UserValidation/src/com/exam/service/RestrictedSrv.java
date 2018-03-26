package com.exam.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.util.Util;

/**
 * Servlet implementation class MyFormServlet
 */
public class RestrictedSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	List<String> list;

	
    /**
     * Default constructor. 
     */
    public RestrictedSrv() {
    	
    	
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	//System.out.println("init method..........");
    	 list=Util.getRestrcitedList();
    	 config.getServletContext().setAttribute("restricted", list);
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
		
		HttpSession session = request.getSession();
		
		String username = request.getParameter("firstname");
		
		
		
		if(!list.contains(username)){
			list.add(username);
			//session.setAttribute("restricted", list);
			request.getServletContext().setAttribute("restricted", list);
			String message="resticted user added successfully";
			 request.setAttribute("message", message);
		     request.getRequestDispatcher("./addReUser.jsp").forward(request, response);						
			}else{
				String message="resticted user added already";
				 request.setAttribute("message", message);
				request.getRequestDispatcher("./addReUser.jsp").forward(request, response);	
			}
	}
		}
			
	


